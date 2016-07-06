Ext.define('BlogMgr.view.mgruser.UserAddDialog', {
			extend : 'Ext.window.Window',
			alias : ['widget.mgruseradd'],
			layout : 'fit',
			title : '用户添加',
			maximizable : true, // 最大化
			bodyStyle : 'padding : 2px 2px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 600,
			height : 500,
			glyph : 0xf234,
			initComponent : function() {
				this.callParent(arguments);
			},
			tools : [{
						type : 'help',
						tooltip : '帮助'
					}],
			buttons : [{
						itemId : 'save',
						text : '保存',
						glyph : 0xf0c7
					}, {
						itemId : 'close',
						text : '关闭',
						glyph : 0xf00d
					}],
			items : [{
						xtype : 'tabpanel',
						frame : false,
						border : false,
						bodyPadding : '5 5 5 5',
						plain : true,
						items : [{
									title : '用户信息',
									items : [{
												title : '必填信息',
												xtype : 'fieldset',
												defaultType : 'textfield',
												layout : 'anchor',
												collapsible : false,
												defaults : {
													anchor : '100%'
												},
												items : [{
															fieldLabel : '账号',
															labelAlign :'right',
															labelWidth :50,
															name : 'account'
														}, {
															fieldLabel : '密码',
															labelAlign :'right',
															labelWidth :50,
															inputType: 'password',  
															name : 'pwd'
														}]
											}, {
												title : '附加信息',
												xtype : 'fieldset',
												defaultType : 'textfield',
												layout : 'anchor',
												collapsible : false,
												defaults : {
													anchor : '100%'
												},
												items : [{
															fieldLabel : '呢称',
															labelAlign :'right',
															labelWidth :50,
															name : 'name'
														}, {
															fieldLabel : '备注',
															labelAlign :'right',
															labelWidth :50,
															xtype:'textarea',
															 grow      : true,
															 growMax:200,
															 growMin :100,
															name : 'descr'
														}]
											}]

								}, {
									title : '权限分配',
									items : []
								}]
					}]
		});