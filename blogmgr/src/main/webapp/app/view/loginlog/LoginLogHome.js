/**
 * 登录日志 - 主页
 */
Ext.define('BlogMgr.view.loginlog.LoginLogHome', {
			id : 'loginLogHome',
			requires : ['Ux.button.TransparentButton',
			           'BlogMgr.view.loginlog.LoginLogHomeController',
			           'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.login_log_home'],
			layout : 'fit',
			items : {
				controller : 'login_log_home',
				viewModel : {
					type : 'login_log_home'
				},
				xtype : 'grid',
				store : Ext.getStore('loginLogPagingStore'),
				columnLines : true,
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				plugins : ['gridfilters', 'cellediting'],
				selModel : {
					selType : 'checkboxmodel',
					ignoreRightMouseSelection : true,
					pruneRemoved : false,
					injectCheckbox : 1
				},
				viewConfig : {
					stripeRows : true, // 奇偶行不同底色
					enableTextSelection : true
				},
				columns : [{
							header : 'No',
							xtype : 'rownumberer',
							width : 37
						}, {
							header : '用户名称',
							dataIndex : 'userName',
							sortable:false,
							width : '12%'
						}, {
							header : '用户账号',
							dataIndex : 'userAccount',
							sortable:false,
							width : '12%'
						}, {
							header : 'IP地址',
							dataIndex : 'fIp',
							align : 'center',
							sortable:false,
							width : '13%'
						},{
							header : '浏览器',
							dataIndex : 'fBrowser',
							align : 'center',
							sortable:false,
							width : '16%'
						},{
							header : '操作系统',
							dataIndex : 'fOperatingSystem',
							align : 'center',
							sortable:false,
							width : '14%'
						},{
							header : '创建日期',
							dataIndex : 'fCreateDate',
							width : '12%',
							align : 'center',
							renderer : function(val) {
								return Ext.Date.format(new Date(val), 'Y-m-d');
							}
//							filter : {
//								type : 'date',
//								dateFormat : 'Y-m-d'
//							}
						}],
				tbar : {
					//xtype : 'userhome_toolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('loginLogPagingStore'),
							dock : 'bottom',
							displayInfo : true
						}],
			}
		})
