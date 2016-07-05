/**
 * 导航栏菜单控制器
 */
Ext.define('BlogMgr.view.home.MenuGridController',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.menugrid',
    init: function() {},
    onClickRow: function(row,record,tr,rowIndex,e) {
        this.onLink({
        	id:record.get('fId'),
        	icon:record.get('fIcon'),
        	title:record.get('fName'),
        	url:record.get('fLink'),
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