Ext.define('Widget.grids.MenuGrid', {
	requires:['Widget.grids.controller.MenuGridCtrl'],
	extend : 'Ext.grid.Panel',
	alias: ['widget.menugrid'],
	title : '导航菜单',
	hideHeaders : true,
	controller:'menugrid',
	columns : [{
				text : 'name',
				dataIndex : 'name',
				sortable : false,
				hideable : false,
				width : '90%',
				renderer:function(val,cell,model){
					return '<a class="fa '+model.get('icon')+'">&nbsp;'+val+'</a>';
				}
	}],
	listeners:{
		rowclick:'onClickRow'
	}
	
});