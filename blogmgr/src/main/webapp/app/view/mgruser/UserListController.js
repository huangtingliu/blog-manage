/**
 * 用户列表控制器
 */
Ext.define('BlogMgr.view.mgruser.UserListController', {
	uses : ['BlogMgr.view.mgruser.UserAddDialog'],
	extend : 'Ext.app.ViewController',
	alias : 'controller.mgruserlist',
	init : function() {
		this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
	},
	addUser : function() { // 新增用户
		Ext.create('BlogMgr.view.mgruser.UserAddDialog').show();
	},

	deleteUser : function() { // 删除用户
		var _this = this;
		var grid = this.getView();
		var selectedRow = grid.getSelectionModel().getSelection();
		var ids = [];
		Ext.each(selectedRow, function() {
					ids.push(this.get("fId"));
				})
		if (ids.length == 0) {
			Ext.toast({
						type : 'info',
						content : '请指定要删除的记录'
					});
			return;
		}
		Ext.Msg.confirm('删除确认', '你真的要删除吗?', function(val) {
					if (val == 'yes') {
						_this.mask.show();
						Ext.Ajax.request({
									url : '/blogmgr/mgruser/delete.do',
									method : 'POST',
									params : {
										userIds : ids.join(',')
									},
									success : function(data) {
										_this.mask.hide();
										Ext.toast(JSON.parse(data.responseText));
										Ext.getStore('s_mgruserlist').reload();
										grid.getSelectionModel().deselectAll();
									},
									failure : function() {
										_this.mask.hide();
										Ext.toast({
													type : 'exception',
													content : '异常'
												});
									}
								});

					}
				});

	}

});