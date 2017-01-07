/**
 * 权限配置首页
 */
Ext.define('BlogMgr.view.auth.AuthHome',{
	id:'authHome',
	uses:['BlogMgr.view.auth.role.RoleGrid','BlogMgr.view.auth.module.ModuleGrid',
	      'BlogMgr.view.auth.AuthHomeToolBar','BlogMgr.view.auth.AuthHomeController'],
	extend : 'Ext.panel.Panel',
	alias:'widget.authhome',
	controller:'authhome',
	layout : 'border',
	height:'100%',
	defaults:{
		layout : 'fit'
	},
	items:[
	     {
	    	 region : 'north',
	    	 bodyBorder:true,
		     tbar : {
		 		xtype : 'authhome_toolbar'
		 	}
	     } ,{
	    	 region : 'west',
	    	 width : '22%',
	    	 minWidth:300,
	    	 split : true,
	    	xtype:'auth_rolegrid'
	     },{
	    	 region : 'center',
	    	 xtype:'auth_modulegrid'
	     }     
	]
});