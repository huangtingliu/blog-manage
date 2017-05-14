 Ext.define('BlogMgr.component.picker.user.unit.UserSelectorStore', {
			model : 'BlogMgr.model.User',
			extend:'Ext.data.Store',
			alias:'store.user_selector_store',
			storeId : 'userSelectorStore',
			pageSize:20,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
//				actionMethods: {
//	                create : 'POST',
//	                read   : 'POST',
//	                update : 'POST',
//	                destroy: 'POST'
//	            },
				url : '/blogmgr/user/useful_user.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					rootProperty : 'userlist',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});