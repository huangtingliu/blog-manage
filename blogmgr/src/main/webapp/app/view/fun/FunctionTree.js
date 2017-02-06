/**
 * 系统功能树
 */
Ext.define('BlogMgr.view.fun.FunctionTree',{
	id : 'functionTree',
	extend: 'Ext.tree.Panel',
	alias : ['widget.functiontree'],
	uses:['BlogMgr.store.FunctionTreeStore'],
    rootVisible: true,
    autoLoad:false,
    useArrows: true,
    root : {
				id:'root',
				text:'功能树',
				expanded : true //如果展开就会自动加载
			},
    store:Ext.getStore('functionHomeTreeStore')
});