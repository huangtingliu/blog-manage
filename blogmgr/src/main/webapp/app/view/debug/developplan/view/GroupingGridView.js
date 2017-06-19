/**
 * 分组表格
 */
Ext.define('BlogMgr.view.debug.developplan.view.GroupingGridView', {
	requires : ['Ux.button.TransparentButton',
	            'Ext.grid.filters.Filters',
	            'Ext.ux.rating.Picker',
	            'BlogMgr.view.debug.developplan.view.GroupingGridViewController',
	            'Ext.grid.feature.Grouping'],
	extend : 'Ext.grid.Panel',
	alias : ['widget.developplan_grouping_grid'],
	layout : 'fit',
	controller:'dph_grouping_grid_view',
	initComponent:function(){
		var store = Ext.create('BlogMgr.store.DevelopPlanPagingStore',{
			storeId:'groupingGridViewStore',
			groupField: 'groupingDate',
			groupDir : 'DESC'
		});
		Ext.apply(this, {
			store:store,
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : store,
				dock : 'bottom',
				displayInfo : true,
				items:[{
					tooltip : '显示所有任务',
					xtype : 'button',
					iconCls:'img-icon-show-task-all'
				},{
					tooltip : '显示完成任务',
					xtype : 'button',
					iconCls:'img-icon-show-task-complete'
				},{
					tooltip : '显示活动任务',
					xtype : 'button',
					iconCls:'img-icon-show-task-active'
				}]
			}]
	 	});
		this.callParent();
	},
	autoLoad : true,
	rowLines : true,
	columnLines : true,
	scrollable : true,
	features: [{
	    ftype: 'grouping',
	  //  groupHeaderTpl: '{columnName}: {name} ({rows.length} Item{[values.rows.length > 1 ? "s" : ""]})',
	    groupHeaderTpl: '{name} ( {rows.length} 个)',
	    hideGroupedHeader: true,
	    startCollapsed: false,
	    enableGroupingMenu:false
	}],
	columns : [{
	    dataIndex: "fPlanStauts",
	    cls: "ux-icon-column-header tasks-done-column-header",
	    width: 24,
	    menuDisabled: true,
	    sortable: false,
	    renderer:function(val){
			if('ENABLE'==val){
				return '<div style="width:16px;height:16px;margin:3px 0px 0px -6px" class="img-icon-task-start"></div>'
			}else{
				return '<div style="width:16px;height:16px;margin:3px 0px 0px -6px" class="img-icon-task-finished"></div>'
			}
		}
	},{
		text : '计划名称',
		dataIndex : 'fName',
		sortable:false,
		hideable:false,
		width : '25%'
	}, {
		text : '任务级别',
		xtype: 'widgetcolumn',
		dataIndex : 'fPriority',
		hideable:false,
		align : 'center',
		sortable:true,
		width : '15%',
		widget: {
		  xtype: 'rating',
		  scale:'170%',
		  changeable:false
		}
	}, {
		text : '预计时间',
		dataIndex : 'fEstimatedDate',
		align : 'center',
		sortable:false,
		width : '15%'
	},{
		text : '创建时间',
		dataIndex : 'fCreateDate',
		align : 'center',
		sortable:false,
		width : '15%'
	},{
		text : '创建人',
		dataIndex : 'createUserName',
		align : 'center',
		sortable:false,
		width : '15%'
	}],
	listeners:{
		cellclick:'gridViewTaskFinished'
	}
});