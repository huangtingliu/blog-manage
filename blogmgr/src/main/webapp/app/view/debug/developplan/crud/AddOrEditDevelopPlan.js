Ext.define('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlan', {
			//id : 'AddOrEditDevelopPlan',
			uses:['Ux.form.field.CKEditor',
			      'Ext.ux.rating.Picker'],
			extend : 'Ext.form.Panel',
			//alias : ['widget.add_or_edit_develop_plan'],
			//layout : 'fit',
			itemId:'developPlanForm',
			url : '/blogmgr/user/add.do',
			method : 'POST',
			waitTitle:'处理中...',
			buttonAlign:'center',
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
						width : '25%'
					},
					items : [{
						fieldLabel : '计划名称',
						xtype:'textfield',
						name:'accountType'
					},{
						fieldLabel : '计划名称',
						xtype:'textfield',
						name:'accountType'
					},{
						fieldLabel : '任务级别',
						xtype:'rating',
						selectedStyle: 'color: rgb(96, 169, 23);',
	                    overStyle: 'color: rgb(23, 23, 189);',
						name:'accountType'
					}]
				},{
					xtype: 'ckeditor', 
		            fieldLabel: '描述', 
		            name: 'content', 
		            height:200,
		            anchor: '100%',
					CKConfig:{
				     	filebrowserUploadUrl:'/blogmgr/ckeditor/upload.do'
				   }
				}]
			},{
				title : '可添信息',
				xtype : 'fieldset',
				defaults : {
					labelAlign : 'right',
					labelWidth : 70,
					allowBlank : false
				},
				items : [{
					fieldLabel : '完成日期',
					name:'accountType',
					xtype:'datefield'
				},{
					fieldLabel : '附件',
					xtype:'filefield'
				}]
			}],
			buttons : [{
				itemId : 'save',
				text : '保存',
				glyph : 0xe650,
				handler:'userMgrDialogSubmit'
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xe6af,
				handler:'closeDialog'
			}]
		})