/**
 * 用户添加对话框控制器
 */
Ext.define('BlogMgr.view.mgruser.UserAddDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.mgruseradd',
			init : function() {
			},
			userInfoSubmit : function() { // 用户信息提交
				var _this = this;
				var form = Ext.getCmp('mgruser_useradd')
						.getComponent('userAddTabPanel')
						.getComponent("userInfoForm");
				form.submit({
							success : function(form, action) {
								Ext.toast(action.result);
								_this.closeDialog();
								Ext.getStore('s_mgruserlist').reload();
							},
							failure : function(form, action) {
								if(action.result){
									Ext.toast(action.result);
								}
							}
						});
			},
			closeDialog:function(){	//关闭对话窗
				Ext.getCmp('mgruser_useradd').close();
			}

		});