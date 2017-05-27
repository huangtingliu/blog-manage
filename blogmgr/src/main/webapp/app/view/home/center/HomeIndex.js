/**
 * 首页
 */
Ext.define('BlogMgr.view.home.center.HomeIndex', {
	extend : 'Ext.panel.Panel',
	id : 'homeIndex',
	alias : [ 'widget.home_index' ],
	requires : [ 'BlogMgr.view.home.center.HomeIndexController',
			'BlogMgr.view.home.center.HomeIndexModel',
			'BlogMgr.view.home.center.demo.CkeditorDemo' ],
	uses : [ 'BlogMgr.component.picker.user.UserMultiSelector' ],
	title : '首页',
	controller : 'home_index',
	viewModel : {
		type : 'home_index'
	},
	glyph : 0xe622,
	layout : {
		type : 'vbox',
		pack : 'start',
		align : 'stretch'
	},
	items : [ {
		xtype:'panel',
		margin:10,
		items:[{
			xtype : 'button',
			text : '关闭最后一个tab',
			handler : 'closeLastTab'
		}]
	},{
		xtype : 'panel',
		items : [ {
			xtype : 'button',
			text : 'CKEditor编辑器',
			handler : 'ckEditor'
		} ]
	}, {
		xtype : 'panel',
		margin:10,
		items : {
			fieldLabel : '用户查询器',
			xtype : 'user_multi_selector'
		}
	}, {
		header:false,
		layout : 'form',
		defaultType : 'textfield',
		items : [ {
			fieldLabel : 'result',
			disabled : true,
			bind : '{name}'
		}, {
			fieldLabel : 'First Name',
			bind : {
				value : '{firstName}'
			}
		}, {
			fieldLabel : 'Last Name',
			bind : {
				value : '{lastName}'
			}
		}, {
			xtype : 'button',
			text : 'Submit',
			bind : {
				hidden : '{!name}'
			}
		}, {
			xtype : 'checkbox',
			boxLabel : 'Is Admin',
			reference : 'isAdmin'
		}, {
			xtype : 'textfield',
			fieldLabel : 'Admin Key',
			bind : {
				disabled : '{!isAdmin.checked}'
			}
		} ]
	} ]
});