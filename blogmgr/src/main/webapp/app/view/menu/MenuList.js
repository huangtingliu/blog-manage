/**
 * 菜单管理
 */
Ext.define('BlogMgr.view.menu.MenuList', {
	id : 'menu_MenuList',
	extend : 'Ext.panel.Panel',
	alias : ['widget.menulist'],
	uses:['BlogMgr.view.menu.MenuTree'],
	layout : 'column',
	items : [{
				columnWidth : 0.25,
				xtype:'menutree'
			}, {
				columnWidth : 0.75,
				html : '<p>This is some longer content.longer content.longer content.longer content.longer content. longer content.</p>'
			}]
});