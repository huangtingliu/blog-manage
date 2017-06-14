/**
 * 开发计划
 */
Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHome',{
	id : 'developPlanHome',
	uses:['BlogMgr.view.debug.developplan.DevelopPlanHomeController'],
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
			text : '显示',
			 menu: [{
	             text:'普通'
	         },{
	             text:'按日期'
	         },{
	             text:'按人员'
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
			title:'我的计划',
			closable : false,
			html:"侍开发"
		}]
	}]
});