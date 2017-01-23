/**
 * 用户添加对话窗口控制器
 */
Ext.define('BlogMgr.view.user.mgr.UserMgrDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.user_mgr_dialog',
			init : function() {
				this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
			},
			userInfoSubmit : function() { // 用户信息提交
				var _this = this;
				var form = this.getView().getComponent('userMgrTabPanel').getComponent("userInfoForm");
				form.submit({
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								_this.closeDialog();
								Ext.getStore('userPagingStore').reload(); //TODO 优化：本地加入
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
			},
			tabChange:function(tabPanel , newCard , oldCard , eOpts){
				//console.info(newCard);
			}
		});