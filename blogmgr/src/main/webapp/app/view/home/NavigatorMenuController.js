/**
 * 导航栏菜单控制器
 */
Ext.define('BlogMgr.view.home.NavigatorMenuController',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.navigatormenu',
    init: function() {},
    onClickRow: function(row,record,tr,rowIndex,e) {
    	if(this.getView().authPriority=='DISABLE'){
    		//Ext.toast("当前功能被禁用了！");
    		return;
    	}
    	if(record.get('authPriority')=='DISABLE'){//当前菜单处理禁用状态
    		//Ext.toast("当前功能被禁用了！");
    		return;
    	}
        this.onLink({
        	id:record.get('fId'),
        	icon:record.get('fIcon'),
        	title:record.get('fName'),
        	viewClass:record.get('fViewClass'),
        	url:record.get('fUrl'),
        	glyph:record.get('fGlyph')
        });
    },
    onLink:function(item){
    	var tabPanel = Ext.getCmp('home-center');
    	//TODO  tabPanel可能不存在
    	if(Ext.isObject(tabPanel)){
	    	tabPanel.controller.onAddTab(item);
    	}
    }
    
});