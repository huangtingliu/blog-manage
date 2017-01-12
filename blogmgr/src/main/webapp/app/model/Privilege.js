/**
 * 权限对象
 */
Ext.define('BlogMgr.model.Privilege',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	 fields: [
	    {name: 'fId', type: 'string'},
	    {name: 'fPriority', type: 'string'},
	    {name: 'fFunId', type: 'string'},
	    {name: 'fRoleId', type: 'string'},
	    {name: 'fType', type: 'string'},
	    {name: 'descr', type: 'string'},
	    {name: 'funName', type: 'string'}
    ],
    validators: {
    	fPriority: 'presence',
	    fRoleId: 'presence',
	    fFunId: 'presence',
	    fType: 'presence',
	    funName: 'presence',
        fId: 'presence'
    },
    proxy:{
    	type:'ajax',
    	url:'/blogmgr/privilege/get.data'
    }
});