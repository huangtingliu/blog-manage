/**
 * 后台用户列表
 */

Ext.define('BlogMgr.view.mgruser.UserList', {
			uses : ['Widget.button.TransparentButton',
					'BlogMgr.view.mgruser.UserListModel',
					'BlogMgr.view.mgruser.UserListController'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.mgruserlist'],
			layout:'fit',
			items : {
				xtype : 'grid',
				store : Ext.getStore('s_mgruserlist'),
				controller:'mgruserlist',
				viewModel : {
					type : 'mgruserlist'
				},
				columnLines : true,
				height : '100%',
				width : '100%',
				selModel : {
					mode : "SINGLE", // "SINGLE"/"SIMPLE"/"MULTI"
					checkOnly : true // 只能通过checkbox选择
				},
				viewConfig : {
					stripeRows : true, // 奇偶行不同底色
					enableTextSelection : true
				},
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				forceFit : true,
				columns : [{
							xtype : 'rownumberer',
							width : 27
						}, {
							xtype : 'checkcolumn',
							dataIndex : 'fId',
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
							dataIndex : 'statusName'
						}, {
							text : '创建人',
							dataIndex : 'createrName'
						}, {
							text : '创建日期',
							dataIndex : 'createDate'
						}],
				tbar : [{
							xtype : 'transparent_button',
							text : '添加',
							glyph:0xf005
						},{
							xtype : 'transparent_button',
							text : '删除',
							glyph:0xf108
						},{
							xtype : 'transparent_button',
							text : '修改',
							glyph:0xf128
						}],
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('s_mgruserlist'),
							dock : 'bottom',
							displayInfo : true
						}]
			}

		})
