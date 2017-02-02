/**
 * 权限列表工具栏
 */
Ext.define('BlogMgr.view.auth.AuthHomeController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.authhome',
	uses:['BlogMgr.view.auth.role.RoleAddDialog'],
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	/**
	 * 新增角色
	 */
	addRole:function(){
		 Ext.create('BlogMgr.view.auth.role.RoleAddDialog').show();
	},
	/**
	 * 修改角色
	 */
	editRole:function(){
		 Ext.toast('UnSupport operater');
	},
	/**
	 * 删除角色
	 */
	deleteRole:function(){
		var _this = this;
		var roleGrid = this.getView().getComponent('roleGrid');
		var store = roleGrid.getStore();
		var selectedRows = roleGrid.getSelectionModel().getSelection();
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
						_this.mask.show();
						Ext.Ajax.request({
									url : '/blogmgr/role/delete.do',
									method : 'POST',
									params : {
										id : ids.join(',')
									},
									callback : function(options, isSuccess,response) {
										_this.mask.hide();
										if (isSuccess) {
											var result = JSON.parse(response.responseText);
											Ext.toast(result);
											if (result.success) {
												store.remove(selectedRows);
												roleGrid.getSelectionModel().deselectAll();
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
	saveRecord : function() {
		var _this = this;
		var grid = this.getView().getComponent('moduleTreeGrid');
		var store = grid.getStore();
		var m = store.getModifiedRecords();
		if(m.length==0){
			Ext.toast('组件状态未被编辑');return;
		}
		var jsonArray = [];
		Ext.each(m, function(privilege) {
					var updateField = privilege.getChanges();
					updateField.fId = privilege.get('fId');
					jsonArray.push(updateField);
				});
		_this.mask.msg = "提交中...";
		_this.mask.show();
		Ext.Ajax.request({
					url : '/blogmgr/privilege/editbatch.do',
					method : 'POST',
					params : {
						privileges : Ext.encode(jsonArray)
						// encodeURIComponent(Ext.encode(jsonArray))
					},
					callback : function(options, isSuccess, response) {
						_this.mask.hide();
						if (isSuccess) {
							var result = JSON.parse(response.responseText);
							Ext.toast(result);
							if (result.success) {
								store.commitChanges(); // 消除修改标记
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