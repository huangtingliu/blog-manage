Ext.define('Widget.tabs.controller.ReorderableTabsController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.reorderable-tabs',
    onAddTab: function(config) {	//附加一个tab
        var tabPanel = this.getView();
        var tab = tabPanel.child("#"+config.id);
       
        if(!Ext.isEmpty(tab)){	//该tab已经存在了
        }else{	//添加一个新的tab
        	tab = tabPanel.add({
	        	id:config.id,
	        	title: config.title,
	        	glyph:config.glyph,
	        	layout:'fit',
	        	height : '100%',
	        	width : '100%',
	        	items:Ext.create('BlogMgr.view.mgruser.UserList')
       	    });
        }
        tabPanel.setActiveTab(tab);
    },
    onClick:function(){
    },
	onRightClick:function(){
		
	}
});