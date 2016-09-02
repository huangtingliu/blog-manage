/**
 * 菜单添加对话窗口
 */
Ext.define('BlogMgr.view.menu.mgr.MenuMgrDialog',{
			id : 'menuMgrDialog',
			uses:['Ext.ux.TreePicker',
				  'BlogMgr.view.menu.mgr.MenuMgrForm',
				  'BlogMgr.view.menu.mgr.MenuEditDialogModel',
				  'BlogMgr.view.menu.mgr.MenuAddDialogModel',
				  'BlogMgr.view.menu.mgr.MenuMgrDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.menumgr_dialog'],
			controller:'menumgr_dialog',
			viewModel : {
				type : 'menu_add_dialog'
			},
			layout : 'fit',
			bind:{
				title : '{title}'
			},
			maximizable : true, // 最大化
			bodyStyle : 'padding : 2px 2px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 450,
			glyph : 0xe6cb,
			tools : [{
						type : 'help',
						tooltip : '帮助'
					}],
			buttons : [{
				itemId : 'save',
				text : '保存',
				glyph : 0xe650,
				bind:{
					handler:'{saveHandler}'
				}
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xe6af,
				handler:'closeDialog'
			}],
			items : {
						xtype : 'menumgr_form'
					}
});