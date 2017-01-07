/**
 * 权限配置 左边的角色列表
 */
Ext.define('BlogMgr.view.auth.role.RoleGrid',{
	extend : 'Ext.grid.Panel',
	uses : ['Ux.button.TransparentButton',
	        'Ext.grid.filters.Filters'],
	store : Ext.getStore('rolePagingStroe'),
	//controller : 'userhome',
	alias:'widget.auth_rolegrid',
	columnLines : true,
	autoLoad : true,
	scrollable : true,
	rowLines : true,
	plugins : ['gridfilters', 'cellediting'],
	viewModel : {
		type : 'userhome'
	},
	viewConfig : {
		stripeRows : true, // 奇偶行不同底色
		enableTextSelection : true
	},
	columns : [{
		header : 'No',
		xtype : 'rownumberer',
		width : 37
	}, {
		header : '角色名称',
		dataIndex : 'fName',
		width : 140,
		sortable:true
	}, {
		header : '角色编号',
		dataIndex : 'fCode',
		width : 70,
		sortable:true
	}, {
		header : '角色状态',
		dataIndex : 'fStatus',
		width : 100,
		sortable:true,
		renderer : function(val) {
			if (val == 'ENABLE') {
				return '<b style="color:green">可用</b>';
			} else if (val == 'DISABLE') {
				return '<b style="color:red">不可用</b>';
			} else {
				return '未知';
			}
		},
	}],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : Ext.getStore('rolePagingStroe'),
		dock : 'bottom',
		displayInfo : false
	}]
});