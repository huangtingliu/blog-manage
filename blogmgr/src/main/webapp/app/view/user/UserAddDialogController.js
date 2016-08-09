/**
 * 用户添加对话框控制器
 */
Ext.define('BlogMgr.view.user.UserAddDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.useradd',
			init : function() {
				this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
			},
			userInfoSubmit : function() { // 用户信息提交
				var _this = this;
				var form = this.getView().getComponent('userAddTabPanel').getComponent("userInfoForm");
				form.submit({
							success : function(form, action) {
								Ext.toast(action.result);
								_this.closeDialog();
								Ext.getStore('s_userlist').reload(); //TODO 优化：本地加入
							},
							failure : function(form, action) {
								if(action.result){
									Ext.toast(action.result);
								}
							},
							waitMsg:' '
						});
				
			},
			closeDialog:function(){	//关闭对话窗
				this.getView().close();
			}

		});