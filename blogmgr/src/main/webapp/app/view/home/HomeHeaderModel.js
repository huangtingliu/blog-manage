/**
 * 首页头部视图模型数据
 */
Ext.define('BlogMgr.view.home.HomeHeaderModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.home_header',
	data : Ext.getStore('baseDataStore').getData().items[0].data,
	formulas : {
		currentDate : function(get) {
			return Ext.Date.format(new Date(get('serversDate')), 'Y年m月d日');
		}
	}
});
