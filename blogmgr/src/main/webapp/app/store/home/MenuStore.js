Ext.define('BlogMgr.store.home.MenuStore',{
	storeId:'menuStore',
	requires:['BlogMgr.model.home.Menu'],
	alias:['store.menustore'],
	extend:'Ext.data.Store',
	model:'BlogMgr.model.home.Menu',
	data : [{
						code:'A001',
						name : '用户管理',
						icon : 'icon-user',
						url : 'userMgrIndex'
					}, {
						code:'A002',
						name : '配置',
						icon : 'icon-cog',
						url : 'configIndex'
					}, {
						code:'A003',
						name : 'Homer',
						icon : 'icon-home',
						url : 'userMgrIndex'
					}, {
						code:'A004',
						name : 'Marge',
						icon : 'icon-road',
						url : 'mgrIndex'
					}]
});