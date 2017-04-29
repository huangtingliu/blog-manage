/**
 * 系统备忘录树
 */
Ext.define('BlogMgr.model.SystemMenoTree',{
	extend:'Ext.data.TreeModel',
	idProperty:'fId',	//主键标识
	 fields: [
	    {name:'fId',type:'string'},
		{name:'fParentId',type:'string'},
		//{name:'fHierarchy',type:'string'},
		{name:'fOrder',type:'int'},
		{name:'fTitle',type:'string'},
		{name:'fDescr',type:'string'},
		{name:'fUrl',type:'string'},
    ]
});