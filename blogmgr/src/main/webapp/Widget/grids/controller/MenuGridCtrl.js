Ext.define('Widget.grids.controller.MenuGridCtrl',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.menugrid',
    init: function() {},
    onClickRow: function(row,record,tr,rowIndex,e) {
        this.onLink({
        	icon:record.get('icon'),
        	title:record.get('name'),
        	url:record.get('url')
        });
    },
    onLink:function(menu){
    	var tabPanel = Ext.getCmp('home-center');
    	if(Ext.isObject(tabPanel)){
	    	tabPanel.controller.onAddTab('1',menu.title,menu.url);
    	}
    }
    
});