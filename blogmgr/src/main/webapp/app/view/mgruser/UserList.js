/**
 * 后台用户列表
 */
Ext.define('BlogMgr.view.mgruser.UserList', {
			id : 'mgruser_UserList',
			uses : ['Widget.button.TransparentButton',
					'BlogMgr.view.mgruser.UserListToolBar',
					'BlogMgr.view.mgruser.UserListController',
					'BlogMgr.view.mgruser.UserListModel',
					'Ext.ux.ProgressBarPager',
					'Ext.grid.filters.Filters'],
			extend : 'Ext.panel.Panel',
			alias : ['widget.mgruserlist'],
			layout : 'fit',
			items : {
				xtype : 'grid',
				store : Ext.getStore('s_mgruserlist'),
				controller : 'mgruserlist',
				columnLines : true,
				autoLoad : true,
				scrollable : true,
				rowLines : true,
				plugins : 'gridfilters',
				viewModel : {
					type : 'mgruserlist'
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
								emptyText : '查询..'
							}
						}, {
							text : '账号',
							dataIndex : 'fAccount'
						}, {
							text : '状态',
							dataIndex : 'fStatus',
							renderer:function(val){
								if(val=='ENABLE'){
									return '<span style="color:green">可用</span>';
								}else if(val=='DISABLE'){
									return '<span style="color:red">不可用</span>';
								}else{
									return '未知';
								}
							},
							filter : {
								type : 'list',
								labelField: 'text',
								options : [
									{id:'ENABLE',text:'可用'},
									{id:'DISABLE',text:'不可用'}
								]
							}
						}, {
							text : '性别',
							dataIndex : 'fGender',
							hidden : true,
							filter:{
								type:'boolean',
								yesText:'男',
								noText :'女',
								operator:'eq'
							}
						}, {
							text : '电话',
							dataIndex : 'fPhone',
							filter:{
								type:'number'
							}
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
							width : '15%',
							filter:{
								 type: 'date',
								  dateFormat: 'm/d/Y'
							}
						}],
				tbar : {
					xtype : 'userlisttoolbar'
				},
				dockedItems : [{
							xtype : 'pagingtoolbar',
							store : Ext.getStore('s_mgruserlist'),
							dock : 'bottom',
							displayInfo : true,
							//plugins: new Ext.ux.ProgressBarPager(),
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
