Ext.define('BlogMgr.view.home.center.demo.CkeditorDemo', {
	alias : [ 'widget.ckeditor_demo' ],
	extend : 'Ext.window.Window',
	layout : 'fit',
	title : 'ckEditor示例',
	maximizable : false, // 最大化
	shadowOffset : 30, // 投影效果
	modal : true, // 模态
	width : 600,
	height : 450,
	glyph : 0xe614,
	items:{ 
	   xtype:'form',
	   layout:'anchor',  
		 defaults:{  
	     margin:'10 10 10 10',  
	     anchor:'100%'  
	 },  
	   items:[{
		   xtype: 'textfield',  
	       name: 'title',  
	       fieldLabel: '标题',  
	       labelAlign: 'right',  
	       anchor:'90%',  
	       labelWidth: 100  
	   },{
		   xtype:'panel',
		   border:false,
		   height:350,  
	       widht:550,  
		   html:'<div id="newsckeditor" name="newsckeditor"></div>',
	   }]
	},
	buttons: [{  
        text: '保存',  
        name: 'newsSubmitBtn',  
    }],
    listeners:{
    	render:function(){
    	CKEDITOR.appendTo('newsckeditor');
//		      CKEDITOR.replace('newsckeditor',{  
//			height: 280,  
//			width:550,  
//			//如果选择字体样式等的弹出窗口被当前window挡住，就设置这个为一个较大的值  
//			baseFloatZIndex: 99999,  
//			//图片和flash都上传到这里  
//			// filebrowserUploadUrl: '/news/upload'  
//			});  
    	}
	}
});