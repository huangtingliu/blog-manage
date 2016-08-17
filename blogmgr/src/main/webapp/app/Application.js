/**
 * 博客后台管理应用启动配置
 */
Ext.onReady(function() {
	Ext.require(['Ux.tabs.ReorderableTabs',
				 'Ux.toast.ColorfulToast'
	]);
	Ext.Loader.loadScript([
		'/blogmgr/framework/Ux/VTypesPlus.js'
	]);
	
});

Ext.application({
			name : 'BlogMgr',
			appFolder : 'app',
			models : ['Menu','User','Tree'],
			stores : ['MenuListProxy','UserPagingStore','MenuTreeStore','MenuPagingStore'],
			controllers:['Main','Root'],
			views:['BlogMgr.view.home.Navigator'],
			paths : {
				'Ext' : 'framework/Ext',
				'Ux' : 'framework/Ux'
			},
			init : function() {
				Ext.setGlyphFontFamily('iconfont');
				Ext.require([
					'BlogMgr.view.user.UserList',
					'BlogMgr.view.menu.MenuList']);
			},
			launch : function(profile) {
				// 附加额外的属性
				Ext.applyIf(BlogMgr, {
							url : function(url, param) {
								url = "http://localhost:8080/blogmgr/" + url; // 动态获取首地址
																				// TODO
								if (Ext.isObject(param)) {
									param = Ext.Object.toQueryString(param);
								}
								var result = Ext.String.urlAppend(url, param);
								return result;
							}
						});

				Ext.create('Ext.container.Viewport', {
							layout : 'border',
							items : [{
										id : 'home-header',
										region : 'north',
										xtype : 'component',
										cls : 'appBanner',
										padding : 10,
										height : 40,
										html : 'Blog Manager System(v0.0.1)'
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