首页。。。
<div id="btn1"></div>
<script type="text/javascript" >
alert();
console.info("index");

Ext.application({
	launch:function(){
		console.info("index");
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
</script>  

