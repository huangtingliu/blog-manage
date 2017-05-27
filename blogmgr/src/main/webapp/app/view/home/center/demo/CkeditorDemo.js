Ext.define('BlogMgr.view.home.center.demo.CkeditorDemo', {
	alias : [ 'widget.ckeditor_demo' ],
	uses:['Ux.form.field.CKEditor'],
	extend : 'Ext.window.Window',
	layout : 'fit',
	title : 'ckEditor示例',
	maximizable : false, // 最大化
	shadowOffset : 30, // 投影效果
	modal : true, // 模态
	width : 650,
	height : 550,
	glyph : 0xe614,
	items:{ 
	   xtype:'form',
	   layout:'anchor',  
	   itemId : 'ckeditorDemoForm',
	   url : '/blogmgr/debug/test/send.do',
	   method : 'POST',
	   defaults:{  
	     margin:'10 10 10 10',  
	 	},  
	   items:[{
		   xtype: 'textfield',  
	       name: 'title',  
	       fieldLabel: '标题',  
	       anchor:'90% 13%', 
	       labelAlign: 'right',  
	       labelWidth: 100  
	   },{
	   		xtype: 'ckeditor', 
            fieldLabel: '内容', 
            labelAlign: 'right',
            name: 'content', 
            height:300,
            anchor: '90% 85%',
            id:'newsckeditor'
	   }]
	},
	buttons: [{  
        text: '保存',  
        name: 'newsSubmitBtn',  
        handler:function(){
			var form = this.ownerCt.ownerCt.getComponent("ckeditorDemoForm"); 
			form.submit({
				success : function(form, action) {},
				failure : function(form, action) {},
				waitMsg:' '
			});
		}
    }],
    listeners:{
		resize:function(){
    		//当窗口的大小调整时，可以通知ckeditor来调整高度
    		//console.info("window resize ........");
    	}
    
	}
});