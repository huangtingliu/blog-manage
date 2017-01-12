/**
 * 博客后台管理应用启动配置
 */
Ext.onReady(function() {
	Ext.require([
	             'BlogMgr.store.BaseDataStore',
	             'Ux.tabs.ReorderableTabs',
				 'Ux.toast.ColorfulToast',
				 'Ux.button.TransparentButton'
	]);
	Ext.Loader.loadScript([
		'/blogmgr/framework/Ux/VTypesPlus.js'
	]);
});

Ext.application({
			name : 'BlogMgr',
			appFolder : 'app',
			models : ['Menu','User','Tree','BaseData','Role','Privilege'],
			stores : ['BaseDataStore','MenuListProxy','UserPagingStore','MenuTreeStore','MenuPagingStore',
			          'RolePagingStroe','PrivilegePagingStore'],
			controllers:['Main','Root'],
			views:['BlogMgr.view.home.Navigator','BlogMgr.view.home.HomeHeader'],
			paths : {
				'Ext' : 'framework/Ext',
				'Ux' : 'framework/Ux'
			},
			init : function() {
				 //设置字体
				Ext.setGlyphFontFamily('iconfont');
				Ext.require([
					'BlogMgr.view.user.UserHome','BlogMgr.view.menu.MenuHome',
					'BlogMgr.view.auth.AuthHome']);
			},
			launch : function(profile) {
				/**
				 * 获取完整路径
				 * BlogMgr.url(url,param);
				 */
				Ext.applyIf(BlogMgr, {
							url : function(url, param) {
								url = "http://localhost:8080/blogmgr/" + url; // 动态获取首地址 TODO 动态获取
								if (Ext.isObject(param)) {
									param = Ext.Object.toQueryString(param);
								}
								var result = Ext.String.urlAppend(url, param);
								return result;
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
													id : 'tab-index',
													title : '首页',
													closable : false,
													glyph : 0xe622
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
