/**
 * 菜单添加对话窗口
 */
Ext.define('BlogMgr.view.menu.MenuMgrDialog',{
			id : 'menuMgrDialog',
			uses:['BlogMgr.view.menu.MenuMgrForm',
				  'Ext.ux.TreePicker',
				  'BlogMgr.view.menu.MenuMgrDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.menumgr_dialog'],
			layout : 'fit',
			bind:{
				title : '{title}'
			},
			maximizable : true, // 最大化
			controller:'menumgr_dialog',
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