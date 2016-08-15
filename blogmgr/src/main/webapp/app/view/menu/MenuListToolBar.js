/**
 * 菜单管理 - 工具栏
 */
Ext.define('BlogMgr.view.menu.MenuListToolBar', {
			uses : ['Ux.input.GridSearchField'],
			extend : 'Ext.toolbar.Toolbar',
			alias : 'widget.menulist_toolbar',
			items : [{
						itemId : 'add',
						text : '新增',
						handler : 'addMenu',
						xtype : 'transparent_button',
						glyph : 0xe6cb
					}, {
						itemId : 'edit',
						text : '修改',
						handler : 'editMenu',
						xtype : 'transparent_button',
						glyph : 0xe63c
					}, {
						itemId : 'delete',
						text : '删除',
						handler : 'deleteMenu',
						xtype : 'transparent_button',
						glyph : 0xe62d
					}, {
						itemId : 'save',
						text : '保存编辑',
						handler : 'saveRecord',
						xtype : 'transparent_button',
						glyph : 0xe650
					},/*
						 * '-',{ itendId:'chart', text : '图表', glyph : 0xf080,
						 * xtype:'transparent_button', tooltip : '图表分析' },
						 */{
						width : 100,
						blurWidth : 100,
						xtype : 'gridsearchfield',
						emptyText : '菜单名查询..',
						paramName : 'fName',
						store : Ext.getStore('menuPagingStore')
					}]
		});