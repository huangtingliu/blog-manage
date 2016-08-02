/**
 * 后台用户列表
 */
Ext.define('BlogMgr.view.user.UserList', {
			id : 'user_UserList',
			uses : ['Widget.button.TransparentButton',
					'BlogMgr.view.user.UserListToolBar',
					'BlogMgr.view.user.UserListController',
					'BlogMgr.view.user.UserListModel',
					'Ext.ux.ProgressBarPager', 'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.userlist'],
			layout : 'fit',
			items : {
				xtype : 'grid',
				store : Ext.getStore('s_userlist'),
				controller : 'userlist',
				columnLines : true,
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				plugins : 'gridfilters',
				viewModel : {
					type : 'userlist'
				},
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
							xtype : 'rownumberer',
							width : 37,
							text : 'No'
						}, {
							text : '名称',
							dataIndex : 'fName',
							filter : {
								type : 'string',
								emptyText : '名称..'
							}
						}, {
							text : '账号',
							dataIndex : 'fAccount',
							filter : {
								type : 'string',
								emptyText : '账号..'
							}
						}, {
							text : '状态',
							dataIndex : 'fStatus',
							align:'center',
							renderer : function(val) {
								if (val == 'ENABLE') {
									return '<span style="color:green">可用</span>';
								} else if (val == 'DISABLE') {
									return '<span style="color:red">不可用</span>';
								} else {
									return '未知';
								}
							},
							filter : {
								type : 'list',
								labelField : 'text',
								options : [{
											id : 'ENABLE',
											text : '可用'
										}, {
											id : 'DISABLE',
											text : '不可用'
										}]
							}
						}, {
							text : '性别',
							dataIndex : 'fGender',
							hidden : true,
							align:'center',
							renderer : function(val) {
								if (val == 'MALE') {
									return '男';
								} else if (val == 'FEMALE') {
									return '女';
								} else {
									return '未知';
								}
							},
							filter : {
								type : 'list',
								labelField : 'text',
								single : true,
								operator : 'eq',
								options : [{
											id : 'UNKNOW',
											text : '未知'
										}, {
											id : 'MALE',
											text : '男'
										}, {
											id : 'FEMALE',
											text : '女'
										}]
							}
						}, {
							text : '电话',
							dataIndex : 'fPhone'
						}, {
							text : '邮箱',
							dataIndex : 'fEmail',
							hidden : true
						}, {
							text : '创建人',
							dataIndex : 'fCreater'
						}, {
							text : '创建日期',
							dataIndex : 'fCreateDate',
							width : '10%',
							align:'center',
							renderer : function(val) {
								return Ext.Date.format(new Date(val), 'Y-m-d');
							},
							filter : {
								type : 'date',
								dateFormat : 'Y-m-d',
								fields : {
									lt : {
										text : '之前'
									},
									gt : {
										text : '之后'
									}
								}
							}
						}],
				tbar : {
					xtype : 'userlisttoolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('s_userlist'),
							dock : 'bottom',
							displayInfo : true,
							// plugins: new Ext.ux.ProgressBarPager(),
							items : [{
										tooltip : '数据打印',
										xtype : 'splitbutton',
										glyph : 0xf02f,
										menu : [{
													text : '打印当前页',
													glyph : 0xf02f
												}, {
													text : '打印所有记录',
													glyph : 0xf02f
												}]
									}, {
										tooltip : '数据导出',
										xtype : 'splitbutton',
										glyph : 0xf1c3,
										menu : [{
													text : '列表导出至excel',
													glyph : 0xf1c3
												}, '-', {
													text : '选中记录导出至excel',
													glyph : 0xf1c3
												}]
									}]
						}]
			}

		})
