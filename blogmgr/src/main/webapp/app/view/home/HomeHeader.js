/***
 * 首页头部
 */
Ext.define('BlogMgr.view.home.HomeHeader',{
	uses:['BlogMgr.view.home.HomeHeaderController','BlogMgr.view.home.HomeHeaderModel'],
	id:'home_header',
	extend : 'Ext.panel.Panel',
	alias : 'widget.home_header',
	controller : 'home_header',
	viewModel:'home_header',
	height : 50,
	defaults : {
		baseCls:'appBanner',
		bodyPadding : '5'
	},
	baseCls:'appBanner',
	layout:'column',
	 items: [
	         {
	        	 columnWidth:0.1 ,
	        	 maxWidth:30,
	             html: '&nbsp;'
	         },{
	        	 columnWidth:0.9 ,
	        	 bodyPadding : '15 0 5 5',
	             html: 'Blog Manager System(v0.0.1)'
	         },
	         {
	        	 width:150,
	        	 padding:'5 0 0 0',
	        	 bind:{
	        	 	html:'用户：{userName} <br> 时间：{currentDate}'
	         	}
	         },{
	        	 maxWidth: 1,
	        	 bodyPadding : '5 0 5 50%',
	             items:[{
	            	 	text : '退出',
						xtype : 'transparent_button',
						height:40,
						width:70,
						handler:'logout',
						glyph : 0xe6c3
	             }]
	         }
	     ]
});