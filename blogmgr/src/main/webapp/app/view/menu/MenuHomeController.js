Ext.define('BlogMgr.view.menu.MenuHomeController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.menuhome',
			uses:['BlogMgr.view.menu.MenuMgrDialog'],
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
				Ext.create('BlogMgr.view.menu.MenuMgrDialog',{
					viewModel:{
						data:{
							title:'添加菜单',
							saveHandler:'userAddSubmit'
						}
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
				
				var menuAddDialog = Ext.create('BlogMgr.view.menu.MenuMgrDialog',{
					viewModel:{
						data:{
							title:'修改菜单',
							saveHandler:'userEditSubmit'
						}
					}
				}).show();
				
				//表单数据回填
				var editRecored = menuPagingStore.getById(ids[ids.length-1]);
				var menuAddForm = menuAddDialog.getComponent('menuMgrForm');
				menuAddForm.loadRecord(editRecored);
				var menufId = editRecored.get("fId");
				menuAddForm.getForm().setValues({
					fId:menufId.substr(-4,4)
				});
			},
			/**
			 * 修改菜单
			 */
			deleteMenu:function(){
				Ext.toast('UnSupport operater');
			},
			/**
			 * 保存编辑
			 */
			saveRecord:function(){
				Ext.toast('UnSupport operater');
			}
		});