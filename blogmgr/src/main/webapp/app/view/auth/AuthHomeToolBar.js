/**
 * 权限列表 - 工具栏
 */
Ext.define('BlogMgr.view.auth.AuthHomeToolBar', {
		    uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.authhome_toolbar',
			initComponent : function() {
				var viewModel = this.up('authhome').getViewModel();// 把ViewModel中生成的菜单items加到此toolbar的items中
				var key = BlogMgr.factory.FunctionFactory.KEY_TOOLBAR;
				this.items = viewModel.get(key).concat(this.items);
				this.callParent();
			},
			items : [{
						width : 110,
						blurWidth : 130,
						xtype : 'gridsearchfield',
						emptyText : '角色名查询..',
						paramName : 'fName',
						store : Ext.getStore('rolePagingStore')
				}]

		});