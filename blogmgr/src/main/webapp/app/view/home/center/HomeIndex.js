/**
 * 首页
 */
Ext.define('BlogMgr.view.home.center.HomeIndex', {
	extend : 'Ext.panel.Panel',
	id : 'homeIndex',
	alias : [ 'widget.home_index' ],
	requires : [ 'BlogMgr.view.home.center.HomeIndexController',
			'BlogMgr.view.home.center.HomeIndexModel',
			'BlogMgr.view.home.center.demo.CkeditorDemo',
			'Ux.form.field.RatingField',
			'Ext.ux.rating.Picker'],
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
	items : [{
		xtype:'ratingfield',
		labelWidth : 70,
		fieldLabel : '等级评分器',
		selectedStyle: 'color: rgb(96, 169, 23);',
		overStyle: 'color: rgb(23, 23, 189);',
		limit:15,
		ratingStyle:'margin:-2px;',
		glyphs: '♔♚',
		minimum:2,
		rounding:1,
		value:0,
		tooltip: [
		    '<div style="white-space: nowrap;"><b>',
		        '当前值: {[this.rank[values.value]]}',
		    '</b>',
		    '<tpl if="trackOver && tracking !== value">',
		        '<br><span style="color:#aaa">(点击设置',
		        '{[this.rank[values.tracking]]}',
		        ')</span>',
		    '</tpl></span>',
		    {
		        rank: {
		            1: '开始',
		            2: '试用',
		            3: '需要改进',
		            4: '有贡献价值',
		            5: '非常好',
		            6: '最棒的'
		        }
		    }
		]
	}, {
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
		margin:20,
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