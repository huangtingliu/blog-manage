Ext.application({
	launch:function(){
		
	}
});

Ext.onReady(function(){
	console.info("index");
	Ext.create('Ext.Button', {
    text: 'Click me',
    renderTo: Ext.get('btn1'),
    handler: function() {
        alert('You clicked the button!');
    }
});
});