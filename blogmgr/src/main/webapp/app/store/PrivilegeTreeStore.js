/**
 * 分页权限树Store
 */
Ext.define('BlogMgr.store.PrivilegeTreeStore', {
			extend : 'Ext.data.TreeStore',
			alias : 'store.privilege_tree',
			model:'BlogMgr.model.PrivilegeTree',
			nodeParam : 'parentId',
			parentIdProperty : 'funParentId',
			//pageSize:15,
			remoteSort:false,
			remoteFilter:false,
			autoLoad:false,
			proxy : {
				noCache:false,
				//limitParam:'pageSize',
				//pageParam:'pageNo',
				type : 'ajax',
				reader : 'json',
				url : '/blogmgr/privilege/tree.data',
				extraParams:{
					filter:'[{"property":"fRoleId","value":" ","operator":"eq"}]'
				},
				reader : {
					type : 'json',
					rootProperty : function(data){
//						if(data.privilegetree){
//							return data.privilegetree;
//						}else if(data.children){
//							return data.children;
//						}else{
//							return data;
//						}
						return data.items || data.children;
					},
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			}
		});