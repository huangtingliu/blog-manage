/**
 * 备忘录列表 - 视图控制器
 */
Ext.define('BlogMgr.view.debug.meno.SystemMenoHomeController', {
	extend : 'Ext.app.ViewController',
	uses:['BlogMgr.view.debug.meno.mgr.SystemMenoMgrDialog'],
	alias : 'controller.system_meno_home',
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	/**
	 * 添加便签
	 */
	addMeno : function() {
		 Ext.create('BlogMgr.view.debug.meno.mgr.SystemMenoMgrDialog',{
				viewModel : {
					type : 'system_meno_add_dialog'
				}
			}).show();
	},

	/**
	 * 修改便签,侍开发
	 */
	editMeno : function() {
		Ext.toast({
			content : '修改便签,侍开发'
		});
	},
	 /**
	  * 删除便签
	  */
	deleteMeno:function(){
		Ext.toast({
			content : '删除便签,侍开发'
		});
	}
});