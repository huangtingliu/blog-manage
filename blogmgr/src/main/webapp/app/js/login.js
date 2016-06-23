Ext.application({
  	  name:'blogMgr', 
  	  paths :{
  	  	'Extend':'app/Extend',
		'Ext':'framework/Ext',
		'BlogMgr':'app/BlogMgr'
  	  },
  	  launch:function(profile){
  	  	console.log("blogMgr begin ");
  	  }
});

Ext.require([  
    'Ext.container.Viewport',  
    'Ext.layout.container.Border',
    'Ext.tab.Panel',
    'Ext.ux.TabScrollerMenu',
    'Ext.ux.TabReorderer',
    'Extend.tabs.ReorderableTabs',
    'Extend.tabs.ReorderableTabsController',
    'Extend.accordion.Accordion'
]); 

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
            height: 70
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
			        { text: 'name', dataIndex: 'name' ,sortable:false,hideable:false,width:'90%'}
			    ],
			    hideHeaders:true
		    }, {
		        title: 'Inactive Tab'
		    }]
        }, {  
            region: 'center', 
            frame: false,
            xtype: 'reorderable-tabs'
        }]  
    });  
});  