/**
 * 菜单添加viewModel
 */
Ext.define('BlogMgr.view.menu.mgr.MenuAddDialogModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.menu_add_dialog',
			data:{
				title:'菜单添加',
				saveHandler:'userAddSubmit',
				form:{
					fIdEditable:true,
					fParentIdReadOnly:false
				}
			}
		})