/**
 * 用户列表控制器
 */
Ext.define('BlogMgr.view.user.UserListController', {
	uses : ['BlogMgr.view.user.UserAddDialog'],
	extend : 'Ext.app.ViewController',
	alias : 'controller.userlist',
	init : function() {
		this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
	},

	/**
	 * 新增用户,弹出对话框
	 */
	addUser : function() {
		Ext.create('BlogMgr.view.user.UserAddDialog').show();
	},

	/**
	 * 删除用户
	 */
	deleteUser : function() {
		var _this = this;
		var grid = this.getView();
		var store = grid.getStore();
		var selectedRows = grid.getSelectionModel().getSelection();
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
						_this.mask.msg = "删除中...";
						_this.mask.show();
						Ext.Ajax.request({
									url : '/blogmgr/user/delete.do',
									method : 'POST',
									params : {
										userIds : ids.join(',')
									},
									callback : function(options, isSuccess,response) {
										_this.mask.hide();
										if (isSuccess) {
											var result = JSON.parse(response.responseText);
											Ext.toast(result);
											if (result.success) {
												// store.reload();
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

	},

	/**
	 * 表格编辑提交
	 */
	saveRecord : function() {
		var _this = this;
		var grid = this.getView();
		var store = grid.getStore();
		var m = store.getModifiedRecords();
		var jsonArray = [];
		Ext.each(m, function(user) {
					var updateField = user.getChanges();
					updateField.fId = user.getId();
					jsonArray.push(updateField);
				});
		_this.mask.msg = "提交中...";
		_this.mask.show();
		Ext.Ajax.request({
					url : '/blogmgr/user/batchedit.do',
					method : 'POST',
					params : {
						users : Ext.encode(jsonArray)
						// encodeURIComponent(Ext.encode(jsonArray))
					},
					callback : function(options, isSuccess, response) {
						_this.mask.hide();
						if (isSuccess) {
							var result = JSON.parse(response.responseText);
							Ext.toast(result);
							if (result.success) {
								store.commitChanges(); // 消除修改标记
								// store.reload();
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