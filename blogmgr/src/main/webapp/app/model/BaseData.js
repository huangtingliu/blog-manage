/**
 * 系统基础数据
 */
Ext.define('BlogMgr.model.BaseData',{
	extend:'Ext.data.Model',
	idProperty:'userId',	//当前用户的主键标识
	fields:[
	    //当前用户数据
		{name:'userId',type:'string'},
		{name:'userName',type:'string'},
		{name:'userAccount',type:'string'},
		{name:'userStatus',type:'string'},
		{name:'userPhone',type:'string'},
		{name:'userEmail',type:'string'},
		{name:'userRole',type:'string'},
		//服务器数据
		{name:'serversDate',type:'date'}	
	],
	validators: {
		userId: 'presence',
		userAccount: 'presence',
		userName: 'presence',
		userStatus:'presence'
	},
	proxy:{
		type:'ajax',
		url:'/blogmgr/home/baseData.data'
	}
});