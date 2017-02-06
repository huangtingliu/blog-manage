/**
 * 系统功能管理对话窗口
 */
Ext.define('BlogMgr.view.fun.mgr.FunctionMgrDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.functionmgr_dialog',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 功能信息提交
			 */
			functionAddSubmit : function() { 
				var me = this;
				var form = this.getView().getComponent('functionMgrForm');
				
				form.submit({
							url : '/blogmgr/function/add.do',
							method : 'POST',
							submitEmptyText:false,
							success : function(form, action) {
								Ext.toast(action.result);
								var functionId = form.findField("fId").getSubmitData().fId;
								
								BlogMgr.model.Function.load(functionId,{
									callback:function(rec,opt,success){
										Ext.getStore('functionPagingStore').add(rec);
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
			 * 功能修改提交
			 */
			functionEditSubmit:function(){
				var me = this;
				var form = this.getView().getComponent('functionMgrForm');
				//TODO 无法只提交修改的部分
				form.submit({
							url : '/blogmgr/function/edit.do',
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
			 *  选择父级功能后处理方法
			 */
			parentFunctionSelect:function( me , newValue , oldValue ){
				var preCodeFile = this.lookupReference('functionMgrFormPreCode');
				preCodeFile.setValue(newValue);
			},
			/**
			 * 功能代码值 提取规则
			 */
			fIdSubmitValue:function(fixVal){	
				var preCodeFile = this.lookupReference('functionMgrFormPreCode');
				var preVal = preCodeFile.getValue();
				return Ext.String.trim(preVal)+fixVal;
			}
		});