Ext.define('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanFormController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.add_or_edit_develop_plan_form',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			addPlanSubmit:function(){
				 var me = this;
					var form = this.getView();
					
					form.submit({
								submitEmptyText:false,
								success : function(form, action) {
									Ext.toast(action.result);
									Ext.getStore('groupingGridViewStore').reload();
									me.closeTab();
								},
								failure : function(form, action) {
									if(action.result){
										Ext.toast(action.result);
									}
								},
								waitMsg:' '
							});
			},
			editPlanSubmit:function(){
				Ext.toast("修改开发计划，未开发");
			},
			closeTab:function(){
				var tabpanel = this.getView().findParentByType("tabpanel");
				var activeTab = tabpanel.getActiveTab();
				tabpanel.remove(activeTab);
			}
});