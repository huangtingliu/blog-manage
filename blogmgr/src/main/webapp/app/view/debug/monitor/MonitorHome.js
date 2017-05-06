/**
 * sql,web,url等监控器主页
 */
Ext.define('BlogMgr.view.debug.monitor.MonitorHome', {
			id : 'monitorHome',
			extend : 'Ext.panel.Panel',
			alias : ['widget.monitor_home'],
			layout : 'fit',
			html:'<a  href="/blogmgr/druid/sql.html" target="_blank">点击跳转</a>'
		})