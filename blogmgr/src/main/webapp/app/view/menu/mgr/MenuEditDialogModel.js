/**
 * 菜单修改viewModel
 */
Ext.define('BlogMgr.view.menu.mgr.MenuEditDialogModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.menu_edit_dialog',
			data:{
				title:'菜单修改',
				saveHandler:'userEditSubmit',
				form:{
					fIdEditable:false,
					fParentIdReadOnly:true
				}
			}
		})