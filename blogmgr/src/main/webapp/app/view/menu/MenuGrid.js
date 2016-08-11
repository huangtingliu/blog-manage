/**
 * 菜单管理- 菜单列表
 */
Ext.define('BlogMgr.view.menu.MenuGrid',{
	itemId : 'menuGrid',
	extend:'Ext.grid.Panel',
	alias : ['widget.menugrid'],
	columns: [
        { text: 'Name',  dataIndex: 'name' },
        { text: 'Email', dataIndex: 'email', flex: 1 },
        { text: 'Phone', dataIndex: 'phone' }
    ],
    dockedItems : [{
							xtype : 'pagingtoolbar',
							dock : 'bottom',
							displayInfo : true,
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
})