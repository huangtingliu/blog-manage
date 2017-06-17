/**
 * 分组表格
 */
Ext.define('BlogMgr.view.debug.developplan.view.GroupingGridView', {
	requires : ['Ux.button.TransparentButton',
	            'Ext.grid.filters.Filters'],
	extend : 'Ext.grid.Panel',
	alias : ['widget.developplan_grouping_grid'],
	layout : 'fit',
//	constructor:function(){
//		this.callParent(arguments); 
//	},
//	initComponent:function(){
//		this.callParent();
//	},
	store: Ext.getStore('DevelopPlanPagingStore'),
	autoLoad : true,
	rowLines : true,
	scrollable : true,
	columns : [{
		header : '计划名称',
		dataIndex : 'fName',
		sortable:false,
		width : '15%'
	}, {
		header : '任务级别',
		dataIndex : 'fPriority',
		sortable:false,
		width : '14%'
	}, {
		header : '预计时间',
		dataIndex : 'fEstimatedDate',
		align : 'center',
		sortable:false,
		width : '14%'
	},{
		header : '创建时间',
		dataIndex : 'fCreateDate',
		align : 'center',
		sortable:false,
		width : '14%'
	},{
		header : '创建人',
		dataIndex : 'createUserName',
		align : 'center',
		sortable:false,
		width : '14%'
	},{
		header : '操作',
		xtype: 'actioncolumn',
		width : '10%',
		sortable: false,
		align:'center',
		menuDisabled: true,
		items: [{
	        tooltip: '计划详情',
	        iconCls:'img-icon-detail',
	        scope: this
	    },{
	    	 tooltip: '是否完成',
	    	 iconCls:'img-icon-detail',
	    	 scope: this
	    }]
	}],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : Ext.getStore('DevelopPlanPagingStore'),
		dock : 'bottom',
		displayInfo : true
	}],
});