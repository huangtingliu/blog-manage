Ext.define('BlogMgr.view.debug.memo.mgr.SystemMemoMgrForm', {
	itemId : 'systemMemoMgrForm',
	extend : 'Ext.form.Panel',
	alias : [ 'widget.system_memo_mgr_form' ],
	waitTitle : '处理中...',
	fileUpload : false,
	defaults : {
		layout : 'anchor',
		collapsible : false,
		anchor : '90%',
		labelAlign : 'right',
		labelWidth : 100
	},
	items : [ {
		fieldLabel : '标题',
		name : 'fTitle',
		xtype : 'textfield',
		emptyText : '必须是中文',
		maxLength : 10,
		minLength : 2
	}, {
		fieldLabel : '链接',
		name : 'fUrl',
		xtype : 'textfield'
	}, {
		fieldLabel : '排序',
		name : 'fOrder',
		xtype : 'numberfield',
		value : 0,
		minValue : 0,
		maxValue : 100,
		allowDecimals : false,
		emptyText : '0 - 100'
	}, {
		fieldLabel : '详情',
		name : 'fDescr',
		xtype : 'htmleditor',
		enableSourceEdit : false,
		enableLists : false,
		enableFontSize : false,
		enableFont : false
	} ]
});