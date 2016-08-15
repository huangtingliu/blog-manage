/**
 * 添加后台用户对话窗口
 */
Ext.define('BlogMgr.view.user.UserAddDialog', {
			id : 'userAddDialog',
			uses:['BlogMgr.view.user.UserInfoForm',
				  'BlogMgr.view.user.UserAuthForm',
				  'BlogMgr.view.user.UserAddDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.useradd'],
			layout : 'fit',
			title : '用户添加',
			maximizable : true, // 最大化
			controller:'useradd',
			bodyStyle : 'padding : 2px 2px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 550,
			// height : 500,
			glyph : 0xe614,
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
				glyph : 0xe650,
				handler:'userInfoSubmit'
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xe6af,
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
									xtype : 'user_userinfoform'
								}]
					}]
		});
