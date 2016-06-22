<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<!-- 海王星 -->
	<link rel="stylesheet" type="text/css" href="framework/ext/ext-theme-neptune/resources/ext-theme-neptune-all.css">
	<script type="text/javascript" src="framework/ext/bootstrap.js"></script>
	<script type="text/javascript" src="framework/ext/ext-theme-neptune/ext-theme-neptune.js"></script>
	<script type="text/javascript" src="framework/ext/ext-locale-zh_CN.js"></script> 
	<!-- 清新 -->
	<!-- <link rel="stylesheet" type="text/css" href="packages/ext-theme-crisp/build/resources/ext-theme-crisp-all.css">
	<script type="text/javascript" src="bootstrap.js"></script>
	<script type="text/javascript" src="packages/ext-theme-crisp/build/ext-theme-crisp.js"></script>
	<script type="text/javascript" src="packages/ext-theme-crisp/ext-locale-zh_CN-debug.js"></script> -->
</head>
<body>
	
</body>
</html>
<script type="text/javascript">
Ext.Loader.setConfig({ enabled: true });
Ext.Loader.setPath('Ext', 'framework/ext');
	Ext.require([  
	    'Ext.container.Viewport',  
	    'Ext.layout.container.Border',
	    'Ext.tab.Panel',
	    'Ext.ux.TabScrollerMenu',
	    'Ext.ux.TabReorderer'
	]);  

Ext.define('KitchenSink.view.tab.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    requires: [
        'Ext.ux.TabReorderer'
    ],
    xtype: 'reorderable-tabs',
    controller: 'reorderable-tabs',
    plugins: 'tabreorderer',
    defaults: {
        bodyPadding: 10,
        scrollable: true,
        closable: true
    },
    items: [{
        title: 'Tab 1',
        html: 'The tabs in this example are reorderable. Drag any tab to change the order.'
    },{
        title: 'Tab 2',
        html: 'The tabs in this example are reorderable. Drag any tab to change the order.'
    }]

   
});  
Ext.define('KitchenSink.view.tab.ReorderableTabsController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.reorderable-tabs',
    counter: 4,
    onAddTabClick: function() {
        var tabPanel = this.getView(),
            counter = ++this.counter,
            html = counter % 2 ? KitchenSink.DummyText.longText :
                KitchenSink.DummyText.extraLongText,
            tab = tabPanel.add({
                title: 'Tab ' + counter,
                html: html
            });

        tabPanel.setActiveTab(tab);
    }
});

Ext.define('KitchenSink.view.layout.Accordion', {
    extend: 'Ext.panel.Panel',
    requires: [
        'Ext.layout.container.Accordion'
    ],
    xtype: 'layout-accordion',
    layout: 'accordion',
    defaults: {
        bodyPadding: 10
    },
    
    changeRenderer: function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    },
    
    pctChangeRenderer: function(val){
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }
});

Ext.create('Ext.data.Store', {
    storeId: 'simpsonsStore',
    fields:[ 'name'],
	data: [
		{ name: 'Lisa'},
		{ name: 'Bart' },
		{ name: 'Homer'},
		{ name: 'Marge'}
	]
});

Ext.onReady(function() {  
    Ext.create('Ext.container.Viewport', {  
        layout: 'border',  
        defaults: { // defaults are applied to items, not the container
		    split: false,
            collapsible:false,
		    border:false,
		    frame: true
		},
        items: [{  
            region: 'north',  
            height: 70,
        },{  
            region: 'west',  
            id: 'west-region',
           // title: '菜单栏',    
            width: 250,  
            split: true,
            collapsible:true,
            scrollable:true,
            xtype: 'layout-accordion',
            items: [{
		        title: 'Active Tab',
		        xtype:'grid',
		        store: Ext.data.StoreManager.lookup('simpsonsStore'),
			    columns: [
			        { text: 'name', dataIndex: 'name' ,sortable:false,hideable:false,width:'90%'},
			    ],
			    hideHeaders:true
		    }, {
		        title: 'Inactive Tab',
		    }]
        }, {  
            region: 'center', 
            frame: false,
            xtype: 'reorderable-tabs',
        }]  
    });  
});  
</script>