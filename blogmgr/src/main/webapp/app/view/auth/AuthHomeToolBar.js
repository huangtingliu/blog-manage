/**
 * 权限列表 - 工具栏
 */
Ext.define('BlogMgr.view.auth.AuthHomeToolBar', {
		    uses:['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.authhome_toolbar',
			items : [{
						itemId : 'add',
						text : '新增角色',
						handler : 'addRole',
						xtype : 'transparent_button',
						glyph : 0xe6cb
					},{
						itemId : 'edit',
						text : '修改角色',
						handler : 'editRole',
						xtype : 'transparent_button',
						glyph : 0xe63c
					},{
						itemId : 'delete',
						text : '删除角色',
						handler:'deleteRole',
						xtype:'transparent_button',
						glyph : 0xe62d
					},{
						itemId : 'save',
						text : '保存编辑',
						handler:'saveRecord',
						xtype:'transparent_button',
						tooltip:'保存编辑好的角色数据',
						glyph : 0xe650
					},{
						width : 110,
						blurWidth : 130,
						xtype : 'gridsearchfield',
						emptyText : '角色名查询..',
						paramName : 'fName',
						store : Ext.getStore('rolePagingStroe')
				}]

		});