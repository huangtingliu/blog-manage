/**
 * 系统功能
 */
Ext.define('BlogMgr.model.Function',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	 fields: [
	    {name: 'fId', type: 'string'},
        {name: 'fName',  type: 'string'},
        {name: 'fParentId',   type: 'string'},
        {name: 'fHandler', type: 'string'},
        {name: 'fRelevance', type: 'string'},
        {name: 'fIcon', type: 'string'},
        {name: 'fGlyph', type: 'int'},
        {name: 'fOrder', type: 'int'},
        {name: 'fType', type: 'string'},
        {name: 'fUsability', type: 'string'},
        {name: 'fDescr', type: 'string'}
        
    ],
    validators: {
        fId: 'presence',
        fName: 'presence'
    },
    proxy:{
    	type:'ajax',
    	url:'/blogmgr/function/get.data'
    }
});