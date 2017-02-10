/**
 * 后台用户列表 - 主页
 */
Ext.define('BlogMgr.view.user.UserHome', {
			id : 'userHome',
			requires : ['Ux.button.TransparentButton',
					'BlogMgr.view.user.UserHomeToolBar',
					'BlogMgr.view.user.UserHomeController',
					'BlogMgr.view.user.UserHomeModel',
					'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.userhome'],
			layout : 'fit',
			items : {
				controller : 'userhome',
				viewModel : {
					type : 'userhome'
				},
				xtype : 'grid',
				store : Ext.getStore('userPagingStore'),
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
							header : '名称',
							dataIndex : 'fName',
							sortable:false,
							width : '11%',
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
							width : '11%',
							filter : {
								type : 'string',
								emptyText : '账号..'
							}
						}, {
							header : '状态',
							dataIndex : 'fStatus',
							align : 'center',
							sortable:false,
							width : '7%',
							renderer : function(val) {
								if (val == 'ENABLE') {
									return '<b style="color:green">可用</b>';
								} else if (val == 'DISABLE') {
									return '<b style="color:red">不可用</b>';
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
							width : '7%',
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
							width : '12%',
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
							width : '12%',
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
							width : '11%',
							align : 'center',
							hidden : true,
							renderer : function(val) {
								return Ext.Date.format(new Date(val), 'Y-m-d');
							},
							filter : {
								type : 'date',
								dateFormat : 'Y-m-d'
							}
						},{
							header : '操作',
							xtype: 'actioncolumn',
							width : '5%',
							sortable: false,
							align:'center',
							menuDisabled: true,
			                items: [{
			                    tooltip: '用户详情',
			                    iconCls:'img-icon-detail',
			                    scope: this,
			                    handler:function(view,rowIndex,colIndex,item,e,record){
			                		var gridController = view.ownerCt.getController();
			                		gridController.userDetail(view,rowIndex,colIndex,item,e,record);
			                	}
			                }]
						}],
				tbar : {
					xtype : 'userhome_toolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('userPagingStore'),
							dock : 'bottom',
							displayInfo : true,
							items : [{
										tooltip : '数据打印',
										xtype : 'splitbutton',
										glyph : 0xe6b6,
										menu : [{
													text : '打印当前页',
													glyph : 0xe6b6
												}, {
													text : '打印所有记录',
													glyph : 0xe6b6,
													handler:'pringAllUser'
												}]
									}, {
										tooltip : '数据导出',
										xtype : 'splitbutton',
										glyph : 0xe63d,
										menu : [{
													text : '导出选中用户',
													glyph : 0xe63d,
													handler:'exportSelectedUser'
												},'-',{
													text : '导出所有用户',
													glyph : 0xe63d,
													handler:'exportAllUser'
												}]
									}]
						}],
			}
		})
