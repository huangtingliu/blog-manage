/**
 * 菜单树Store
 */
Ext.define('BlogMgr.store.MenuTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.menu_tree',
			storeId : 'menuTreeStore',
			model:'BlogMgr.model.Tree',
			nodeParam : 'parentId',
			parentIdProperty : 'parentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				url : '/blogmgr/menu/tree.data'
			}
		});
Ext.create('BlogMgr.store.MenuTreeStore');