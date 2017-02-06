/**
 * 系统功能添加对话窗口
 */
Ext.define('BlogMgr.view.fun.mgr.FunctionMgrDialog',{
			id : 'functionMgrDialog',
			uses:['Ext.ux.TreePicker',
				  'BlogMgr.view.fun.mgr.FunctionMgrForm',
				  'BlogMgr.view.fun.mgr.FunctionEditDialogModel',
				  'BlogMgr.view.fun.mgr.FunctionAddDialogModel',
				  'BlogMgr.view.fun.mgr.FunctionMgrDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.functionmgr_dialog'],
			controller:'functionmgr_dialog',
			viewModel : {
				type : 'function_add_dialog'
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
						xtype : 'functionmgr_form'
					}
});