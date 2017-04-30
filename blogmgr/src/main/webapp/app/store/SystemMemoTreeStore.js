/**
 * 系统备忘树store
 */
Ext.define('BlogMgr.store.SystemMemoTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.systemmemo_tree',
			model:'BlogMgr.model.debug.SystemMemoTree',
			nodeParam : 'parentId',
			parentIdProperty : 'fParentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				url : '/blogmgr/debug/memo/tree.data',
			}
		});		