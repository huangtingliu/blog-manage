Ext.define('BlogMgr.view.debug.developplan.crud.EditDevelopPlanFormModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.edit_develop_plan_form',
	data : {
		title : '修改开发计划',
		saveHandler : 'editPlanSubmit',
		handlerText:'修改'
//		form : {
//			fIdEditable : true,
//			fParentIdReadOnly : false
//		}
	}
});