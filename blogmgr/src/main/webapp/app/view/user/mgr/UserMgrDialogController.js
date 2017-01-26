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
			// 用户添加提交
			userMgrDialogSubmit : function() { 
				var _this = this;
				//取得用户的角色id
				var roleIds = _this.getSelectRoleIds();
				
				if(roleIds.length==0){
					Ext.toast("权限未分配");
					return;
				}
				var form = this.getView().getComponent('userMgrTabPanel').getComponent("userInfoForm");
				form.submit({
							submitEmptyText:false, //空文本不提交值
							 params: {
								 roleIds: roleIds
						    },
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
			//获取选中的角色id
			getSelectRoleIds:function(){
				var roleIds = [];
				var toStore = Ext.getStore('userFormToRoleGridStroe');
				toStore.each(function(rec){
					roleIds.push(rec.getId());
				});
				return roleIds;
			},
			//关闭对话窗
			closeDialog:function(){	
				this.getView().close();
			},
			//对话框面板改变触发内容
			tabChange:function(tabPanel , newCard , oldCard , eOpts){
				this.getViewModel().set('selectTabType',newCard.getXType());
			},
			//【可选角色】角色双击选择
			fromRoleGridDoubleClick:function(grid , record , tr , rowIndex , e , eOpts){
				var fromStore = grid.getStore();
				fromStore.remove(record);
				var toStore = Ext.getStore('userFormToRoleGridStroe');
				toStore.add(record);
			},
			//【选定角色】角色双击选择
			toRoleGridDoubleClick:function( grid, record , tr , rowIndex , e , eOpts){
				var toStore = grid.getStore();
				toStore.remove(record);
				var fromStore = Ext.getStore('userFormFromRoleGridStore');
				fromStore.add(record);
			}
		});