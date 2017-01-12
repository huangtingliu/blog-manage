/**
 * 角色添加对话窗口
 */
Ext.define('BlogMgr.view.auth.role.RoleAddDialog', {
			id : 'roleAddDialog',
			uses:['BlogMgr.view.auth.role.RoleAddDialogController'],
			extend : 'Ext.window.Window',
			alias : ['widget.roleadd'],
			layout : 'fit',
			title : '角色添加',
			maximizable : true, // 最大化按钮
			controller:'roleadd',
			bodyStyle : 'padding : 5px 5px 0',
			shadowOffset : 30, // 投影效果
			modal : true, // 模态
			width : 600,
			glyph : 0xe6cb,
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
				glyph : 0xe650,
				handler:'roleAddSubmit'
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xe6af,
				handler:'closeDialog'
			}],
			items : {
				xtype:'form',
				itemId : 'roleAddForm',
				url : '/blogmgr/role/add.do',
				method : 'POST',
				layout : 'anchor',
				waitTitle:'处理中...',
				fileUpload: false,
				defaults:{
					labelAlign : 'right',
					labelWidth : 80,
				},
				items : [{
					fieldLabel : '角色名称',
					name:'fName',
					xtype : 'textfield',
					emptyText:'输入英文',
					anchor:'80%',
					value:'ROLE_'
				},{
					fieldLabel : '描述',
					xtype : 'textarea',
					maxLength:200,
					anchor : '90%',
					grow : true,   //是否自动增长
					growMax : 200,  //最大长度200px
					growMin : 150,  //输入框最小高度为150px
					emptyText:'最多200个字',
					name : 'fDescr'
				}]
			}
		});