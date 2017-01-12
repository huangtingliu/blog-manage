/**
 * 用户列表 - 工具栏
 */
Ext.define('BlogMgr.view.user.UserHomeToolBar', {
		    uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.userhome_toolbar',
			items : [{
						itemId : 'add',
						text : '新增',
						xtype:'transparent_button',
						handler:'addUser',
						glyph : 0xe618
					}, {
						itemId : 'edit',
						text : '修改',
						xtype:'transparent_button',
						glyph : 0xe63c,
						handler:'editUser'
					}, {
						itemId : 'delete',
						text : '删除',
						handler:'deleteUser',
						xtype:'transparent_button',
						glyph : 0xe617
					},{
						itemId : 'save',
						text : '保存编辑',
						handler:'saveRecord',
						xtype:'transparent_button',
						glyph : 0xe650
					},/*'-',{
							itendId:'chart',
							text : '图表',
							glyph : 0xf080,
							xtype:'transparent_button',
							tooltip : '图表分析'
						}, */{
							width : 100,
							blurWidth:100,
							xtype : 'gridsearchfield',
							emptyText:'用户名查询..',
							paramName:'fName',
							store :Ext.getStore('userPagingStore')
							}]

		});