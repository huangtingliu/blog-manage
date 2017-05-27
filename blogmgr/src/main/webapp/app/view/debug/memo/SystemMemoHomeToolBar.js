/**
 * 备忘录列表 - 工具栏
 */
Ext.define('BlogMgr.view.debug.memo.SystemMemoHomeToolBar', {
		    uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.system_memo_home_toolbar',
			initComponent : function() {
				var viewModel = this.up('grid').getViewModel();// 把ViewModel中生成的菜单items加到此toolbar的items中
				var key = BlogMgr.factory.FunctionFactory.KEY_TOOLBAR;
				this.items = viewModel.get(key).concat(this.items);
				this.callParent();
			},
			items : []
		});