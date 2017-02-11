/**
 * 登录日志 - 视图控制器
 */
Ext.define('BlogMgr.view.loginlog.LoginLogHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.login_log_home',
	init : function() {
		this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
	}
});