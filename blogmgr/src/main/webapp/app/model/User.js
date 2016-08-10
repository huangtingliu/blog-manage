/**
 * 后台用户
 */
Ext.define('BlogMgr.model.User',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	fields:[
		{name:'fId',type:'string'},
		{name:'fName',type:'string'},
		{name:'fAccount',type:'string'},
		{name:'fGender',type:'string'},
		{name:'fStatus',type:'string'},
		{name:'fPhone',type:'string'},
		{name:'fEmail',type:'string'},
		{name:'fCreater',type:'string'},
		{name:'fCreateDate',type:'date',convert:function(val){
			return Ext.Date.format(new Date(val),'Y-m-d H:i:s');
		}}
	],
	validators: {
        fId: 'presence',
        fAccount: 'presence',
        fName: 'presence',
        fStatus:'presence'
    }
})


