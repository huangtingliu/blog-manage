/**
 * 不分页角色 store
 */
Ext.define('BlogMgr.store.RoleListStore',{
	model : 'BlogMgr.model.Role',
	extend:'Ext.data.Store',
	alias:'store.role_list',
	storeId : 'roleListStore',
	remoteFilter:true,
	proxy : {
		type : 'ajax',
		url : '/blogmgr/role/list.data',
		noCache:false,
		paramsAsJson:true
//		reader : {
//			type : 'json',
//			rootProperty : 'rolelist',
//			totalProperty : 'total',
//			messageProperty : 'message',
//			successProperty : 'success'
//		}
	},
	listeners:{}
});