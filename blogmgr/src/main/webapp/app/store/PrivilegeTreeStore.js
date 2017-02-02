/**
 * 分页权限树Store
 */
Ext.define('BlogMgr.store.PrivilegeTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.privilege_tree',
			model:'BlogMgr.model.PrivilegeTree',
			nodeParam : 'parentId',
			parentIdProperty : 'funParentId',
			autoLoad:false,
			proxy : {
				noCache:false,
				type : 'ajax',
				url : '/blogmgr/privilege/tree.data',
				extraParams:{
					filter:'[{"property":"fRoleId","value":" ","operator":"eq"}]'
				}
			}
		});