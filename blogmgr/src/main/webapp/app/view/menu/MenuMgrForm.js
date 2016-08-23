/**
 * 菜单添加表单
 */
Ext.define('BlogMgr.view.menu.MenuMgrForm', {
			itemId : 'menuMgrForm',
			extend : 'Ext.form.Panel',
			alias : ['widget.menumgr_form'],
			waitTitle : '处理中...',
			fileUpload : false,
			defaults : {
				layout : 'anchor',
				collapsible : false,
				defaultType : 'textfield'
			},
			items : [{
						title : '必填信息',
						xtype : 'fieldset',
						defaults : {
							anchor : '100%',
							labelAlign : 'right',
							labelWidth : 70,
							allowBlank : false
						},
						items : [{
							fieldLabel : '父级菜单',
							name:'fParentId',
							xtype:'treepicker',
							emptyText:'请选择',
							store:Ext.getStore('menuTreeStore'),
							allowBlank : true,
							listeners:{
								change:'parentMenuSelect'
							}
						},{
							xtype : 'fieldcontainer',
							layout : 'hbox',
							defaults : {
								labelAlign : 'right',
								labelWidth : 70,
								xtype : 'textfield'
							},
							items : [{
								fieldLabel : '菜单代码',
								width : '70%',
								emptyText:'代码前缀',
								reference: 'menuMgrFormPreCode',
								editable : false,
								submitValue:false
							},{
								name:'fId',
								allowBlank : false,
								width : '29.7%',
								emptyText:'菜单代码',
								maxLength:4,
								vtype:'alphanum',
								getSubmitValue:function(){	
									var me = this;
									return Ext.callback('fIdSubmitValue', me.scope, [me.getValue()], 0,me);
								}
							}]
						},{
							fieldLabel : '菜单名称',
							name:'fName',
							emptyText:'必须是中文',
							maxLength:10,
							minLength:2,
							vtype:'chinese'
						},{
							fieldLabel : '菜单排序',
							name:'fOrder',
							xtype:'numberfield',
							minValue :0,
							maxValue :100,
							allowDecimals:false,
							emptyText:'0 - 100'
						},{
							fieldLabel : '菜单类型',
							name:'fType',
							xtype : 'combo',
							store : {
								fields : ['value', 'name'],
								data : [{
											"value" : "NAVIGATOR",
											"name" : "导航菜单"
										}, {
											"value" : "TOOLBAR",
											"name" : "工具栏"
										}]
							},
							displayField : 'name',
							valueField : 'value',
							value : 'NAVIGATOR',
							editable : false
							
						},{
							fieldLabel : '是否可用',
		                    xtype: 'checkboxfield',
							boxLabel  : '可用性',
		                    name      : 'fUsability',
		                    inputValue: 'ENABLE',
		                    uncheckedValue:'DISABLE',
		                    checked:true
						}]
					},{
						title : '缺省信息',
						xtype : 'fieldset',
						defaults : {
							anchor : '100%',
							labelAlign : 'right',
							labelWidth : 70
						},
						items : [{
							fieldLabel : '图标',
							name:'fGlyph'
						},{
							fieldLabel : '视图类',
							name:'fViewClass',
							vtype:'letter'
						},{
							fieldLabel : '链接',
							name:'fUrl'
						},{
							fieldLabel : '菜单描述',
							name : 'fDescr',
							xtype : 'textarea',
							maxLength:150,
							grow : true,
							growMax : 200,
							labelWidth : 70,
							labelAlign : 'right',
							growMin : 100,
							emptyText:'最多150个字'
						}]
					}]

		});