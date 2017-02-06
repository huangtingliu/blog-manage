/**
 * 菜单工厂，提供系统创建功能菜单时所要的数据
 */
Ext.define('BlogMgr.view.fun.MenuFactory', {
	// 静态变量或函数
	statics : {
		
		/**
		 * 创建一组工具栏按钮
		 * @param funId 功能id
		 * @param parentId 根据的上级编号，获取其下所有的功能
		 * @return Object 
		 * 例：{
		 * 	toolBarMenus:[{},{}]
		 * }
		 */
		getToolBarMenu:function(funId,parentId){	
			 var result = {
				 toolBarMenus:[]         
			 };
			 if(!(funId || parentId)){
				 return result;
			 }
			 var extraParam ={};
			 if(funId){
				 extraParam.funId = funId;
			 }
			 if(parentId){
				 extraParam.parentId = parentId;
			 }
			 Ext.Ajax.request({  
		            url : '/blogmgr/privilege/union_privilege.data',  
		            async : false, // 同步  
		            params: extraParam,
		            success : function(response) {  
		                var text = response.responseText;  
		                var data = Ext.decode(text, true);  // 将字段串转换成本地变量  
		                if(data.success){
		                	 Ext.each(data.privilegelist,function(value, index){
									var disable = (value.fPriority=='DISABLE');
									var item = {
										itemId:value.fFunId,
										text:value.funName,
										glyph:value.funGlyph,
										handler:value.funHandler,
										tooltip:value.funDescr,
										disabled:disable,
										xtype:'transparent_button'
									};
									result.toolBarMenus.push(item);
				                });
		                }
		            },
		            failure: function(response, opts) {
		            	Ext.toast({
							type : 'exception',
							content : '会话超时，请重新登录'
						});
		            	throw exception('会话超时，请重新登录');
		            }
		        });
		        return result;
		}
	}
});