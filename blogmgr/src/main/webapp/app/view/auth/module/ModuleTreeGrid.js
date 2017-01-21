/**
 * 权限配置 右边的模块列表树
 */
Ext.define('BlogMgr.view.auth.module.ModuleTreeGrid',{
	extend: 'Ext.tree.Panel',
		requires: [
		'Ext.data.*',
		'Ext.grid.*',
		'Ext.tree.*',
		'BlogMgr.model.PrivilegeTree'
		],    
	alias:'widget.auth_moduletreegrid',
	itemId:'moduleTreeGrid',
	useArrows: true,
    rootVisible: false,
	multiSelect: true,
	autoLoad:false,
	rowLines : true,
	columnLines:true,
    singleExpand: false,
    plugins : ['cellediting'],
	initComponent:function(){
		this.store = Ext.create('BlogMgr.store.PrivilegeTreeStore',{
			storeId : 'privilegeTreeStore',
			autoLoad:true
		});
		this.callParent();
	},
	viewConfig : {
		deferEmptyText  :false,
		stripeRows : true, // 奇偶行不同底色
		emptyText:'请选择左边的角色进行加载数据...'
	},
	columns : [{
		xtype: 'treecolumn',
		text : '组件编号',
		dataIndex : 'fFunId',
		flex:1.5,
		sortable:true,
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
		text : '组件名称',
		dataIndex : 'funName',
		flex:1,
		sortable:false
	},{
		text : '组件类型',
		dataIndex : 'fType',
		flex:0.5,
		sortable:true,
		renderer:function(val){
			if(val=="VIEW"){
				return '视图'
			}else if(val="FUNCTION"){
				return '功能'
			}
		}
	},{
		text : '组件状态',
		dataIndex : 'fPriority',
		flex:0.5,
		sortable:true,
		tooltip:"<b style='color:green'>可用</b>:&nbsp;功能可完全使用;<br>"+
			    "<b style='color:#7A7'>受约束</b>:功能只允操作本人的记录;<br>"+
			    "<b style='color:gray'>禁用</b>:&nbsp;功能不可使用，但可见;<br>"+
			    "<b style='color:red'>关闭</b>:&nbsp;功能完全不可用，且不可见.",
		editor:{
			xtype : 'combo',
			editable : false,
			store : [['ENABLE', '可用'], ['LIMIT', '受约束'],['DISABLE', '禁用'],['CLOSE', '关闭']]
		},
	    renderer:function(val){
			if(val=="ENABLE"){
				return '<b style="color:green">可用</b>';
			}else if(val=="LIMIT"){
				return '<b style="color:#7A7">受约束</b>';
			}else if(val=='DISABLE'){
				return '<b style="color:gray">禁用</b>';
			}else if(val=='CLOSE'){
				return '<b style="color:red">关闭</b>';
			}
		}
	}],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : Ext.getStore('privilegeTreeStore'),
		dock : 'bottom',
		displayInfo : true,
	}]
});