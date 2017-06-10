/**
 * 权限列表工具栏
 */
Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.develop_plan_home',
	requires:['BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlan'],
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	/**
	 * 新增计划
	 */
	addDevelopPlan:function(){
		var homePanel= this.getView();
		var tabPanel = homePanel.getComponent('developPlanHomeTab');
		tab = tabPanel.add({
				title : '新增计划',
				//glyph : 59041,
				layout : 'fit',
				bodyPadding:0,
				items : Ext.create('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlan')
			});
		tabPanel.setActiveTab(tab);
	},
	/**
	 * 修改计划
	 */
	editDevelopPla:function(){
		 Ext.toast('UnSupport operater');
	}
});