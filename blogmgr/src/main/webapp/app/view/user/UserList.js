/**
 * 后台用户列表 - 主页
 */
Ext.define('BlogMgr.view.user.UserList', {
			id : 'user_UserList',
			uses : ['Ux.button.TransparentButton',
					'BlogMgr.view.user.UserListToolBar',
					'BlogMgr.view.user.UserListController',
					'BlogMgr.view.user.UserListModel',
					 'Ext.grid.filters.Filters'/*,'Ext.ux.ProgressBarPager'*/],
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
				plugins : ['gridfilters', 'cellediting'],
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
							header : 'No',
							xtype : 'rownumberer',
							width : 37
						}, {
							header : '名称',
							dataIndex : 'fName',
							sortable:false,
							editor : {
								allowBlank : false,
								vtype:'chinese',
								maxLength:10
							},
							filter : {
								type : 'string',
								emptyText : '名称..'
							}
						}, {
							header : '账号',
							dataIndex : 'fAccount',
							sortable:false,
							filter : {
								type : 'string',
								emptyText : '账号..'
							}
						}, {
							header : '状态',
							dataIndex : 'fStatus',
							align : 'center',
							sortable:false,
							renderer : function(val) {
								if (val == 'ENABLE') {
									return '<span style="color:green">可用</span>';
								} else if (val == 'DISABLE') {
									return '<span style="color:red">不可用</span>';
								} else {
									return '未知';
								}
							},
							editor : {
								xtype : 'combo',
								editable : false,
								store : [['ENABLE', '可用'], ['DISABLE', '不可用']]
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
							header : '性别',
							dataIndex : 'fGender',
							hidden : true,
							align : 'center',
							sortable:false,
							editor : {
								xtype : 'combo',
								editable : false,
								store : [['UNKNOW', '未知'], ['MALE', '男'],
										['FEMALE', '女']]
							},
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
							header : '电话',
							dataIndex : 'fPhone',
							sortable:false,
							filter : {
								type : 'string',
								emptyText : '电话..'
							},
							editor : {
								xtype : 'textfield',
								allowBlank : true,
								vtype:'mobile'
							}
						}, {
							header : '邮箱',
							dataIndex : 'fEmail',
							sortable:false,
							filter : {
								operator : 'eq',
								type : 'string',
								emptyText : '电话..'
							},
							editor : {
								xtype : 'textfield',
								allowBlank : true,
								vtype:'email'
							}
						}, {
							header : '创建人',
							dataIndex : 'fCreater',
							hidden : true,
							sortable:false
						}, {
							header : '创建日期',
							dataIndex : 'fCreateDate',
							width : '10%',
							align : 'center',
							renderer : function(val) {
								return Ext.Date.format(new Date(val), 'Y-m-d');
							},
							filter : {
								type : 'date',
								dateFormat : 'Y-m-d'
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
