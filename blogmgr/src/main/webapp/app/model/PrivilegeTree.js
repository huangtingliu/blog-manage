/**
 * 权限树对象
 */
Ext.define('BlogMgr.model.PrivilegeTree',{
	extend:'Ext.data.TreeModel',
	idProperty:'fFunId',	//主键标识
	 fields: [
	    {name: 'fFunId', type: 'string'},
	    {name: 'funName', type: 'string'},
	    {name: 'fPriority', type: 'string'},
	    {name: 'fType', type: 'string'},
	    {name: 'funDescr', type: 'string'},
	    {name: 'funParentId', type: 'string'}
    ]
});