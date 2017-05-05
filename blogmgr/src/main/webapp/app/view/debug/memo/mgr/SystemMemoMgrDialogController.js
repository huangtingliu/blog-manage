Ext.define('BlogMgr.view.debug.memo.mgr.SystemMemoMgrDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.system_memo_dialog',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 保存便签
			 */
			memoAddSubmit:function(){
				 var me = this;
					var form = this.getView().getComponent('systemMemoMgrForm');
					
					form.submit({
								url : '/blogmgr/debug/memo/add.do',
								method : 'POST',
								submitEmptyText:false,
								success : function(form, action) {
									Ext.toast(action.result);
									Ext.getStore('systemMemoPaginStore').reload();
									me.closeDialog();
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
			 * 修改便签
			 */
			memoEditSubmit:function(){
				 var me = this;
					var form = this.getView().getComponent('systemMemoMgrForm');
					
					form.submit({
								url : '/blogmgr/debug/memo/edit.do',
								method : 'POST',
								submitEmptyText:false,
								success : function(form, action) {
									Ext.toast(action.result);
									Ext.getStore('systemMemoPaginStore').reload();
									me.closeDialog();
								},
								failure : function(form, action) {
									if(action.result){
										Ext.toast(action.result);
									}
								},
								waitMsg:' '
							});
			},
			
			closeDialog:function(){
				this.getView().close();
			}
			
		});