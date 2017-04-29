/**
 * 备忘录列表 - 视图控制器
 */
Ext.define('BlogMgr.view.debug.meno.SystemMenoHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.system_meno_home',
	init : function() {
		this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
	},


	 
});