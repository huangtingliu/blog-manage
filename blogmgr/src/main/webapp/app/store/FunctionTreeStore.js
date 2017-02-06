/**
 * 系统功能Store
 */
Ext.define('BlogMgr.store.FunctionTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.function_tree',
			storeId : 'functionTreeStore',
			model:'BlogMgr.model.Tree',
			nodeParam : 'parentId',
			parentIdProperty : 'parentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				url : '/blogmgr/function/tree.data'
			}
		});
//菜单配置左边的菜单树
Ext.create('BlogMgr.store.FunctionTreeStore',{
	storeId:'functionHomeTreeStore'
});
//菜单新增时的菜单树
Ext.create('BlogMgr.store.FunctionTreeStore',{
	storeId:'treePickerStroe'
});