/**
 * 系统备忘录主页 
 */
Ext.define('BlogMgr.view.debug.meno.SystemMenoHome', {
			id : 'systemMenoHome',
			requires : ['Ux.button.TransparentButton',
			            'BlogMgr.view.debug.meno.SystemMenoHomeController',
			            'BlogMgr.view.debug.meno.SystemMenoHomeModel',
			            'BlogMgr.view.debug.meno.SystemMenoHomeToolBar',
					   'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.system_meno_home'],
			layout : 'fit',
			items : {
				controller : 'system_meno_home',
				viewModel : {
					type : 'system_meno_home'
				},
				xtype : 'grid',
				store : Ext.getStore('systemMenoPaginStore'),
				columnLines : true,
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				plugins : ['gridfilters', 'cellediting'],
				selModel : {
					selType : 'checkboxmodel',
					ignoreRightMouseSelection : true,
					pruneRemoved : false,
					injectCheckbox : 1
				},
				viewConfig : {
					stripeRows : true, // 奇偶行不同底色
					enableTextSelection : true
				},
				columns : [{
							header : 'No',
							xtype : 'rownumberer',
							width : 37
						}, {
							header : '标题',
							dataIndex : 'fTitle',
							sortable:false,
							width : '11%'
						}, {
							header : '连接',
							dataIndex : 'fUrl',
							sortable:false,
							width : '11%'
						}],
				tbar : {
					xtype : 'system_meno_home_toolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('systemMenoPaginStore'),
							dock : 'bottom',
							displayInfo : true,
							items : []
						}],
			}
		})