/**
 * 添加后台用户对话窗口
 */
Ext.define('BlogMgr.view.debug.meno.mgr.SystemMenoMgrDialog', {
	id : 'systemMenoMgrDialog',
	alias : [ 'widget.system_meno_dialog' ],
	requires : [ 'BlogMgr.view.debug.meno.mgr.SystemMenoAddDialogModel',
			'BlogMgr.view.debug.meno.mgr.SystemMenoMgrForm',
			'BlogMgr.view.debug.meno.mgr.SystemMenoMgrDialogController' ],
	extend : 'Ext.window.Window',
	layout : 'fit',
	viewModel : {
		type : 'system_meno_add_dialog'
	},
	bind : {
		title : '{title}'
	},
	maximizable : true, // 最大化
	controller : 'system_meno_dialog',
	bodyStyle : 'padding : 2px 2px 0',
	shadowOffset : 30, // 投影效果
	modal : true, // 模态
	width : 600,
	// height : 500,
	glyph : 0xe614,
	initComponent : function() {
		this.callParent(arguments);
	},
	tools : [ {
		type : 'help',
		bind : {
			tooltip : '{toolTip}'
		}
	} ],
	buttons : [ {
		itemId : 'save',
		text : '保存',
		glyph : 0xe650,
		bind : {
			handler : '{saveHandler}'
		}
	}, {
		itemId : 'close',
		text : '关闭',
		glyph : 0xe6af,
		handler : 'closeDialog'
	} ],
	items :  {
		xtype : 'system_meno_mgr_form'
	} 
});