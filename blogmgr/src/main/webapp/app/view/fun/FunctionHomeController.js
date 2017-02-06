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
				var me = this;
				var functionGrid = this.lookupReference('functionGrid');
				var functionPagingStore = functionGrid.getStore();
				var selectedRows = functionGrid.getSelectionModel().getSelection();
				var ids = [];
				Ext.each(selectedRows, function() {
							ids.push(this.get("fId"));
						})
				if (ids.length == 0) {
					Ext.toast({
								type : 'info',
								content : '请选择要修改的记录'
							});
					return;
				}
				
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
				Ext.toast("待开发"); 
				return;   
				var me = this;
				var functionGrid = this.lookupReference('functionGrid');
				var functionPagingStore = functionGrid.getStore();
				var selectedRows = functionGrid.getSelectionModel().getSelection();
				var ids = [];
				Ext.each(selectedRows, function() {
							ids.push(this.get("fId"));
						})
				if (ids.length == 0) {
					Ext.toast({
								type : 'info',
								content : '请选择要删除的记录'
							});
					return;
				}
				
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
				Ext.toast('UnSupport operater');
			}
		});