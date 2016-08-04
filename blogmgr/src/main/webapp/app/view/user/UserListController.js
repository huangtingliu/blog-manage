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
	
	addUser : function() { // 新增用户,弹出对话框
		Ext.create('BlogMgr.view.user.UserAddDialog').show();
	},

	deleteUser : function() { // 删除用户
		var _this = this;
		var grid = this.getView();
		var store = grid.getStore();
		var selectedRow = grid.getSelectionModel().getSelection();
		var ids = [];
		Ext.each(selectedRow, function() {
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
									url : '/blogmgr/user/delete.do',
									method : 'POST',
									params : {
										userIds : ids.join(',')
									},
									success : function(data) {
										_this.mask.msg="删除中...";
										_this.mask.hide();
										Ext.toast(JSON.parse(data.responseText));
										store.reload();
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

	},

	saveRecord :function(){	//表格编辑提交
		var _this = this;
		var grid = this.getView();
		var store = grid.getStore();
		var m = store.getModifiedRecords();  
	    var jsonArray = [];  
	    Ext.each(m,function(user){ 
	    	var updateField = user.getChanges();
	    	updateField.fId=user.getId();
	        jsonArray.push(user);  
	    });  
	
		Ext.Ajax.request({
					url : '/blogmgr/user/update.do',
					method : 'POST',
					params : {
						users : Ext.encode(jsonArray)//encodeURIComponent(Ext.encode(jsonArray))
					},
					success : function(data) {
						_this.mask.msg="提交中...";
						_this.mask.hide();
						Ext.toast(JSON.parse(data.responseText));
						store.reload();
					},
					failure : function() {
						_this.mask.hide();
						Ext.toast({
									type : 'exception',
									content : '异常'
								});
					}
				});

       //	store.commitChanges(); 消除红点
	}
});