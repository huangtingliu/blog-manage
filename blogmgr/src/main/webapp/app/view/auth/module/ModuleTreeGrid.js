/**
 * 权限配置 右边的模块列表
 */
Ext.define('BlogMgr.view.auth.module.ModuleTreeGrid',{
	extend: 'Ext.tree.Panel',
		requires: [
		'Ext.data.*',
		'Ext.grid.*',
		'Ext.tree.*',
		'BlogMgr.model.PrivilegeTree'
		],    
	store : Ext.getStore('privilegeTreeStore'),
	alias:'widget.auth_moduletreegrid',
	itemId:'moduleTreeGrid',
	reserveScrollbar: true,
	useArrows: true,
    rootVisible: false,
	autoLoad : true,
	multiSelect: true,
    singleExpand: false,
    height:350,
	initComponent:function(){
		//Ext.getStore('privilegeTreeStore').removeAll();
		
		this.callParent();
	},
	columns : [{
		xtype: 'treecolumn',
		text : '组件编号',
		dataIndex : 'fFunId',
		flex:1,
		sortable:true
	}, {
		text : '组件名称',
		dataIndex : 'funName',
		flex:1,
		sortable:false
	}]
});