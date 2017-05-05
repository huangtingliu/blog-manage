/**
 * 备忘录列表 - 视图控制器
 */
Ext.define('BlogMgr.view.debug.memo.SystemMemoHomeController', {
	extend : 'Ext.app.ViewController',
	uses : [ 'BlogMgr.view.debug.memo.mgr.SystemMemoMgrDialog' ],
	alias : 'controller.system_memo_home',
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	privates : {
		/**
		 * 返回选择记录的id
		 * 
		 * @return 为一个数组
		 */
		getSelectedRowId : function() {
			var grid = this.getView().items.first();
			var selectedRows = grid.getSelectionModel().getSelection();
			var ids = [];
			Ext.each(selectedRows, function() {
				ids.push(this.get("fId"));
			})
			if (ids.length == 0) {
				Ext.toast({
					type : 'info',
					content : '请选择要操作的记录'
				});
				return [];
			}
			return ids;
		}
	},
	/**
	 * 添加便签
	 */
	addMemo : function() {
		Ext.create('BlogMgr.view.debug.memo.mgr.SystemMemoMgrDialog', {
			viewModel : {
				type : 'system_memo_add_dialog'
			}
		}).show();
	},

	/**
	 * 修改便签,侍开发
	 */
	editMemo : function() {
		var ids = this.getSelectedRowId();
		if(ids.length==0){return;}
		
		var me = this;
		var grid = me.getView().items.first();
		var store =  grid.getStore();
		me.mask.msg='创建中...';
		me.mask.show();
		
		//表单数据回填
		var editRecored = store.getById(ids[ids.length-1]);
		editRecored.load({
			callback:function(record, operation, success){
				me.mask.hide();
				if(success){
					var dialog = Ext.create('BlogMgr.view.debug.memo.mgr.SystemMemoMgrDialog',{
						viewModel:{
							type : 'system_memo_edit_dialog'
						}
					}).show();
					var form = dialog.getComponent('systemMemoMgrForm');
					form.loadRecord(record);
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
	 * 删除便签
	 */
	deleteMemo : function() {
		var ids = this.getSelectedRowId();
		if (ids.length == 0) {
			return;
		}
		var me = this;
		
		var grid = me.getView().items.first();
		var store =  grid.getStore();
		var selectedRows = grid.getSelectionModel().getSelection();

		Ext.Msg.confirm('系统提示', '确定要删除吗?', function(val) {
			if (val == 'yes') {
				me.mask.msg = "删除中...";
				me.mask.show();
				Ext.Ajax.request({
					url : '/blogmgr/debug/memo/delete.do',
					method : 'POST',
					params : {
						id : ids.join(',')
					},
					callback : function(options, isSuccess, response) {
						me.mask.hide();
						if (isSuccess) {
							var result = JSON.parse(response.responseText);
							Ext.toast(result);
							if (result.success) {
								store.remove(selectedRows);
								grid.getSelectionModel().deselectAll();
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

	}
});