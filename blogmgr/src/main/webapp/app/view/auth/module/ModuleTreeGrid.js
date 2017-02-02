/**
 * 权限配置 右边的模块列表树
 */
Ext.define('BlogMgr.view.auth.module.ModuleTreeGrid',{
	extend: 'Ext.tree.Panel',
		requires: [
		'Ext.data.*',
		'Ext.grid.*',
		'Ext.tree.*',
		'BlogMgr.model.PrivilegeTree',
		'BlogMgr.view.auth.module.ModuleTreeGridController'
		],    
	alias:'widget.auth_moduletreegrid',
	itemId:'moduleTreeGrid',
	controller:'auth_moduletreegrid',
	useArrows: true,
    rootVisible: false,
	multiSelect: true,
	autoLoad:false,
	rowLines : true,
	columnLines:true,
    singleExpand: false,
    plugins : ['cellediting'],
	initComponent:function(){
		var treeGrid = this;
		this.store = Ext.create('BlogMgr.store.PrivilegeTreeStore',{
			storeId : 'privilegeTreeStore',
			autoLoad:true,
			listeners:{
				/**
				 * 当组件状态更新时，其父节点和其子节点也要随之改变
				 * 1.ENABLE  其父节点都将变为ENABLE
				 * 2.ALL_ENABLE 其父节点都将变为ENABLE，且，其下子节点都将变为ENABLE
				 * 3.LIMIT 其父节点变为ENABLE，其子节点状态为LIMIT
				 * 4.DISABLE 其下子节点都将变为DISABLE
				 * 5.CLOSE 其下子节点都将变为CLOSE
				 */
				update :function(_this , record , operation , modifiedFieldNames , details , eOpts ){
					//遍历所有的子节点
					var allChild=function(root,fn){  
	                     root.eachChild(function(node){  
	                    	 fn(node);
	                         if(node.hasChildNodes())//胖墩是否有子节点  
	                             {  
	                                 allChild(node,fn);  
	                             }  
	                     });  
					 };  
					 
					 //遍历所有的父亲节点,不包括根节点
                    var allParent=function(currentNode,fn){  
                    	var parentNode = currentNode.parentNode;
                    	
                        if(parentNode!= null && !parentNode.isRoot()){  
                        	fn(parentNode);
                            allParent(parentNode,fn);  
                        }  
                    };  
				    
				    var m = _this.getModifiedRecords();
					if(m.length==0 || Ext.isEmpty(modifiedFieldNames)){return;}
					
					if( Ext.Array.contains(modifiedFieldNames,'fPriority')){
						var priority = record.get('fPriority');
						var currentNode = _this.getNodeById(record.getId()); //当前修改的节点
						
						if(priority=='CLOSE'){
							allChild(currentNode,function(node){
								var rec = _this.getById(node.getId());
								rec.set('fPriority','CLOSE');
							}); 
						}else if(priority=='DISABLE'){
							allChild(currentNode,function(node){
								var rec = _this.getById(node.getId());
								rec.set('fPriority','DISABLE');
							}); 
						}else if(priority=='LIMIT'){
							allParent(currentNode,function(node){
								var rec = _this.getById(node.getId());
								if(rec.get('fPriority')=='DISABLE' || rec.get('fPriority')=='CLOSE'){
									rec.set('fPriority','ENABLE');
								}
							});
							allChild(currentNode,function(node){
								var rec = _this.getById(node.getId());
								rec.set('fPriority','LIMIT');
							}); 
						}else {
							allParent(currentNode,function(node){
								var rec = _this.getById(node.getId());
								rec.set('fPriority','ENABLE');
							});
							if(priority=='ALL_ENABLE'){
								record.set('fPriority','ENABLE');
								allChild(currentNode,function(node){
									var rec = _this.getById(node.getId());
									rec.set('fPriority','ENABLE');
								}); 
							}
						}
					}
					
				}
			}
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
		tooltip:'双击展开或收起',
		sortable:false,
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
		sortable:false,
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
		sortable:false,
		tooltip:"<b style='color:green'>可用</b>:&nbsp;功能可完全使用;<br>"+
			    "<b style='color:#7A7'>受约束</b>:功能只允操作本人的记录;<br>"+
			    "<b style='color:gray'>禁用</b>:&nbsp;功能不可使用，但可见;<br>"+
			    "<b style='color:red'>关闭</b>:&nbsp;功能完全不可用，且不可见.",
		editor:{
			xtype : 'combo',
			editable : false,
			store : [['ENABLE', '唯此可用'],['ALL_ENABLE', '全部可用'], ['LIMIT', '受约束'],['DISABLE', '禁用'],['CLOSE', '关闭']]
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
			}else if(val=='ALL_ENABLE'){
				return '<b style="color:green">可用</b>';
			}
		}
	}],
	listeners:{
		afterrender:'treeGridAfterRender'
	}
});