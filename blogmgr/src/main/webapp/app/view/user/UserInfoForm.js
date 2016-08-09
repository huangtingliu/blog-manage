/**
 * 用户信息表单
 */
Ext.define('BlogMgr.view.user.UserInfoForm', {
	itemId : 'userInfoForm',
	extend : 'Ext.form.Panel',
	alias : ['widget.user_userinfoform'],
	title : '用户信息',
	url : '/blogmgr/user/add.do',
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
										name:'accountType',
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
										editable : false,
										listeners:{
											change:function(_this,newVal,oldVal){
												var account = _this.nextSibling();
												var mail = _this.up('form').down('textfield[name="fEmail"]');
												var phone = _this.up('form').down('textfield[name="fPhone"]');
												
												if(newVal=='custom'){
													account.disable(false);
													mail.allowBlank = true;
													phone.allowBlank = true;
												}else if(newVal =='mail'){
													mail.allowBlank=false;
													phone.allowBlank = true;
													account.disable(true);
												}else if(newVal =='phone'){
													mail.allowBlank = true;
													phone.allowBlank=false;
													account.disable(true);
												}
											}
										}
									}, {
										fieldLabel : '账号',
										itemId : 'userInfoFormAccount',
										xtype : 'textfield',
										name : 'fAccount',
										maxLength:15,
										minLength:4,
										emptyText:'字母开头,数字下划线组成',
										vtype : 'account',
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
										name : 'fName',
										vtype:'chinese',
										maxLength:10,
										emptyText:'必须是中文'
									}, {
										fieldLabel : '拼音',
										name : 'fPinYin',
										border : false,
										//vtype:'letter',
										value:' ',
										allowBlank : true,
										emptyText:'必须是字母'
									}]
						}, {
							fieldLabel : '密码',
							inputType : 'password',
							name : 'fPassword',
							emptyText:'数字、字符、特殊字符组成',
							maxLength:12,
							minLength:4,
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
											xtype : 'textfield',
											vtype:'mobile'
										}, {
											fieldLabel : '邮箱',
											name : 'fEmail',
											xtype : 'textfield',
											vtype:'email'
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
					maxLength:150,
					anchor : '100%',
					grow : true,
					growMax : 200,
					labelWidth : 70,
					labelAlign : 'right',
					growMin : 100,
					emptyText:'最多150个字',
					name : 'fDescr'
				}]
			}]

});