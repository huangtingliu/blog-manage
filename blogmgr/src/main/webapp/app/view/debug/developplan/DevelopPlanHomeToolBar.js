Ext.define('BlogMgr.view.debug.developplan.DevelopPlanHomeToolBar', {
		   // uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.develop_plan_home_toolbar',
			initComponent : function() {
				var viewModel = this.up('grid').getViewModel();// 把ViewModel中生成的菜单items加到此toolbar的items中
				this.items = viewModel.get('toolBarMenus').concat(this.items);
				this.callParent();
			},
			items : []
		});