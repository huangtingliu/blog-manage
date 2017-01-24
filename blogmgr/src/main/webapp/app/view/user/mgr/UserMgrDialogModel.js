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
				},
				selectTabType:'user_userinfoform'
			},
			formulas: {  
				toolTip:function(get){
					if(get('selectTabType')=='user_userauthform'){
						return get('operateToolTip.userAuth');
					}
					return get('operateToolTip.userInfo');
				}
			}  
})