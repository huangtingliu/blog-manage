/**
 * 功能添加表单
 */
Ext.define('BlogMgr.view.fun.mgr.FunctionMgrForm', {
			itemId : 'functionMgrForm',
			extend : 'Ext.form.Panel',
			alias : ['widget.functionmgr_form'],
			uses:['BlogMgr.store.FunctionTreeStore'],
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
							fieldLabel : '所属上级',
							name:'fParentId',
							bind:{
								readOnly :'{form.fParentIdReadOnly}'
							},
							xtype:'treepicker',
							emptyText:'请选择',
							store:Ext.getStore('treePickerStroe'),
							root : {
								expanded : true //如果展开就会自动加载
							},
							allowBlank : true,
							listeners:{
								change:'parentFunctionSelect'
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
								fieldLabel : '功能代码',
								width : '70%',
								emptyText:'代码前缀',
								reference: 'functionMgrFormPreCode',
								editable : false,
								submitValue:false
							},{
								name:'fId',
								allowBlank : false,
								width : '29.9%',
								bind:{
									editable : '{form.fIdEditable}'
								},
								emptyText:'代码',
								maxLength:4,
								vtype : 'alphanum',
								getSubmitValue:function(){	
									var me = this;
									return Ext.callback('fIdSubmitValue', me.scope, [me.getValue()], 0,me);
								}
							}]
						},{
							fieldLabel : '功能名称',
							name:'fName',
							emptyText:'必须是中文',
							maxLength:10,
							minLength:2,
							vtype:'chinese'
						},{
							fieldLabel : '功能排序',
							name:'fOrder',
							xtype:'numberfield',
							value:0,
							minValue :0,
							maxValue :100,
							allowDecimals:false,
							emptyText:'0 - 100'
						},{
							fieldLabel : '功能类型',
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
										}, {
											"value" : "UNIT",
											"name" : "单元"
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
							name:'fGlyph',
							value:58917
						},{
							fieldLabel : '处理方式',
							name:'fHandler',
							vtype:'letter'
						},{
							fieldLabel : '关联',
							name:'fRelevance'
						},{
							fieldLabel : '功能描述',
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