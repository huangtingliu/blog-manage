/**
 * 首页
 */
Ext.define('BlogMgr.view.home.center.HomeIndex',{
	extend : 'Ext.panel.Panel',
	id : 'homeIndex',
	alias : ['widget.home_index'],
	requires:['BlogMgr.view.home.center.HomeIndexController','BlogMgr.view.home.center.HomeIndexModel'],
	uses:['BlogMgr.component.picker.user.UserMultiSelector'],
	title : '首页',
	controller : 'home_index',
	viewModel : {
		type : 'home_index'
	},
	glyph : 0xe622,
    layout: {
	    type: 'vbox',
	    pack: 'start',
	    align: 'stretch'
    },
    items: [{
        title: 'mvvm案例',
        glyph : 0xe625,
        layout: 'form',
        defaultType: 'textfield', 
        items: [{
			 fieldLabel: 'result',
			 disabled:true,
			 bind:'{name}'
		},{  
		    fieldLabel: 'First Name',  
		    bind:{
				value:'{firstName}'
			}
		},{  
		    fieldLabel: 'Last Name', 
			 bind:{
				value:'{lastName}'
			}
		},{  
		    xtype: 'button',  
		    text: 'Submit',  
		    bind: {  
		        hidden: '{!name}'  
		    }  
		},{  
		    xtype: 'checkbox',  
		    boxLabel: 'Is Admin',  
		    reference: 'isAdmin'  
		},{  
		    xtype: 'textfield',  
		    fieldLabel: 'Admin Key',  
		    bind: {  
		        disabled: '{!isAdmin.checked}'  
		    }  
		}]  
    },{
        title: 'Panel 2',
        height: 100,
        margin: '0 0 10 0',
        html: 'height: 100'
    },{
    	 xtype: 'userselector'
    }]
});