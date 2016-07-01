Ext.Loader.setPath('BlogMgr', 'app');
Ext.require(['Widget.tabs.ReorderableTabs',
		     'BlogMgr.view.home.Navigator']);
		     
Ext.application({
			name : 'BlogMgr',
			appFolder : 'app',
			paths : {
				'Ext' : 'framework/Ext'
			},
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
									   id : 'home-header',
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
									        glyph: 0xf015
									    }]
									}, {
										region : 'west',
										width : 250,
										split : true,
										collapsible : true,
										scrollable : true,
										frame : true,
										xtype:'navigator'
									}]
						});

			}
		});