/**
 * 系统备忘树store
 */
Ext.define('BlogMgr.store.SystemMenoTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.systemmeno_tree',
			model:'BlogMgr.model.debug.SystemMenoTree',
			nodeParam : 'parentId',
			parentIdProperty : 'fParentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				url : '/blogmgr/debug/meno/tree.data',
			}
		});		