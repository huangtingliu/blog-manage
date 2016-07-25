/**
 * 用户列表工具栏
 */
Ext.define('BlogMgr.view.mgruser.UserListToolBar', {
		    uses:['Widget.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.userlisttoolbar',
			items : [{
						itemId : 'add',
						text : '新增',
						xtype:'transparent_button',
						handler:'addUser',
						glyph : 0xf016
					}, {
						itemId : 'edit',
						text : '修改',
						xtype:'transparent_button',
						glyph : 0xf044
					}, {
						itemId : 'delete',
						text : '删除',
						handler:'deleteUser',
						xtype:'transparent_button',
						glyph : 0xf014
					},'-',{
							itendId:'chart',
							text : '图表',
							glyph : 0xf080,
							xtype:'transparent_button',
							tooltip : '图表分析'
						},'筛选', {
							width : 60,
							xtype : 'gridsearchfield',
							paramName:'fName',
							store :Ext.getStore('s_mgruserlist')
							}]

		});