/**
 * 系统备忘录主页 
 */
Ext.define('BlogMgr.view.debug.memo.SystemMemoHome', {
			id : 'systemMemoHome',
			requires : ['Ux.button.TransparentButton',
			            'BlogMgr.view.debug.memo.SystemMemoHomeController',
			            'BlogMgr.view.debug.memo.SystemMemoHomeModel',
			            'BlogMgr.view.debug.memo.SystemMemoHomeToolBar',
					   'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.system_memo_home'],
			layout : 'fit',
			initComponent:function(){
				this.items.viewModel = {
					type : 'system_memo_home',
					viewParentId:this.parentId
				}
				this.callParent(arguments); 
			},
			items : {
				controller : 'system_memo_home',
				xtype : 'grid',
				store : Ext.getStore('SystemMemoPaginStore'),
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
					xtype : 'system_memo_home_toolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('SystemMemoPaginStore'),
							dock : 'bottom',
							displayInfo : true,
							items : []
						}],
			}
		})