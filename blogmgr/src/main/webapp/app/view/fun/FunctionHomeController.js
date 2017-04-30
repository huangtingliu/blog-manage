/**
 * 系统功能管理控制器
 */
Ext.define('BlogMgr.view.fun.FunctionHomeController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.functionhome',
			uses:['BlogMgr.view.fun.mgr.FunctionMgrDialog'],
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			privates:{
				/**
				 * 返回选择记录的id
				 * @return 为一个数组
				 */
				getSelectedRowId:function(){
					var functionGrid = this.lookupReference('functionGrid');
					var selectedRows = functionGrid.getSelectionModel().getSelection();
					var ids = [];
					Ext.each(selectedRows, function() {
								ids.push(this.get("fId"));
							})
					if (ids.length == 0) {
						Ext.toast({
									type : 'info',
									content : '请选择操作的记录'
								});
						return [];
					}
					return ids;
				}
			},
			/**
			 * 添加功能
			 */
			addFunction:function(){
				Ext.create('BlogMgr.view.fun.mgr.FunctionMgrDialog',{
					viewModel : {
						type : 'function_add_dialog'
					}
				}).show();
			},
			/**
			 * 修改功能
			 */
			editFunction:function(){
				var ids = this.getSelectedRowId();
				if(ids.length==0){return;}
				
				var me = this;
				var functionGrid = this.lookupReference('functionGrid');
				var functionPagingStore = functionGrid.getStore();
				me.mask.msg='创建中...';
				me.mask.show();
				
				//表单数据回填
				var editRecored = functionPagingStore.getById(ids[ids.length-1]);
				editRecored.load({
					callback:function(record, operation, success){
						me.mask.hide();
						if(success){
							var functionAddDialog = Ext.create('BlogMgr.view.fun.mgr.FunctionMgrDialog',{
								viewModel:{
									type : 'function_edit_dialog'
								}
							}).show();
							var functionAddForm = functionAddDialog.getComponent('functionMgrForm');
							functionAddForm.loadRecord(record);
							var functionfId = record.get("fId");
							functionAddForm.getForm().setValues({
								fId:functionfId.substr(-4,4)
							});
						}else{
							Ext.toast({
								type : 'exception',
								content : '服务器请求失败'
							});
						}
					}
				});
			},
			/**
			 * 删除功能
			 */
			deleteFunction:function(){
				Ext.toast("待开发"); return;
				
				var ids = this.getSelectedRowId();
				if(ids.length==0){return;}
				
				Ext.Msg.confirm('系统提示', '确定要删除吗?', function(val) {
					if (val == 'yes') {
						me.mask.msg = "删除中...";
						me.mask.show();
						Ext.Ajax.request({
									url : '/blogmgr/function/delete.do',
									method : 'POST',
									params : {
										id : ids.join(',')
									},
									callback : function(options, isSuccess,response) {
										me.mask.hide();
										if (isSuccess) {
											var result = JSON.parse(response.responseText);
											Ext.toast(result);
											if (result.success) {
												functionPagingStore.remove(selectedRows);
												functionGrid.getSelectionModel().deselectAll();
												//TODO 界面刷新
											}
										} else {
											Ext.toast({
														type : 'exception',
														content : '服务器请求失败'
													});
										}
									}

								});
					}
				});
			},
			/**
			 * 保存编辑
			 */
			saveRecord:function(){
				Ext.toast('待实现');
			},
			/**
			 * 功能树节点点击事件处理
			 */
			funTreeNodeClick:function(tree , node , element , rowIndex , e , eOpts){
				 var store = Ext.getStore('functionPagingStore');
				 
				 if(node.isRoot()){
					 store.clearFilter();
				 }if(node.isLeaf()){
					 return;
				 }else{
					 store.addFilter({
						 property:'fParentId',
						 value:node.id,
						 operator:'like'
					 });
				 }
				
				 store.reload();
			}
			
		});