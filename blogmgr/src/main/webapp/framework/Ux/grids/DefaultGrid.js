/**
 * 所有视图表格默认样式
 */
Ext.define('Ux.grids.DefaultGrid',{
	extend:'Ext.grid.Panel',
	alias : ['widget.default-grid'],
	autoLoad:true,		//组件一构造完成，就从store中加载数据
	multiColumnSort:false,	//多重排序
	//columnLines:true,	//
	selModel: {
          selType: 'checkboxmodel'
     },
	initComponent : function() {
		this.callParent(arguments);
	}
	
})