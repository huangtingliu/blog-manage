/**
 * 添加后台用户对话窗口
 */
Ext.define('BlogMgr.view.user.mgr.UserMgrDialog', {
			id : 'userMgrDialog',
			alias : ['widget.user_mgr_dialog'],
			requires:[
			      'BlogMgr.view.user.mgr.UserInfoForm',
				  'BlogMgr.view.user.mgr.UserAuthForm',
				  'BlogMgr.view.user.mgr.UserMgrDialogController',
				  'BlogMgr.view.user.mgr.UserMgrDialogModel'],
			extend : 'Ext.window.Window',
			layout : 'fit',
			title : '用户添加',
			maximizable : true, // 最大化
			controller:'user_mgr_dialog',
			viewModel : {
				type : 'user_mgr_dialog'
			},
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
						bind:{
							tooltip : '{toolTip}'
						}
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
						itemId : 'userMgrTabPanel',
						xtype : 'tabpanel',
						frame : false,
						border : false,
						bodyPadding : '5 5 5 5',
						plain : true,
						items : [{
									xtype : 'user_userinfoform'
								},{
									xtype : 'user_userauthform'
								}],
						listeners:{
							tabchange:'tabChange'
						}
					}]
		});