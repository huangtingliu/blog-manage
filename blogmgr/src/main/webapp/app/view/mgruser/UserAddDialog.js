/**
 * 用户添加弹出窗口
 */
Ext.define('BlogMgr.view.mgruser.UserAddDialog', {
			id : 'mgruser_useradd',
			uses:['BlogMgr.view.mgruser.UserInfoForm',
				  'BlogMgr.view.mgruser.UserAuthForm',
				  'BlogMgr.view.mgruser.UserAddDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.mgruseradd'],
			layout : 'fit',
			title : '用户添加',
			maximizable : true, // 最大化
			controller:'mgruseradd',
			bodyStyle : 'padding : 2px 2px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 550,
			// height : 500,
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
				handler:'userInfoSubmit'
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xf00d,
				handler:'closeDialog'
			}],
			items : [{
						itemId : 'userAddTabPanel',
						xtype : 'tabpanel',
						frame : false,
						border : false,
						bodyPadding : '5 5 5 5',
						plain : true,
						items : [{
									xtype : 'mgruser_userinfoform'
								}]
					}]
		});
