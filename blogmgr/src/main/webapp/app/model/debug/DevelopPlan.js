/**
 * 开发任务计划
 */
Ext.define('BlogMgr.model.debug.DevelopPlan',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//当前用户的主键标识
	fields:[
		{name:'fId',type:'string'},
		{name:'fName',type:'string'},
		{name:'fPriority',type:'int'},
		{name:'fDescr',type:'string'},
		{name:'fFinishDate',type:'date'},
		{name:'fCreateUser',type:'string'},
		{name:'fCreateDate',type:'date'},
		{name:'fProgress',type:'int'},
		{name:'fPlanStauts',type:'string'},
		{name:'fEstimatedDate',type:'date'},  //预计时间
		{name:'fPlanTerminator',type:'string'},
		{name:'planTerminatorName',type:'string'},
		{name:'createUserName',type:'string'}
	],
	validators: {
		fId: 'presence',
		fPriority: {type:'range',min:1,max:5},
		fName: 'presence',
		fPlanStauts: {type:'inclusion',list:['ENABLE','DISABLE','DELETE']},
	},
	proxy:{
		type:'ajax',
		url:'/blogmgr/debug/developplan/get.data'
	}
});