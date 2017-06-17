/**
 * 分组表格
 */
Ext.define('BlogMgr.view.debug.developplan.view.GroupingGridView', {
	requires : ['Ux.button.TransparentButton',
	            'Ext.grid.filters.Filters'],
	extend : 'Ext.grid.Panel',
	alias : ['widget.developplan_grouping_grid'],
	layout : 'fit',
	store : [],
	autoLoad : true,
	rowLines : true,
	scrollable : true,
	columns : [{
		header : 'No',
		xtype : 'rownumberer',
		width : 37
	}, {
		header : '用户名称',
		dataIndex : 'userName',
		sortable:false,
		width : '12%'
	}, {
		header : '用户账号',
		dataIndex : 'userAccount',
		sortable:false,
		width : '12%'
	}, {
		header : 'IP地址',
		dataIndex : 'fIp',
		align : 'center',
		sortable:false,
		width : '13%'
	},{
		header : '浏览器',
		dataIndex : 'fBrowser',
		align : 'center',
		sortable:false,
		width : '16%'
	},{
		header : '操作系统',
		dataIndex : 'fOperatingSystem',
		align : 'center',
		sortable:false,
		width : '14%'
	}],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : [],
		dock : 'bottom',
		displayInfo : true
	}],
});