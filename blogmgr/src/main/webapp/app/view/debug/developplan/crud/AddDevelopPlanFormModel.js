Ext.define('BlogMgr.view.debug.developplan.crud.AddDevelopPlanFormModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.add_develop_plan_form',
	data : {
		title : '添加开发计划',
		saveHandler : 'addPlanSubmit',
		handlerText:'保存'
//		form : {
//			fIdEditable : true,
//			fParentIdReadOnly : false
//		}
	}
});