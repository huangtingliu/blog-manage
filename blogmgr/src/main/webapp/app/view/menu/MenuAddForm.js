/**
 * 菜单添加表单
 */
Ext.define('BlogMgr.view.menu.MenuAddForm', {
			itemId : 'menuAddForm',
			extend : 'Ext.form.Panel',
			alias : ['widget.menuadd_form'],
			url : '/blogmgr/menu/add.do',
			method : 'POST',
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
							name:'accountType'						
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
								name:'accountType',
								emptyText:'代码前缀',
								editable : false
							},{
								name:'accountType',
								allowBlank : false,
								width : '29.7%'
							}]
						},{
							fieldLabel : '菜单名称',
							name:'accountType'
						},{
							fieldLabel : '菜单排序',
							name:'accountType'
						},{
							fieldLabel : '菜单类型',
							name:'accountType'
						},{
							fieldLabel : '是否可用',
		                    xtype: 'checkboxfield',
							boxLabel  : '可用',
		                    name      : 'topping',
		                    inputValue: '2',
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
							name:'accountType'
						},{
							fieldLabel : '视图类',
							name:'accountType'
						},{
							fieldLabel : '链接',
							name:'accountType'
						},{
							fieldLabel : '菜单描述',
							xtype : 'textarea',
							maxLength:150,
							grow : true,
							growMax : 200,
							labelWidth : 70,
							labelAlign : 'right',
							growMin : 100,
							emptyText:'最多150个字',
							name : 'fDescr'
						}]
					}]

		});