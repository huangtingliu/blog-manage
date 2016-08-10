/**
 * 菜单树
 */
Ext.define('BlogMgr.view.menu.MenuTree',{
	id : 'menu_MenuTree',
	extend: 'Ext.tree.Panel',
	alias : ['widget.menutree'],
	uses: [
        'Ext.tree.*',
        'Ext.data.*'
    ],
    //rootVisible: false,
    useArrows: true,
    store:Ext.getStore('s_menutree')
});