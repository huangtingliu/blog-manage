/**
 * 后台用户列表
 */
Ext.define('BlogMgr.view.mgruser.UserList', {
			id:'mgruser_UserList',
			uses : ['Widget.button.TransparentButton',
					'BlogMgr.view.mgruser.UserListToolBar',
					'BlogMgr.view.mgruser.UserListModel',
					'BlogMgr.view.mgruser.UserListController'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.mgruserlist'],
			layout : 'fit',
			items : {
				xtype : 'grid',
				store : Ext.getStore('s_mgruserlist'),
				controller : 'mgruserlist',
				viewModel : {
					type : 'mgruserlist'
				},
				columnLines : true,
				selModel : {
					mode : "SINGLE", // "SINGLE"/"SIMPLE"/"MULTI"
					checkOnly : true
					// 只能通过checkbox选择
				},
				viewConfig : {
					stripeRows : true, // 奇偶行不同底色
					enableTextSelection : true
				},
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				columns : [{
							xtype : 'rownumberer',
							width : 27
						}, {
							xtype : 'checkcolumn',
							dataIndex : 'ck',
							width : 35,
							sortable : false,
							autoLock : true,
							menuDisabled : true,
							hideable : false,
							resizable : false,
							draggable : false
						}, {
							text : '名称',
							dataIndex : 'fName'
						}, {
							text : '账号',
							dataIndex : 'fAccount'
						}, {
							text : '状态',
							dataIndex : 'fStatus'
						},{
							text : '性别',
							dataIndex : 'fGender',
							hidden:true
						},{
							text : '电话',
							dataIndex : 'fPhone'
						},{
							text : '邮箱',
							dataIndex : 'fEmail',
							hidden:true
						}, {
							text : '创建人',
							dataIndex : 'fCreater'
						}, {
							text : '创建日期',
							dataIndex : 'fCreateDate',
							width:'15%'
						}],
				tbar : {
					xtype : 'userlisttoolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('s_mgruserlist'),
							dock : 'bottom',
							displayInfo : true,
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
