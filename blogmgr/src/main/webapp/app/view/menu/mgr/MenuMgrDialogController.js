/**
 * 菜单管理对话窗口
 */
Ext.define('BlogMgr.view.menu.mgr.MenuMgrDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menumgr_dialog',
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
				var form = this.getView().getComponent('menuMgrForm');
				
				form.submit({
							url : '/blogmgr/menu/add.do',
							method : 'POST',
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								var menuId = form.findField("fId").getSubmitData().fId;
								
								BlogMgr.model.Menu.load(menuId,{
									callback:function(rec,opt,success){
										Ext.getStore('menuPagingStore').add(rec);
										//TODO 界面更新
										//TODO 树型下拉选择器，与左边的数据冲突
									}
								});
								
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
			 * 用户修改提交
			 */
			userEditSubmit:function(){
				var me = this;
				var form = this.getView().getComponent('menuMgrForm');
				//TODO 无法只提交修改的部分
				form.submit({
							url : '/blogmgr/menu/edit.do',
							method : 'POST',
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								form.getRecord().load();
								me.closeDialog();
								//TODO 界面无法完全刷新
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
				var preCodeFile = this.lookupReference('menuMgrFormPreCode');
				preCodeFile.setValue(newValue);
			},
			/**
			 * 菜单代码值 提取规则
			 */
			fIdSubmitValue:function(fixVal){	
				var preCodeFile = this.lookupReference('menuMgrFormPreCode');
				var preVal = preCodeFile.getValue();
				return Ext.String.trim(preVal)+fixVal;
			}
		});