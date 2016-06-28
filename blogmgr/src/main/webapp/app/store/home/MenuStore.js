Ext.define('BlogMgr.store.home.MenuStore',{
	storeId:'menuStore',
	requires:['BlogMgr.model.home.Menu'],
	alias:['store.menustore'],
	extend:'Ext.data.Store',
	model:'BlogMgr.model.home.Menu',
	data : [{
						code:'A001',
						name : '用户管理',
						icon : 'fa-user',
						url : 'userMgrIndex'
					}, {
						code:'A002',
						name : '配置',
						icon : 'fa-cog',
						url : 'configIndex'
					}, {
						code:'A003',
						name : 'Homer',
						icon : 'fa-home',
						url : 'userMgrIndex'
					}, {
						code:'A004',
						name : 'Marge',
						icon : 'fa-road',
						url : 'mgrIndex'
					}]
});