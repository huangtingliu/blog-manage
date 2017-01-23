/**
 * 后台用户列表 - 视图模型
 */
Ext.define('BlogMgr.view.user.mgr.UserMgrDialogModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.user_mgr_dialog',
			constructor : function() {  
				this.callParent(arguments);  
			},
			data:{
				operateToolTip:{
					userInfo:'用户基础信息填写',
					userAuth:'可双击选择,或拖拽选择'
				}
			},
			formulas: {  
				toolTip:function(get){
					console.info(get);
					
					return 'aaaa';
				}
			}  
})