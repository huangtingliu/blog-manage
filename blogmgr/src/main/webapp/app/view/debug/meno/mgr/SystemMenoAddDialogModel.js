/**
 * 功能添加viewModel
 */
Ext.define('BlogMgr.view.debug.meno.mgr.SystemMenoAddDialogModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.system_meno_add_dialog',
	data : {
		title : '便签添加',
		saveHandler : 'menoAddSubmit',
		form : {
			fIdEditable : true,
			fParentIdReadOnly : false
		}
	}
});