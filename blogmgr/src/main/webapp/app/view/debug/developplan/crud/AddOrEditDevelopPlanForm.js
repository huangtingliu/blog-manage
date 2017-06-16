Ext.define('BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanForm', {
			//id : 'AddOrEditDevelopPlan',
			uses:['Ux.form.field.CKEditor',
			      'BlogMgr.view.debug.developplan.crud.AddOrEditDevelopPlanFormController',
			      'BlogMgr.view.debug.developplan.crud.EditDevelopPlanFormModel',
			      'BlogMgr.view.debug.developplan.crud.AddDevelopPlanFormModel',
			      'Ext.ux.rating.Picker'],
			extend : 'Ext.form.Panel',
			alias : ['widget.add_or_edit_develop_plan_form'],
			//layout : 'fit',
			controller:'add_or_edit_develop_plan_form',
			//viewModel:'add_develop_plan_form', //根据状态来选择视图模型,add 或eidt
			itemId:'developPlanForm',
			fileUpload : false,
			url : '/blogmgr/debug/developplan/add.do',
			method : 'POST',
			waitTitle:'处理中...',
			buttonAlign:'center',
			defaults : {
				layout : 'anchor',
				collapsible : false,
				defaultType : 'textfield'
			},
			items : [{
				//title : '必填信息',
				xtype : 'fieldset',
				border:false,
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
						width : '30%',
						padding:'10px 40px 10px 0px'
					},
					items : [{
						fieldLabel : '计划名称',
						xtype:'textfield',
						name:'fName'
					},{
						fieldLabel : '承接人',
						xtype:'user_multi_selector',
						name:'fAccptor'
					},{
						fieldLabel : '任务级别',
						xtype:'ratingfield',
						selectedStyle: 'color: rgb(96, 169, 23);',
	                    overStyle: 'color: rgb(23, 23, 189);',
						name:'fPriority'
					}]
				},{
					xtype: 'ckeditor', 
		            fieldLabel: '描述', 
		            name: 'fDescr', 
		            height:200,
		            anchor: '100%',
					CKConfig:{
				     	filebrowserUploadUrl:'/blogmgr/ckeditor/upload.do'
				   }
				}]
			},{
				//title : '可添信息',
				xtype : 'fieldset',
				border:false,
				defaults : {
					labelAlign : 'right',
					labelWidth : 70,
					allowBlank : true
				},
				items : [{
					xtype:'datefield',
					//name:'fEstimatedDate',
					fieldLabel : '预计时间',
					format:'Y-m-d H:i:s',
					anchor: '20%',
				}
//				,{
//					xtype:'filefield',
//					fieldLabel : '附件',
//					anchor: '25%'
//				}
				]
			}],
			buttons : [{
				itemId : 'save',
				glyph : 0xe650,
				bind:{
					text : '{handlerText}',
					handler:'{saveHandler}'
				}
			}, {
				itemId : 'close',
				text : '关闭',
				glyph : 0xe6af,
				handler:'closeTab'
			}]
		})