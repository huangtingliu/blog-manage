Ext.define('Widget.layout.DefaultLayout',{
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
		        { text: 'name', dataIndex: 'name' ,sortable:false,hideable:false,width:'90%'},
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