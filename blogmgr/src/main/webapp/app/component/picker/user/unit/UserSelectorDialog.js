/**
 * 在定义参数时要传一个函数 callback, 作为一个回调函数如
 * 
 * Ext.create('BlogMgr.component.picker.user.unit.UserSelectorDialog', {
			callback:function(selectUsers){
				//操作已经选中的用户
			}
		}).show();
		
 */
Ext.define('BlogMgr.component.picker.user.unit.UserSelectorDialog',{
		alias : [ 'widget.user_selector_dialog' ],
		requires : ['BlogMgr.component.picker.user.unit.UserSelectorDialogController',
		            'BlogMgr.component.picker.user.unit.UserSelectorStore',
		            'Ext.ux.SlidingPager'],
		extend : 'Ext.window.Window',
		layout : 'fit',
		title : '请选择用户',
		maximizable : false, // 最大化
		controller : 'user_selector_dialog',
		// bodyStyle : 'padding : 2px 2px 0',
		shadowOffset : 30, // 投影效果
		modal : true, // 模态
		width : 670,
		height : 400,
		glyph : 0xe614,
		constructor:function(arg){
			if(arg && arg.callback){
				this._callback = arg.callback;
			}
			this.callParent(arguments);
		},
		buttonAlign : 'center',
		buttons : [ {
			itemId : 'save',
			text : '确定',
			glyph : 0xe650,
			handler:'selectorSubmit',
			align : 'center'
		} ],
		items : {
			xtype : 'panel',
			layout : 'border',
			defaults:{
				border:false
			},
			items: [{
			region:'west',
			width:'24%',
			items : {
				xtype:'form',
				defaults : {
					labelWidth : 30,
					width : 150,
					padding:'0px 4px 20px 4px'
				},
				items:[ {
				fieldLabel : '名称',
				name : 'name',
				padding:'15px 4px 20px 4px',
				xtype : 'textfield'
			}, {
				fieldLabel : '账号',
				name : 'account',
				xtype : 'textfield'
			}, {
				fieldLabel : '状态',
				xtype : 'combo',
				store : {
					fields : [ 'value', 'name' ],
					data : [ {
						"value" : "",
						"name" : "请选择"
					}, {
						"value" : "ENABLE",
						"name" : "可用"
					}, {
						"value" : "DISABLE",
						"name" : "不可用"
					} ]
				},
				name : 'status',
				emptyText:'请选择',
				displayField : 'name',
				valueField : 'value',
				editable : false
			}, {
				fieldLabel : '性别',
				xtype : 'combo',
				store : {
					fields : [ 'value', 'name' ],
					data : [ {
						"value" : "",
						"name" : "请选择"
					}, {
						"value" : "MALE",
						"name" : "男"
					}, {
						"value" : "FEMALE",
						"name" : "女"
					} ]
				},
				name : 'gender',
				emptyText:'请选择',
				displayField : 'name',
				valueField : 'value',
				editable : false
			},{
				 xtype: 'segmentedbutton',
                 allowToggle: false,
                 padding:'25px 0px 5px 10px',
                 items: [{
                   text: '查询',
                   handler:'search'
                 }, {
                   text: '重置',
                   handler:'reset'
                 }]
             }
			]}
			},{
		        	region: 'center',
		        	padding:'0 2px 0px 2px',
			        xtype : 'grid',
					store: {
						storeId:'userSelectorStore',
					    type: 'user_selector_store'
					},
					columnLines : true,
					autoLoad : true,
					scrollable : true,
					viewConfig : {
						stripeRows : true, // 奇偶行不同底色
						// enableTextSelection : true,
						plugins: {  
					        ptype: "gridviewdragdrop",  
					        ddGroup: "userList"  // 只有同组的两个grid可能拖拽
					    } 
					},
					rowLines : true,
					columns : [{
							header : 'No',
							xtype : 'rownumberer',
							width : 35
						},{
							header : '名称',
							dataIndex : 'fName',
							sortable:false,
							width : '28%'
						}, {
							header : '账号',
							dataIndex : 'fAccount',
							sortable:false,
							width : '30%'
						},{
							header : '状态',
							dataIndex : 'fStatus',
							align : 'center',
							sortable:false,
							width : '28%',
							renderer : function(val) {
								if (val == 'ENABLE') {
									return '<b style="color:green">可用</b>';
								} else if (val == 'DISABLE') {
									return '<b style="color:red">不可用</b>';
								} else {
									return '未知';
								}
							}
						}],
						dockedItems : [{
							xtype : 'pagingtoolbar',
							store : 'userSelectorStore',
							dock : 'bottom',
							displayInfo : false,
							plugins: Ext.create('Ext.ux.SlidingPager')
						}],
		        },{
		        	region : 'east',
		        	width:'36%',
			        xtype : 'grid',
			        store : [],
					columnLines : true,
					autoLoad : false,
					scrollable : true,
					rowLines : true,
		        	emptyText:'请拖拽左边的记录到此处',
					viewConfig : {
						stripeRows : true, // 奇偶行不同底色
						// enableTextSelection : true,
						deferEmptyText:false,
						 plugins: {  
					        ptype: "gridviewdragdrop",  
					        ddGroup: "userList"  // 只有同组的两个grid可能拖拽
					    } 
					},
					columns : [{
						header : '名称',
						dataIndex : 'fName',
						sortable:false,
						width : '30%'
					}, {
						header : '账号',
						dataIndex : 'fAccount',
						sortable:false,
						width : '30%'
					},{
						header : '状态',
						dataIndex : 'fStatus',
						align : 'center',
						sortable:false,
						width : '30%',
						renderer : function(val) {
							if (val == 'ENABLE') {
								return '<b style="color:green">可用</b>';
							} else if (val == 'DISABLE') {
								return '<b style="color:red">不可用</b>';
							} else {
								return '未知';
							}
						}
				}],
	        }]
		}
	});