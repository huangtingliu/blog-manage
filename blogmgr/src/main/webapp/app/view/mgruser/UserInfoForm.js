/**
 * 用户信息表单
 */
Ext.define('BlogMgr.view.mgruser.UserInfoForm', {
	itemId : 'userInfoForm',
	extend : 'Ext.form.Panel',
	alias : ['widget.mgruser_userinfoform'],
	title : '用户信息',
	url : '/blogmgr/mgruser/add.do',
	method : 'POST',
	waitTitle:'处理中...',
	fileUpload: false,
	defaults : {
		layout : 'anchor',
		collapsible : false,
		defaultType : 'textfield'
	},
	items : [{
				title : '必填信息',
				xtype : 'fieldset',
				defaults : {
					labelAlign : 'right',
					labelWidth : 70,
					allowBlank : false
				},
				items : [{
							xtype : 'fieldcontainer',
							layout : 'hbox',
							defaults : {
								labelAlign : 'right',
								labelWidth : 70,
								width : '50%'
							},
							items : [{
										fieldLabel : '账号类型',
										xtype : 'combo',
										store : {
											fields : ['value', 'name'],
											data : [{
														"value" : "phone",
														"name" : "电话"
													}, {
														"value" : "mail",
														"name" : "邮箱"
													}, {
														"value" : "custom",
														"name" : "自定义"
													}]
										},
										displayField : 'name',
										valueField : 'value',
										value : 'custom',
										editable : false
									}, {
										fieldLabel : '账号',
										xtype : 'textfield',
										name : 'fAccount',
										allowBlank : false
									}]
						}, {
							xtype : 'fieldcontainer',
							layout : 'hbox',
							defaults : {
								width : '50%',
								labelAlign : 'right',
								labelWidth : 70,
								xtype : 'textfield',
								allowBlank : false
							},
							items : [{
										fieldLabel : '名称',
										name : 'fName'
									}, {
										fieldLabel : '拼音',
										name : 'fPinYin',
										border : false
									}]
						}, {
							fieldLabel : '密码',
							inputType : 'password',
							name : 'fPassword',
							anchor : '50%'
						}, {
							fieldLabel : '状态',
							xtype : 'combo',
							store : {
								fields : ['value', 'name'],
								data : [{
											"value" : "ENABLE",
											"name" : "可用"
										}, {
											"value" : "DISABLE",
											"name" : "不可用"
										}]
							},
							name : 'fStatus',
							displayField : 'name',
							valueField : 'value',
							anchor : '50%',
							value : 'ENABLE',
							editable : false

						}]
			}, {
				title : '附加信息',
				xtype : 'fieldset',
				items : [{
					xtype : 'fieldcontainer',
					layout : 'column',
					items : [{
								xtype : 'panel',
								columnWidth : 0.67,
								layout : 'anchor',
								defaults : {
									labelAlign : 'right',
									labelWidth : 70,
									anchor : '100%'
								},
								items : [{
											fieldLabel : '头像',
											xtype : 'filefield',
											name : 'fAvatar',
											labelWidth : 70,
											buttonText : '选择',
											isFileUpload:function(){
												return false;
											}
										}, {
											xtype : 'fieldcontainer',
											fieldLabel : '性别',
											defaultType : 'radiofield',
											anchor : '90%',
											defaults : {
												flex : 1
											},
											layout : 'hbox',
											items : [{
														boxLabel : '男',
														name : 'fGender',
														inputValue : 'MALE',
														checked:true
													}, {
														boxLabel : '女',
														name : 'fGender',
														inputValue : 'FEMALE'
													}, {
														boxLabel : '未知',
														name : 'fGender',
														inputValue : 'UNKNOW'
													}]
										}, {
											fieldLabel : '电话',
											name : 'fPhone',
											xtype : 'textfield'
										}, {
											fieldLabel : '邮箱',
											name : 'fEmail',
											xtype : 'textfield'
										}]
							}, {
								xtype : 'panel',
								layout : {
									type :'vbox',
									align:'center'
								},
								columnWidth : 0.33,
								height:110,
								items : [/*{
									xtype : 'image',
									padding : '0 10 5 10',
									width:165,
									src : 'http://www.sencha.com/img/20110215-feat-html5.png',
									flex:1
								},*/{
									xtype:'button',
									text: '上传图片'
								}]
							}]
				}, {
					fieldLabel : '备注',
					xtype : 'textarea',
					anchor : '100%',
					grow : true,
					growMax : 200,
					labelWidth : 70,
					labelAlign : 'right',
					growMin : 100,
					name : 'fDescr'
				}]
			}]

});