Ext.define('BlogMgr.store.home.MenuStore',{
	storeId:'menuStore',
	requires:['BlogMgr.model.home.Menu'],
	alias:['store.menustore'],
	extend:'Ext.data.Store',
	model:'BlogMgr.model.home.Menu',
	data : [{
						name : '用户管理',
						icon : 'icon-user',
						url : 'userMgrIndex'
					}, {
						name : '配置',
						icon : 'icon-cog',
						url : 'configIndex'
					}, {
						name : 'Homer',
						icon : 'icon-home',
						url : 'userMgrIndex'
					}, {
						name : 'Marge',
						icon : 'icon-road',
						url : 'mgrIndex'
					}]
});