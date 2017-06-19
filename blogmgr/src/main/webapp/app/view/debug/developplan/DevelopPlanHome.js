/**
 * 开发计划
 */
Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHome',{
	id : 'developPlanHome',
	uses:['BlogMgr.view.debug.developplan.DevelopPlanHomeController',
	      'BlogMgr.view.debug.developplan.view.GroupingGridView',
	      'BlogMgr.view.debug.developplan.view.ScheduleView',
	      'BlogMgr.view.debug.developplan.view.DataView'],
	requires : ['Ux.button.TransparentButton'],
	extend : 'Ext.panel.Panel',
	alias : ['widget.develop_plan_home'],
	controller:'develop_plan_home',
	layout : 'border',
	items:[{
		region : 'north',
		xtype:'panel',
		padding:'0px 0px 2px 0px',
		style:"background-color:#c1c1c1",
		tbar:[{
			glyph:56484,
			xtype : 'transparent_button',
			text : '新增计划',
			handler : 'addDevelopPlan'
		},{
			glyph:56484,
			xtype : 'transparent_button',
			text : '修改计划',
			handler : 'editDevelopPlan'
		},{
			glyph:56484,
			xtype : 'transparent_button',
			text : '删除计划',
			handler : 'deleteDevelopPlan'
		},{
			glyph:56484,
			xtype : 'transparent_button',
			text:'视图',
			menu: [{
	             text:'分组表',
	             handler:'selectGroupingGridView'
	        },{
	             text:'日程表',
	             handler:'selectScheduleView'
	        },{
	             text:'数据表',
	             handler:'selectDataView'
	        }]
		}]
	}, {
		region : 'center',
		itemId:'developPlanHomeTab',
		xtype : 'tabpanel',
		tabPosition:'left',
		tabRotation:0,
		border: false,
		 defaults: {
	        bodyPadding: 10,
	        scrollable: true,
	        closable: true,
	        border: false
	    },
		items:[{
			title:'计划查看',
			closable : false,
			layout: 'card',
			bodyPadding:0,
			defaults:{
				border:false
			},
			items:[{
				xtype:'developplan_grouping_grid'
			},{
				xtype:'developplan_schedule'
			},{
				xtype:'developplan_dataview'
			}]
		}],
	}]
});