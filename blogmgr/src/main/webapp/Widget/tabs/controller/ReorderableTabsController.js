Ext.define('Widget.tabs.controller.ReorderableTabsController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.reorderable-tabs',
    onAddTab: function(id,title,url) {	//附加一个tab
        var tabPanel = this.getView();
        var tab = tabPanel.child("#"+id);
        
        if(!Ext.isEmpty(tab)){	//该tab已经存在了
        }else{	//添加一个新的tab
        	tab = tabPanel.add({
	        	title: title,
	        	id:id,
	            html: ''
       	    });
        }
        tabPanel.setActiveTab(tab);
    },
    onClick:function(){
    	console.info('tab click');
    },
	onRightClick:function(){
		
	}
});