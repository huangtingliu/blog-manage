/**
 * 菜单树
 */
Ext.define('BlogMgr.view.menu.MenuTree',{
	id : 'menuTree',
	extend: 'Ext.tree.Panel',
	alias : ['widget.menutree'],
	uses:['BlogMgr.store.MenuTreeStore'],
    rootVisible: true,
    autoLoad:false,
    useArrows: true,
    root : {
				id:'root',
				text:'菜单树',
				expanded : true //如果展开就会自动加载
			},
    store:Ext.getStore('menuHomeTreeStore')
});