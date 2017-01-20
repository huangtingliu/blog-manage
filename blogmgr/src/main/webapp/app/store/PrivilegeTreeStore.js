/**
 * 权限树Store
 */
Ext.define('BlogMgr.store.PrivilegeTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.privilege_tree',
			storeId : 'privilegeTreeStore',
			model:'BlogMgr.model.PrivilegeTree',
			nodeParam : 'parentId',
			parentIdProperty : 'funParentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				reader : 'json',
				url : '/blogmgr/privilege/tree.data'
			}
		});
Ext.create('BlogMgr.store.PrivilegeTreeStore');
