/**
 * 用户信息表单
 */
Ext.define('BlogMgr.view.mgruser.UserAddInfo', {
			itemId : 'userAddInfo',
			extend : 'Ext.form.Panel',
			alias : ['widget.mgruseradd_userinfo'],
			title : '用户信息',
			url:'aa.do',
			method:'POST',
			defaults:{
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
							labelWidth : 50,
							allowBlank: false
						},
						items : [{
									fieldLabel : '账号',
									name : 'account'
								}, {
									fieldLabel : '密码',
									inputType : 'password',
									name : 'pwd'
								}]
					}, {
						title : '附加信息',
						xtype : 'fieldset',
						defaults : {
							anchor : '100%'
						},
						items : [{
									fieldLabel : '呢称',
									labelAlign : 'right',
									labelWidth : 50,
									name : 'name'
								}, {
									fieldLabel : '备注',
									labelAlign : 'right',
									labelWidth : 50,
									xtype : 'textarea',
									grow : true,
									growMax : 200,
									growMin : 100,
									name : 'descr'
								}]
					}]

		});
/**
 * 用户权限表单
 */
Ext.define('BlogMgr.view.mgruser.UserAddAuth', {
			itemId : 'userAddAuth',
			extend : 'Ext.form.Panel',
			alias : ['widget.mgruseradd_useraddauth'],
			title : '权限分配',
			items : []
});

Ext.define('BlogMgr.view.mgruser.UserAddDialog', {
			id : 'mgruser_UserAddDialog',
			extend : 'Ext.window.Window',
			alias : ['widget.mgruseradd'],
			layout : 'fit',
			title : '用户添加',
			maximizable : true, // 最大化
			bodyStyle : 'padding : 2px 2px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 550,
			//height : 500,
			glyph : 0xf234,
			initComponent : function() {
				this.callParent(arguments);
			},
			tools : [{
						type : 'help',
						tooltip : '帮助'
					}],
			buttons : [{
						itemId : 'save',
						text : '保存',
						glyph : 0xf0c7,
						handler:function(){
							var form  = Ext.getCmp('mgruser_UserAddDialog')
										.getComponent('userAddTabPanel')
										.getComponent("userAddInfo");
							form.submit();
						}
					}, {
						itemId : 'close',
						text : '关闭',
						glyph : 0xf00d
					}],
			items : [{
						itemId:'userAddTabPanel',
						xtype : 'tabpanel',
						frame : false,
						border : false,
						bodyPadding : '5 5 5 5',
						plain : true,
						items : [{
									xtype : 'mgruseradd_userinfo'
								}]
					}]
		});
