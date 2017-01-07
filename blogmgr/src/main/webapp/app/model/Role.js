/**
 * 角色模型
 */
Ext.define('BlogMgr.model.Role',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	fields:[
		{name:'fId',type:'string'},
		{name:'fName',type:'string'},
		{name:'fDescr',type:'string'},
		{name:'fCode',type:'int'},
		{name:'fStatus',type:'string'}
	],
	validators: {
	    fId: 'presence',
	    fName: 'presence',
	    fCode: 'presence',
	    fStatus:'presence'
	},
	proxy:{
		type:'ajax',
		url:'/blogmgr/auth/role_get.data'
	}
});