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
							stripeRows : false, //奇偶行不同底色
							 plugins: {  
						        ptype: "gridviewdragdrop",  
						        ddGroup: "userFormRoleList"  
						    } 
						},
				        minHeight:362,
				        store:{
							type:'role_list',
							storeId:'userFormFromRoleGridStore'
						},
				        columns : [{
							header : 'No',
							xtype : 'rownumberer',
							width : 37
						},{
				        	header : '可选角色',
				        	dataIndex : 'fName',
				        	flex:1
				        }],
						listeners:{
							rowdblclick:'fromRoleGridDoubleClick'
						}
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
					    autoLoad:false,
					    hideHeaders : true,
						viewConfig : {
							stripeRows : false, // 奇偶行不同底色
							 plugins: {  
						        ptype: "gridviewdragdrop",  
						        ddGroup: "userFormRoleList"  //只有同组的两个grid可能拖拽
						    } 
						},
					    rowLines : true,
					    minHeight:362,
					    store:{
							type:'role_list',
							storeId:'userFormToRoleGridStroe'
//						    filters: [{		//用修改时加载所修改用户的角色
//					            property: 'userId',
//					            operator:'eq',
//					            value:BlogMgr.baseData('userId')
//					        }]
						},
				        columns : [{
							header : 'No',
							xtype : 'rownumberer',
							width : 37
						},{
				        	header : '选定角色',
				        	dataIndex : 'fName',
				        	flex:1
				        }],
				        listeners:{
							rowdblclick:'toRoleGridDoubleClick'
						}
					}]
				}]
			}]
		});