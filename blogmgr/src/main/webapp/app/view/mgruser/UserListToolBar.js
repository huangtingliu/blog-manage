Ext.define('BlogMgr.view.mgruser.UserListToolBar', {
		    uses:['Widget.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.userlisttoolbar',
			items : [{
						text : '新增',
						itemId : 'new',
						glyph : 0xf016

					}, {
						text : '修改',
						glyph : 0xf044,
						itemId : 'edit'
					}, {
						text : '删除',
						glyph : 0xf014,
						itemId : 'delete'
					},'-',{
							glyph : 0xf080,
							text : '图表',
							tooltip : '图表分析'
						},'筛选', {
							width : 60,
							xtype : 'gridsearchfield',
							store : Ext.create('Ext.data.Store', {
										proxy : {
											type : 'rest'
										}
									})
							}]

		});