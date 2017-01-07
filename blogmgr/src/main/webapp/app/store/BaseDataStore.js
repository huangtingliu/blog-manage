/**
 * 基础（初始）数据，供系统初始化
 */
Ext.define('BlogMgr.store.BaseDataStore',{
	extend : 'Ext.data.Store',
	alias : 'store.base_data',
	storeId : 'baseDataStore',
	model:'BlogMgr.model.BaseData'
});
Ext.create('BlogMgr.store.BaseDataStore');
Ext.getStore('baseDataStore').load();
