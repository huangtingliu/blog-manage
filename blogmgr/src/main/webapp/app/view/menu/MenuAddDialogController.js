/**
 * 
 */
Ext.define('BlogMgr.view.menu.MenuAddDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menuadd_dialog',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 用户信息提交
			 */
			userAddSubmit : function() { 
				var me = this;
				var form = this.getView().getComponent('menuAddForm');
				form.submit({
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								me.closeDialog();
								Ext.getStore('menuPagingStore').reload(); 
								//TODO 树刷新
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
			 *  关闭对话窗
			 */
			closeDialog : function() {
				this.getView().close();
			},
			/**
			 *  选择父级菜单后处理方法
			 */
			parentMenuSelect:function( me , newValue , oldValue ){
				var preCodeFile = this.lookupReference('menuAddFormPreCode');
				preCodeFile.setValue(newValue);
			},
			/**
			 * 菜单代码值 提取规则
			 */
			fIdSubmitValue:function(fixVal){	
				var preCodeFile = this.lookupReference('menuAddFormPreCode');
				var preVal = preCodeFile.getValue();
				return Ext.String.trim(preVal)+fixVal;
			}
		});