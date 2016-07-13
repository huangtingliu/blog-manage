/**
 * 数据字典
 */
Ext.define('BlogMgr.model.Dictionary',{
	extend:'Ext.data.Model',
	idProperty:'fId',
	fields:[
		{name:'fId',type:'string'},
		{name:'fName',type:'string'}
		
	],
	validators: {
        fId: 'presence',
        fName: 'presence'
    }
    
})
