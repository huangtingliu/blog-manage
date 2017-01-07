/**
 * 权限配置 右边的模块列表
 */
Ext.define('BlogMgr.view.auth.module.ModuleGrid',{
	extend : 'Ext.grid.Panel',
	uses : ['Ux.button.TransparentButton',
	        'Ext.grid.filters.Filters'],
	store : Ext.getStore('userPagingStore'),
	//controller : 'userhome',
	alias:'widget.auth_modulegrid',
	columnLines : true,
	autoLoad : true,
	scrollable : true,
	rowLines : true,
	plugins : ['gridfilters', 'cellediting'],
	viewModel : {
		type : 'userhome'
	},
	selModel : {
		selType : 'checkboxmodel',
		ignoreRightMouseSelection : true,
		pruneRemoved : false,
		injectCheckbox : 1
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
		header : '模块名称',
		dataIndex : 'fName',
		sortable:false,
		editor : {
			allowBlank : false,
			vtype:'chinese',
			maxLength:10
		},
		filter : {
			type : 'string',
			emptyText : '名称..'
		}
	}],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : Ext.getStore('userPagingStore'),
		dock : 'bottom',
		displayInfo : false,
	}]
});