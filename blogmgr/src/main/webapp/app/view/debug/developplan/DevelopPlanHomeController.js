/**
 * 权限列表工具栏
 */
Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.develop_plan_home',
	requires:['BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanForm'],
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
				items : Ext.create('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanForm',{
					viewModel : 'add_develop_plan_form'
				})
			});
		tabPanel.setActiveTab(tab);
	},
	/**
	 * 修改计划
	 */
	editDevelopPlan:function(){
		 var homePanel= this.getView();
			var tabPanel = homePanel.getComponent('developPlanHomeTab');
			tab = tabPanel.add({
					title : '修改计划',
					//glyph : 59041,
					layout : 'fit',
					bodyPadding:0,
					items : Ext.create('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanForm',{
						viewModel : 'edit_develop_plan_form'
					})
				});
			tabPanel.setActiveTab(tab);
	},
	/**
	 * 删除开发计划
	 */
	deleteDevelopPlan:function(){
		Ext.toast("删除开发计划未开发");
	},
	/**
	 * 切换到视图表
	 */
	selectGroupingGridView:function(){
		this.doSelectView(0);
	},
	/**
	 * 切换到日程表视图
	 */
	selectScheduleView:function(){
		 this.doSelectView(1);
	},
	/**
	 * 切换到数据图
	 */
	selectDataView:function(){
		 this.doSelectView(2);
	},
	privates:{
		/*
		 * 做切换视图的动作
		 */
		doSelectView: function (incr) {
	        var me = this;
	       var developPlanHome =  this.getView();
	       var developPlanTab = developPlanHome.down('tabpanel');
	       var cardPanel = developPlanTab.items.first(); 
	       cardPanel.setActiveItem(incr);
    	}
	}
});