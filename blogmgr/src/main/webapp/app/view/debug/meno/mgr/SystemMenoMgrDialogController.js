Ext.define('BlogMgr.view.debug.meno.mgr.SystemMenoMgrDialogController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.system_meno_dialog',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 保存便签
			 */
			menoAddSubmit:function(){
				 var me = this;
					var form = this.getView().getComponent('systemMenoMgrForm');
					
					form.submit({
								url : '/blogmgr/debug/meno/add.do',
								method : 'POST',
								submitEmptyText:false,
								success : function(form, action) {
									Ext.toast(action.result);
//									var functionId = form.findField("fId").getSubmitData().fId;
//									
//									BlogMgr.model.Function.load(functionId,{
//										callback:function(rec,opt,success){
//											Ext.getStore('functionPagingStore').add(rec);
//											//TODO 界面更新
//											//TODO 树型下拉选择器，与左边的数据冲突
//										}
//									});
									
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