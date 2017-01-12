/**
 * 基础（初始）数据，供系统初始化
 */
Ext.define('BlogMgr.store.BaseDataStore',{
	uses:['BlogMgr.model.BaseData'],
	extend : 'Ext.data.Store',
	alias : 'store.base_data',
	storeId : 'baseDataStore',
	model:'BlogMgr.model.BaseData',
	autoLoad:false
});
Ext.create('BlogMgr.store.BaseDataStore');
if(window.sessionStorage){ //如果本地存储可用，就从本地存储获取系统初始化的数据，该数据在登录时存储的    
	var baseData = sessionStorage.getItem('blgmgrBaseData');
	if(baseData){
		Ext.getStore('baseDataStore').add(baseData);
	}else{
		Ext.getStore('baseDataStore').load();
	}
}else{
	Ext.getStore('baseDataStore').load();
}