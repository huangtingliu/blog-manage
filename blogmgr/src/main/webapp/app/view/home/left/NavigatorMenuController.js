/**
 * 导航栏菜单控制器
 */
Ext.define('BlogMgr.view.home.left.NavigatorMenuController',{
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
        	id:record.get('fFunId'),
        	icon:record.get('funIcon'),
        	title:record.get('funName'),
        	viewClass:record.get('funHandler'),
        	glyph:record.get('funGlyph')
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