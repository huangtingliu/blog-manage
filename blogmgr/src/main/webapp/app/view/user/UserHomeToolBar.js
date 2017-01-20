/**
 * 用户列表 - 工具栏
 */
Ext.define('BlogMgr.view.user.UserHomeToolBar', {
		    uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.userhome_toolbar',
			initComponent : function() {
				var viewModel = this.up('grid').getViewModel();// 把ViewModel中生成的菜单items加到此toolbar的items中
				this.items = viewModel.get('toolBarMenus').concat(this.items);
				this.callParent();
			},
			items : [{
					width : 100,
					blurWidth:100,
					xtype : 'gridsearchfield',
					emptyText:'用户名查询..',
					paramName:'fName',
					store :Ext.getStore('userPagingStore')
				}]
		});