/**
 * 系统备忘录
 */
Ext.define('BlogMgr.model.debug.SystemMemo',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//当前用户的主键标识
	fields:[
		{name:'fId',type:'string'},
		{name:'fParentId',type:'string'},
		//{name:'fHierarchy',type:'string'},
		{name:'fOrder',type:'int'},
		{name:'fTitle',type:'string'},
		{name:'fDescr',type:'string'},
		{name:'fUrl',type:'string'},
	],
	validators: {
		fId: 'presence',
		fTitle: 'presence'
	},
	proxy:{
		type:'ajax',
		url:'/blogmgr/debug/memo/get.data'
	}
});