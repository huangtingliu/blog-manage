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
			userAddSubmit : function() { // 用户信息提交
				var me = this;
				var form = this.getView().getComponent('menuAddForm');
				form.submit({
							success : function(form, action) {
								Ext.toast(action.result);
								//_this.closeDialog();
								//Ext.getStore('userPagingStore').reload(); //TODO 优化：本地加入
							},
							failure : function(form, action) {
								if(action.result){
									Ext.toast(action.result);
								}
							},
							waitMsg:' '
						});
			},
			closeDialog : function() { // 关闭对话窗
				this.getView().close();
			},
			parentMenuSelect:function( me , newValue , oldValue ){ //选择父级菜单后处理方法
				var preCodeFile = this.lookupReference('menuAddFormPreCode');
				preCodeFile.setValue(newValue);
			},
			fIdSubmitValue:function(fixVal){	//菜单代码值 提取规则
				var preCodeFile = this.lookupReference('menuAddFormPreCode');
				var preVal = preCodeFile.getValue();
				return Ext.String.trim(preVal)+fixVal;
			}
		});