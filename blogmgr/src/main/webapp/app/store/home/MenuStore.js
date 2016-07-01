Ext.define('BlogMgr.store.home.MenuStore',{
	storeId:'menuStore',
	requires:['BlogMgr.model.home.Menu'],
	alias:['store.menustore'],
	extend:'Ext.data.Store',
	model:'BlogMgr.model.home.Menu',
	data : [{
						fId:'A001',
						fName : '用户管理',
						fIcon : 'fa-user',
						fLink : 'userMgrIndex'
					}, {
						fId:'A002',
						fName : '配置',
						fIcon : 'fa-cog',
						fLink : 'configIndex'
					}, {
						fId:'A003',
						fName : 'Homer',
						fIcon : 'fa-home',
						fLink : 'userMgrIndex'
					}, {
						fId:'A004',
						fName : 'Marge',
						fIcon : 'fa-road',
						fLink : 'mgrIndex'
					}]
});