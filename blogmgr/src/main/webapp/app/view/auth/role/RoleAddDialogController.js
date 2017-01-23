/**
 * 角色添加对话窗口控制器
 */
Ext.define('BlogMgr.view.auth.role.RoleAddDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.roleadd',
			/**
			 * 角色添加提交
			 */
			roleAddSubmit : function() { 
				var _this = this;
				var form = this.getView().getComponent('roleAddForm');
				form.submit({
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								_this.closeDialog();
								Ext.getStore('rolePagingStore').reload(); 
							},
							failure : function(form, action) {
								if(action.result){
									Ext.toast(action.result);
								}
							},
							waitMsg:' '
						});
				
			},
			/**
			 * 关闭对话窗口
			 */
			closeDialog:function(){	
				this.getView().close();
			},
			
			onRowclick:function(){
				
			}
		});