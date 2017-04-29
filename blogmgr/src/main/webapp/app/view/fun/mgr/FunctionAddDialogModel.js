/**
 * 功能添加viewModel
 */
Ext.define('BlogMgr.view.fun.mgr.FunctionAddDialogModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.function_add_dialog',
	data : {
		title : '功能添加',
		saveHandler : 'functionAddSubmit',
		form : {
			fIdEditable : true,
			fParentIdReadOnly : false
		}
	}
});