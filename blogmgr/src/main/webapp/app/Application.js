Ext.Loader.setPath('BlogMgr', 'app');

Ext.require(['Widget.tabs.ReorderableTabs',
		     'Widget.grids.MenuGrid','BlogMgr.view.index.Index']);

Ext.application({
			name : 'BlogMgr',
			appFolder : 'app',
			paths : {
				'Ext' : 'framework/Ext'
				
			},
			stores:[
				'BlogMgr.store.home.MenuStore'
			],
			init:function(){
				Ext.setGlyphFontFamily('FontAwesome');
			},
			launch : function(profile) {
			
				// 附加额外的属性
				Ext.applyIf(BlogMgr, {
					url : function(url, param) {
						url = "http://localhost:8080/blogmgr/" + url; // 动态获取首地址  TODO
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
										region: 'north',
									    xtype: 'component',
									    cls: 'appBanner',
									    padding: 10,
									    height: 40,
									    html: 'Blog Manager System(v0.0.1)'
									}, {
										id : 'home-center',
										region : 'center',
										xtype : 'reorderable-tabs',
										items: [{
									    	id:'tab-index',
									        title: '首页',
									        closable:false,
									        glyph: 0xf299,
									        xtype:'tabindex'
									    }]
									}, {
										id : 'home-navigation',
										region : 'west',
										title : '导航',
										width : 250,
										split : true,
										collapsible : true,
										scrollable : true,
										frame : true,
										layout : 'accordion',
										defaults: {
									        bodyPadding: 10
									    },
										items : [{
											title : '博客管理',
											xtype : 'menugrid',
											store : 'BlogMgr.store.home.MenuStore'
										}, {
											title : '系统管理'
										}, {
											title : '其他管理'
										}]
									}]
						});

			}
		});