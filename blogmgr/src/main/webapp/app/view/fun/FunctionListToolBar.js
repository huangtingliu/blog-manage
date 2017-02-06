/**
 * 系统功能管理 - 工具栏
 */
Ext.define('BlogMgr.view.fun.FunctionListToolBar', {
			uses : ['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.functionlist_toolbar',
			initComponent : function() {
				var viewModel = this.up('functionhome').getViewModel();// 把ViewModel中生成的菜单items加到此toolbar的items中
				this.items = viewModel.get('toolBarMenus').concat(this.items);
				this.callParent();
			},
			items : [{
						width : 100,
						blurWidth : 100,
						xtype : 'gridsearchfield',
						emptyText : '功能名查询..',
						paramName : 'fName',
						store : Ext.getStore('functionPagingStore')
					}]
		});