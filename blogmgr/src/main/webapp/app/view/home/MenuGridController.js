Ext.define('BlogMgr.view.home.MenuGridController',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.menugrid',
    init: function() {},
    onClickRow: function(row,record,tr,rowIndex,e) {
        this.onLink({
        	code:record.get('fId'),
        	icon:record.get('fIcon'),
        	title:record.get('fName'),
        	url:record.get('fLink')
        });
    },
    onLink:function(menu){
    	var tabPanel = Ext.getCmp('home-center');
    	if(Ext.isObject(tabPanel)){
	    	tabPanel.controller.onAddTab(menu.code,menu.title,menu.url);
    	}
    }
    
});