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
				Ext.toast("新增开发计划，未开发");
			},
			editPlanSubmit:function(){
				Ext.toast("修改开发计划，未开发");
			},
			closeTab:function(){
				Ext.toast("关闭表单，未开发");
			}
});