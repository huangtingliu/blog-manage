/**
 * 功能添加viewModel
 */
Ext.define('BlogMgr.view.debug.memo.mgr.SystemMemoAddDialogModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.system_memo_add_dialog',
	data : {
		title : '便签添加',
		saveHandler : 'memoAddSubmit',
		form : {
			fIdEditable : true,
			fParentIdReadOnly : false
		}
	}
});