/**
 * 系统功能修改viewModel
 */
Ext.define('BlogMgr.view.fun.mgr.FunctionEditDialogModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.function_edit_dialog',
			data:{
				title:'功能修改',
				saveHandler:'functionEditSubmit',
				form:{
					fIdEditable:false,
					fParentIdReadOnly:true
				}
			}
		})