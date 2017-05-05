/**
 * 便签添加修改viewModel
 */
Ext.define('BlogMgr.view.debug.memo.mgr.SystemMemoEditDialogModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.system_memo_edit_dialog',
	data : {
		title : '便签修改',
		saveHandler : 'memoEditSubmit',
	}
});