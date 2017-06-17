/**
 * 博客后台管理应用启动配置
 */
//资源加载 
Ext.onReady(function() {
	Ext.require([
	             'BlogMgr.store.BaseDataStore',
	             'BlogMgr.factory.FunctionFactory',
	             'Ux.tabs.ReorderableTabs',
				 'Ux.toast.ColorfulToast',
				 'Ux.button.TransparentButton'
	]);
	Ext.Loader.loadScript([
		'/blogmgr/framework/Ux/VTypesPlus.js',
		'/blogmgr/framework/Ux/CustomExtCmp.js'
	]);
});

Ext.application({
			name : 'BlogMgr',
			appFolder : 'app',
			models : ['Function','User','Tree','BaseData','Role','Privilege','PrivilegeTree','LoginLog',
			          'debug.SystemMemo','debug.SystemMemo','debug.DevelopPlan'],
			stores : ['BaseDataStore','UnionPrivilegeProxy','UserPagingStore','FunctionTreeStore','FunctionPagingStore',
			          'RolePagingStore','PrivilegePagingStore','PrivilegeTreeStore','RoleListStore',
			          'LoginLogStore','SystemMemoPaginStore','DevelopPlanPagingStore'],
			controllers:['Main','Root'],
			views:['BlogMgr.view.home.left.Navigator','BlogMgr.view.home.header.HomeHeader',
			       'BlogMgr.view.home.center.HomeIndex'],
			paths : {
				'Ext' : 'framework/Ext',
				'Ux' : 'framework/Ux'
			},
			init : function() {
				 //设置字体
				Ext.setGlyphFontFamily('iconfont');
				Ext.require([
					'BlogMgr.view.user.UserHome','BlogMgr.view.fun.FunctionHome',
					'BlogMgr.view.auth.AuthHome','BlogMgr.view.loginlog.LoginLogHome',
					'BlogMgr.view.debug.memo.SystemMemoHome','BlogMgr.view.debug.monitor.MonitorHome',
					'BlogMgr.view.debug.developplan.DevelopPlanHome']);
			},
			launch : function(profile) {
				
				/**
				 * 自定义静态方法
				 * 获取完整路径
				 * BlogMgr.url(url,param);
				 * BlogMgr.baseData(property);
				 */
				Ext.applyIf(BlogMgr, {
							url : function(url, param) {
								url = "http://localhost:8080/blogmgr/" + url; // 动态获取首地址 TODO 动态获取
								if (Ext.isObject(param)) {
									param = Ext.Object.toQueryString(param);
								}
								var result = Ext.String.urlAppend(url, param);
								return result;
							},
							/**
							 * @param property  参数见 BlogMgr.model.BaseData 
							 * ① baseUrl
							 * ② serversDate
							 * ③ userAccount
							 * ④ userEmail
							 * ⑤ userId
							 * ⑥ userName
							 * ⑦ userPhone
							 * ⑧ userRole
							 * ⑨ userStatus
							 */
							baseData:function(property){
								var store = Ext.getStore('baseDataStore');
								var data = store.getData().first()
								return data.get(property);
							}
						});
						
				Ext.create('Ext.container.Viewport', {
							id:'application',
							layout : 'border',
							items : [{
										id : 'home-header',
										region : 'north',
										xtype : 'home_header'
									}, {
										id : 'home-center',
										region : 'center',
										xtype : 'reorderable_tabs',
										items : [{
											xtype:'home_index',
											closable : false,
										}]
									}, {
										region : 'west',
										width : 250,
										split : true,
										collapsible : true,
										scrollable : true,
										frame : true,
										xtype : 'navigator'
									}]
						});

			}
		});
