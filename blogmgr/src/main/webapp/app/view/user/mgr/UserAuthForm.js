/**
 * 后台用户权限表单 TODO
 */
Ext.define('BlogMgr.view.user.mgr.UserAuthForm', {
			itemId : 'userAuthForm',
			extend : 'Ext.form.Panel',
			requires: [
			    'Ext.view.MultiSelector'
			],
			alias : ['widget.user_userauthform'],
			title : '权限分配',
			items : [{
				xtype : 'fieldcontainer',
				layout:'column',
				items:[{
					 columnWidth: 0.5,
					 xtype : 'fieldset',
					 title : '可选角色',
					 padding:'13 13 13 13',
					 items:[{
						xtype : 'grid',
				        autoLoad:true,
				        hideHeaders : true,
				        rowLines : true,
				        viewConfig : {
							stripeRows : false //奇偶行不同底色
						},
				        minHeight:362,
				        store:{
							type:'role_list',
					        filters: [{
					            property: 'userId',
					            operator:'ne',
					            value:BlogMgr.baseData('userId')
					        }]
						},
				        columns : [{
				        	header : '可选角色',
				        	dataIndex : 'fName',
				        	width:'100%'
				        }]
					 }]
				},{
					width: 20,
					html:'&nbsp;'
				},{
					columnWidth: 0.5,
					xtype : 'fieldset',
					title : '选定角色',
					padding:'13 13 13 13',
					items:[{
						xtype : 'grid',
					    autoLoad:true,
					    hideHeaders : true,
						viewConfig : {
							stripeRows : false // 奇偶行不同底色
						},
					    rowLines : true,
					    minHeight:362,
					    store:{
							type:'role_list',
						    filters: [{
					            property: 'userId',
					            operator:'eq',
					            value:BlogMgr.baseData('userId')
					        }]
						},
				        columns : [{
				        	header : '选定角色',
				        	dataIndex : 'fName',
				        	width:'100%'
				        }]
					}]
				}]
			}]
		});