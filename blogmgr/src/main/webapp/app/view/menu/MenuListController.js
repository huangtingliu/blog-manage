Ext.define('BlogMgr.view.menu.MenuListController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menulist',
			uses:['BlogMgr.view.menu.MenuAddDialog'],
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 添加菜单
			 */
			addMenu:function(){
				Ext.create('BlogMgr.view.menu.MenuAddDialog').show();
			},
			/**
			 * 修改菜单
			 */
			editMenu:function(){
				Ext.toast('UnSupport operater');
			},
			/**
			 * 修改菜单
			 */
			deleteMenu:function(){
				Ext.toast('UnSupport operater');
			},
			/**
			 * 保存编辑
			 */
			saveRecord:function(){
				Ext.toast('UnSupport operater');
			}
		});