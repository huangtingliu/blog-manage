/**
 * 菜单管理 - 主页
 */
Ext.define('BlogMgr.view.menu.MenuHome', {
			id : 'henuHome',
			extend : 'Ext.panel.Panel',
			alias : ['widget.menuhome'],
			uses : ['BlogMgr.view.menu.MenuTree', 
					'BlogMgr.view.menu.MenuGrid',
					'BlogMgr.view.menu.MenuHomeController',
					'BlogMgr.view.menu.MenuHomeModel'],
			layout : 'border',
			controller : 'menuhome',
			viewModel : {
				type : 'menuhome'
			},
			items : [{
						region : 'west',
						title : '',
						bodyPadding : 7,
						width : 200,
						split : true,
						items : {
							xtype : 'menutree'
						}
					}, {
						region : 'center',
						layout : 'fit',
						items : {
							xtype : 'menugrid'
						}
					}]
		});