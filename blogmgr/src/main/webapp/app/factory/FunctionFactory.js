/**
 * extjs 组件创建工厂
 */
Ext.define('BlogMgr.factory.FunctionFactory', {
	// 静态变量或函数
	statics : {
		
		/**
		 * 根据模块功能，创建一组工具栏按钮
		 * @param funId 功能id
		 * @param parentId 根据的上级编号，获取其下所有的功能
		 * @return Object 
		 * 例：{
		 * 	toolBar:[{},{}]
		 * }
		 */
	    KEY_TOOLBAR:'toolBar', 
		getToolBar:function(funId,parentId){	
			 var result = {
				 toolBar:[]         
			 };
			 if(!(funId || parentId)){
				 return result;
			 }
			 var extraParam ={
				 type:'TOOLBAR'
			 };
			 if(funId){
				 extraParam.funId = funId;
			 }
			 if(parentId){
				 extraParam.parentId = parentId;
			 }
			 Ext.Ajax.request({  
		            url : '/blogmgr/privilege/union_privilege.data',  
		            async : false, // 同步  
		            method: 'POST',
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
									result.toolBar.push(item);
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