/**
 * 系统管理- 功能列表
 */
Ext.define('BlogMgr.view.fun.FunctionGrid', {
	itemId : 'functionGrid',
	extend : 'Ext.grid.Panel',
	uses : ['Ux.button.TransparentButton', 'BlogMgr.view.fun.FunctionListToolBar'],
	alias : ['widget.functiongrid'],
	store : Ext.getStore('functionPagingStore'),
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
				header : '功能编号',
				dataIndex : 'fId',
				width:'14%',
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
				header : '功能名称',
				dataIndex : 'fName',
				width:'12%',
				sortable : false
			}, /*{
				header : '图标',
				dataIndex : 'fIcon',
				sortable : false,
				align : 'center',
				renderer:function(val){
					if(Ext.isEmpty(val)){return "";}
					return'<i class="iconfont '+val+'"><i/>';
				}
			},*/ {
				header : 'glyph值',
				dataIndex : 'fGlyph',
				sortable : false,
				align : 'center',
				width:'10%',
				renderer:function(val){
					if(Ext.isEmpty(val)){return "";}
					return'<i class="iconfont">&#'+val+'</i>&nbsp;'+val;
				}
			}, {
				header:'可用性',
				dataIndex : 'fUsability',
				sortable : false,
				align : 'center',
				width:'8%',
				renderer:function(val){
					if (val == 'ENABLE') {
						return '<b style="color:green">可用</b>';
					} else if (val == 'DISABLE') {
						return '<b style="color:red">不可用</b>';
					} else {
						return '未知';
					}
				}
			},{
				header : '处理方式',
				dataIndex : 'fHandler',
				sortable : false,
				width:'15%',
				renderer:function(val){
					if(Ext.isEmpty(val)){return '';}
					return '<span data-qtip="'+val+'" >'+val+'</span>';
				}
			}, {
				header : 'URL关联',
				dataIndex : 'fRelevance',
				//hidden : true,
				width:'14%',
				sortable : false,
				renderer:function(val){
					if(Ext.isEmpty(val)){return '';}
					return '<span data-qtip="'+val+'">'+val+'</span>';
				}
			}, {
				header : '功能排序',
				dataIndex : 'fOrder',
				align : 'center',
				width:'6%'
			}, {
				header : '功能类型',
				dataIndex : 'fType',
				sortable : false,
				align : 'center',
				width:'12%',
				renderer:function(val){
					if (val == 'NAVIGATOR') {
						return '导航菜单';
					} else if (val == 'TOOLBAR') {
						return '工具栏';
					} else if(val == 'UNIT') {
						return '单元';
					}else{
						return '未知';
					}
				}
			}],
	tbar : {
		xtype : 'functionlist_toolbar'
	},
	dockedItems : [{
				xtype : 'pagingtoolbar',
				dock : 'bottom',
				displayInfo : true,
				store : Ext.getStore('functionPagingStore')
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