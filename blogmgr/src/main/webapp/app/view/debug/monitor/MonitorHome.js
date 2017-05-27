/**
 * sql,web,url等监控器主页
 */
Ext.define('BlogMgr.view.debug.monitor.MonitorHome', {
			id : 'monitorHome',
			extend : 'Ext.panel.Panel',
			alias : ['widget.monitor_home'],
			layout : 'fit',
			html:'',
			listeners:{
				afterrender  :function(){
					window.open("/blogmgr/druid/sql.html");
					setTimeout(function(){
						var tabPanel = Ext.getCmp('home-center');
						var tab = tabPanel.getActiveTab();
						tabPanel.remove(tab);
					},400);
				}
			
			}
		})