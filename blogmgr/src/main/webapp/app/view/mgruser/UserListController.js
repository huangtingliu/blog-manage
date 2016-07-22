/**
 * 用户列表控制器
 */
Ext.define('BlogMgr.view.mgruser.UserListController',{
	uses:['BlogMgr.view.mgruser.UserAddDialog'],
	extend: 'Ext.app.ViewController',
    alias: 'controller.mgruserlist',
    init: function() {},
    addUser:function(){	//新增用户
    	Ext.create('BlogMgr.view.mgruser.UserAddDialog').show();
    },
    deleteUser:function(){	//删除用户
    	var grid = this.getView();
    	var selectedRow = grid.getSelectionModel().getSelection();
    	var ids = [];
    	Ext.each(selectedRow,function(){
    		ids.push(this.get("fId"));
		})
    	Ext.Ajax.request({
    		url:'/blogmgr/mgruser/delete.do',
    		method:'POST',
    		params:{
    			userIds:ids.join(',')
    		},
    		success:function(data){
    			Ext.toast(JSON.parse(data.responseText));
    			Ext.getStore('s_mgruserlist').reload();
    		},
    		failure:function(){
    			Ext.toast({
    				type:'exception',
    				content:'异常'
    			});
    		}
    	});
    }
    
});