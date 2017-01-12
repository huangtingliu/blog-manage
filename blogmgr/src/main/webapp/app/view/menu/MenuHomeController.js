Ext.define('BlogMgr.view.menu.MenuHomeController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menuhome',
			uses:['BlogMgr.view.menu.mgr.MenuMgrDialog'],
			init : function() {
				this.mask = new Ext.LoadMask({
							msg : '删除中...',
							target : this.getView()
						});
			},
			/**
			 * 添加菜单
			 */
			addMenu:function(){
				Ext.create('BlogMgr.view.menu.mgr.MenuMgrDialog',{
					viewModel : {
						type : 'menu_add_dialog'
					}
				}).show();
			},
			/**
			 * 修改菜单
			 */
			editMenu:function(){
				var me = this;
				var menuGrid = this.lookupReference('menuGrid');
				var menuPagingStore = menuGrid.getStore();
				var selectedRows = menuGrid.getSelectionModel().getSelection();
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
				var editRecored = menuPagingStore.getById(ids[ids.length-1]);
				editRecored.load({
					callback:function(record, operation, success){
						me.mask.hide();
						if(success){
							var menuAddDialog = Ext.create('BlogMgr.view.menu.mgr.MenuMgrDialog',{
								viewModel:{
									type : 'menu_edit_dialog'
								}
							}).show();
							var menuAddForm = menuAddDialog.getComponent('menuMgrForm');
							menuAddForm.loadRecord(record);
							var menufId = record.get("fId");
							menuAddForm.getForm().setValues({
								fId:menufId.substr(-4,4)
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
			 * 删除菜单
			 */
			deleteMenu:function(){
				Ext.toast("待修改"); 
				return;
				var me = this;
				var menuGrid = this.lookupReference('menuGrid');
				var menuPagingStore = menuGrid.getStore();
				var selectedRows = menuGrid.getSelectionModel().getSelection();
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
									url : '/blogmgr/menu/delete.do',
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
												menuPagingStore.remove(selectedRows);
												menuGrid.getSelectionModel().deselectAll();
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