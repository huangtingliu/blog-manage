/**
 * 开发任务计划
 */
Ext.define('BlogMgr.store.DevelopPlanPagingStore', {
			model : 'BlogMgr.model.debug.DevelopPlan',
			extend:'Ext.data.Store',
			alias:'store.developplan_paging',
			//storeId : 'developPlanPagingStore',
			pageSize:15,
			remoteSort:true,
//			constructor:function(config){
//				this.callParent(arguments); 
//			},
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/debug/developplan/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					rootProperty : 'planlist',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});