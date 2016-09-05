/**
 * 登录页面
 */
Ext.define('BlogMgr.view.login.LoginHome', {
			id : 'loginHome',
			extend : 'Ext.container.Viewport',
			uses:['BlogMgr.view.login.LoginForm',
				  'BlogMgr.view.login.LoginHomeController'],
			alias : ['widget.loginhome'],
			controller:'loginhome',
			layout : {
				type : 'vbox',
				pack : 'start',
				align : 'stretch'
			},
			defaults : {
				xtype : 'panel',
				layout : 'fit'
			},
			items : [{
						//html : '用户登录',
						flex : 1
					}, {
						flex : 8,
						html : 'body',
						layout : {
							type : 'hbox',
							pack : 'start',
							align : 'stretch'
						},
						defaults : {
							xtype : 'panel',
							layout : 'fit'
						},
						items : [{
									//html : 'offset',
									flex : 2
								}, {
									flex : 3,
									items:{
										xtype:'login_form'
									}
								}, {
									//html : '用户登录',
									flex : 5
								}]
					}, {
						//html : 'footer',
						flex : 1.5
					}]
		});