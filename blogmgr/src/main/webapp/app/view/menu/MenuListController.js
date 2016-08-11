Ext.define('BlogMgr.view.menu.MenuListController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menulist',
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			}
		});