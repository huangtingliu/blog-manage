/**
 * 登录表单
 */
Ext.define('BlogMgr.view.login.LoginForm', {
			itemId : 'loginForm',
			extend : 'Ext.form.Panel',
			alias : ['widget.login_form'],
			waitTitle : '登录中...',
			url:'/blogmgr/login.do',
			method:'POST',
			fileUpload : false,
			padding:'250px 0 0 0',
			defaults : {
				xtype: 'textfield',
				labelAlign : 'right',
				labelWidth : 50,
				padding:6,
				allowBlank : false
			},
			items:[{
     			 fieldLabel : '用户名',
     			 name:'account',
     			 enableKeyEvents:true,
				 listeners:{
					keydown:'enterDown'
				 },
			},{
				fieldLabel : '密码',
				inputType : 'password',
				name:'password',
				enableKeyEvents:true,
				listeners:{
					keydown:'enterDown'
				},
			},{
				xtype : 'panel',
				align:'center',
				layout : {
					layout:'hbox',	
					align: 'stretch'
				},
				defaults:{
					 //flex: 1,
					width : 70
				},
				items:[{
					xtype:'button',
					text:'登录',
					margin:'1 30 1 20',
					handler:'login'
				},{
					xtype:'button',
					text:'注册',
					margin:'1 1 1 30',
					handler:'signup'
				}]
			}]
		});