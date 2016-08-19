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
				Ext.toast('UnSupport operater');
			},
			closeDialog : function() { // 关闭对话窗
				this.getView().close();
			},
			parentMenuSelect:function( me , newValue , oldValue ){ //选择父级菜单后处理方法
				var preCodeFile = this.lookupReference('menuAddFormPreCode');
				preCodeFile.setValue(newValue);
			}
		});