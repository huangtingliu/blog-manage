Ext.define('Ux.tabs.ReorderableTabsController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.reorderable_tabs',
			onAddTab : function(config) { // 附加一个tab
				var tabPanel = this.getView();
				var tab = tabPanel.child("#" + config.id);

				if (!Ext.isEmpty(tab)) { // 该tab已经存在了
				} else { // 添加一个新的tab

					if (!Ext.isEmpty(config.viewClass)) {
						tab = tabPanel.add({
									id : config.id,
									title : config.title,
									glyph : config.glyph,
									layout : 'fit',
									bodyPadding:0,
									items : Ext.create(config.viewClass,{
										parentId:config.id
									})
								});
					} else {
						tab = tabPanel.add({
									id : config.id,
									title : config.title,
									bodyPadding:0,
									glyph : config.glyph,
									layout : 'fit'
								});
					}

				}
				tabPanel.setActiveTab(tab);
			},
			onClick : function() {},
			onRightClick : function() {}
		});