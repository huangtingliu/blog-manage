/**
 * 菜单管理- 菜单列表
 */
Ext.define('BlogMgr.view.menu.MenuGrid', {
	itemId : 'menuGrid',
	extend : 'Ext.grid.Panel',
	uses : ['Ux.button.TransparentButton', 'BlogMgr.view.menu.MenuListToolBar'],
	alias : ['widget.menugrid'],
	store : Ext.getStore('menuPagingStore'),
	columnLines : true,
	autoLoad : true,
	scrollable : true,
	rowLines : true,
	plugins : ['gridfilters', 'cellediting'],
	selModel : {
		selType : 'checkboxmodel',
		ignoreRightMouseSelection : true,
		pruneRemoved : false,
		injectCheckbox : 1
	},
	viewConfig : {
		stripeRows : true, // 奇偶行不同底色
		enableTextSelection : true
	},
	columns : [{
				header : 'No',
				xtype : 'rownumberer',
				width : 37
			}, {
				header : '编号',
				dataIndex : 'fId',
				sortable : true,
				renderer:function(val){
					 if(Ext.isEmpty(val)){return val;}
					 var result = [];
					 for(var i = 0; i<val.length;i=i+4){
					 	var cor = (i+7).toString(16);
					 	if(parseInt(cor,16)>16){
					 		cor = (parseInt(cor,16)%9+7).toString(16);
					 	}
					 	result.push('<b style="color:#'+cor+'a7">'+val.substr(i,4)+'</b>');
					 }
					 return result.join('');
				}
			}, {
				header : '名称',
				dataIndex : 'fName',
				sortable : false
			}, {
				header : '图标',
				dataIndex : 'fIcon',
				sortable : false,
				align : 'center',
				renderer:function(val){
					return '<span class="fa '+val+'"></span>';
				}
			}, {
				header : 'glyph值',
				dataIndex : 'fGlyph',
				hidden : true,
				sortable : false
			}, {
				header : '视图类',
				dataIndex : 'fViewClass',
				sortable : false,
				renderer:function(val){
					if(Ext.isEmpty(val)){return '';}
					return '<span data-qtip="'+val+'" >'+val+'</span>';
				}
			}, {
				header : '链接',
				dataIndex : 'fUrl',
				hidden : true,
				sortable : false,
				renderer:function(val){
					if(Ext.isEmpty(val)){return '';}
					return '<span data-qtip="'+val+'">'+val+'</span>';
				}
			}, {
				header : '序号',
				dataIndex : 'fOrder',
				align : 'center'
			}, {
				header : '类型',
				dataIndex : 'fType',
				sortable : false,
				align : 'center',
				renderer:function(val){
					if (val == 'NAVIGATOR') {
						return '导航菜单';
					} else if (val == 'TOOLBAR') {
						return '工具栏';
					} else {
						return '未知';
					}
				}
			}],
	tbar : {
		xtype : 'menulist_toolbar'
	},
	dockedItems : [{
				xtype : 'pagingtoolbar',
				dock : 'bottom',
				displayInfo : true,
				store : Ext.getStore('menuPagingStore')
			/*	items : [{
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
						}]*/
			}]
})