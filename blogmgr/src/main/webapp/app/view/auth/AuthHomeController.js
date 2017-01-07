/**
 * 权限列表工具栏
 */
Ext.define('BlogMgr.view.auth.AuthHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.authhome',
	uses:['BlogMgr.view.auth.role.RoleAddDialog'],
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	/**
	 * 新增角色
	 */
	addRole:function(){
		 Ext.create('BlogMgr.view.auth.role.RoleAddDialog').show();
	},
	/**
	 * 删除角色
	 */
	deleteRole:function(){
		Ext.toast('UnSupport operater');
	},
	/**
	 * 保存编辑
	 */
	saveRecord : function() {
		Ext.toast('UnSupport operater');
	},
	
});