/**
 * 分组表格
 */
Ext.define('BlogMgr.view.debug.developplan.view.GroupingGridView', {
	requires : ['Ux.button.TransparentButton',
	            'Ext.grid.filters.Filters',
	            'Ext.ux.rating.Picker',
	            'Ext.grid.feature.Grouping'],
	extend : 'Ext.grid.Panel',
	alias : ['widget.developplan_grouping_grid'],
	layout : 'fit',

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
				displayInfo : true
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
		text : '计划名称',
		dataIndex : 'fName',
		sortable:false,
		hideable:false,
		width : '17%'
	}, {
		text : '任务级别',
		xtype: 'widgetcolumn',
		dataIndex : 'fPriority',
		hideable:false,
		align : 'center',
		sortable:true,
		width : '14%',
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
		width : '14%'
	},{
		text : '创建时间',
		dataIndex : 'fCreateDate',
		align : 'center',
		sortable:false,
		width : '14%'
	},{
		text : '创建人',
		dataIndex : 'createUserName',
		align : 'center',
		sortable:false,
		width : '14%'
	},{
		text : '操作',
		xtype: 'actioncolumn',
		width : '10%',
		sortable: false,
		hideable:false,
		align:'center',
		menuDisabled: true,
		items: [{
	        tooltip: '计划详情',
	        iconCls:'img-icon-detail',
	        scope: this
	    }]
	}]
});