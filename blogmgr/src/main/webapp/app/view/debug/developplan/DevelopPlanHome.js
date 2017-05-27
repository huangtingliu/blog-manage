/**
 * 开发计划
 */
Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHome',{
	id : 'developPlan',
	requires : ['Ux.button.TransparentButton'],
	extend : 'Ext.panel.Panel',
	alias : ['widget.develop_plan'],
	layout : 'border',
	items:[{
		region : 'north',
		xtype:'panel',
		padding:'0 0 2px 0px',
		style:"background-color:#c1c1c1",
		tbar:[{
			glyph:56484,
			xtype : 'transparent_button',
			text : '新增计划',
			handler : 'ckEditor'
		},{
			glyph:56484,
			xtype : 'transparent_button',
			text : '修改计划',
			handler : 'ckEditor'
		},{
			glyph:56484,
			xtype : 'transparent_button',
			text : '删除计划',
			handler : 'ckEditor'
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
		xtype : 'panel',
		html:"sdfsdf"
	}]
});