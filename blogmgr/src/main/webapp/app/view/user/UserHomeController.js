/**
 * 用户列表 - 视图控制器
 */
Ext.define('BlogMgr.view.user.UserHomeController', {
	uses : ['BlogMgr.view.user.mgr.UserMgrDialog'],
	extend : 'Ext.app.ViewController',
	alias : 'controller.userhome',
	init : function() {
		this.mask = new Ext.LoadMask({
					msg : '删除中...',
					target : this.getView()
				});
	},
	privates:{
		/*
		 * 获取选中的用户id,
		 * @return 为一个字符串数组：如：['aaa','sss']
		 */
		getSelectedRowId:function(){
			var grid = this.getView();
			var selectedRows = grid.getSelectionModel().getSelection();
			var ids = [];
			Ext.each(selectedRows, function() {
						ids.push(this.get("fId"));
					})
			if (ids.length == 0) {
				Ext.toast({
							type : 'info',
							content : '请选择所要的记录'
						});
				return [];
			}
			return ids;
		}
	},
	
	/**
	 * 新增用户,弹出对话框
	 */
	addUser : function() {
		Ext.create('BlogMgr.view.user.mgr.UserMgrDialog').show();
	},
	/**
	 * 修改用户
	 */
	editUser:function(){
		 Ext.toast('待实现');
	},
	
	/**
	 * 删除用户
	 */
	deleteUser : function(toolbarBtn) {
		var ids = this.getSelectedRowId();
		if(ids.length==0){return;}
		
		var _this = this;
		var grid = this.getView();
		var store = grid.getStore();
		var selectedRows = grid.getSelectionModel().getSelection();
		Ext.Msg.confirm('系统提示', '确定要删除吗?', function(val) {
					if (val == 'yes') {
						_this.mask.msg = "删除中...";
						_this.mask.show();
						Ext.Ajax.request({
									url : '/blogmgr/user/delete.do',
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
		if(m.length==0){
			Ext.toast('记录未被编辑');return;
		}
		var jsonArray = [];
		Ext.each(m, function(user) {
					var updateField = user.getChanges();
					updateField.fId = user.getId();
					jsonArray.push(updateField);
				});
		_this.mask.msg = "提交中...";
		_this.mask.show();
		Ext.Ajax.request({
					url : '/blogmgr/user/editbatch.do',
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
	},
	//用户详情
	userDetail:function(view,rowIndex,colIndex,item,e,record){
		Ext.toast('待完成');
	},
	/**
	 * 导出所有用户
	 */
	exportAllUser:function(){
	    Ext.downloadFile({
	    	 url:'/blogmgr/user/export_user_list.data',
		     method:'POST',
		     params:{type:'ALL'}
	    });
	},
	/**
	 * 导出所选用户
	 */
	exportSelectedUser:function(){
		var ids = this.getSelectedRowId();
		if(ids.length==0){return;}
		 Ext.downloadFile({
	    	 url:'/blogmgr/user/export_user_list.data',
		     method:'POST',
		     params:{
			 	type:'SELECTED',
			 	userIds:ids.join(',')
			 }
	    });
	},
	/**
	 * 打印所有用户
	 */
	pringAllUser:function(){
		window.print();	
	}
	 
	 
});