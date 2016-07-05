/**
 * 后台用户
 */
Ext.define('BlogMgr.model.MgrUser',{
	extend:'Ext.data.Model',
	fields:[
		{name:'fId',type:'string'},
		{name:'fName',type:'string'},
		{name:'fAccount',type:'string'},
		{name:'statusName',type:'string'},
		{name:'createrName',type:'string'},
		{name:'createDate',type:'string'}
	],
	validators: {
        fId: 'presence',
        fAccount: 'presence',
        fName: 'presence'
    }
    
})

