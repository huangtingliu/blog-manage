/**
 * 菜单生成工厂，提供系统创建菜单时所要的数据
 */
Ext.define('BlogMgr.view.menu.MenuFactory', {
	// 静态变量或函数
	statics : {
		
		/**
		 * 从服务器获取工具栏菜单,菜单已经带有权限控制了
		 * @param menuId 菜单id
		 * @param parentId 根据菜单的上级编号，获取其下所有的菜单
		 * @return Object 
		 * 例：{
		 * 	toolBarMenus:[{},{}]
		 * }
		 */
		getToolBarMenu:function(menuId,parentId){	
			 var result = {
				 toolBarMenus:[]         
			 };
			 if(!(menuId || parentId)){
				 return result;
			 }
			 var extraParam ={};
			 if(menuId){
				 extraParam.menuId = menuId;
			 }
			 if(parentId){
				 extraParam.parentId = parentId;
			 }
			 Ext.Ajax.request({  
		            url : '/blogmgr/menu/authMenus.data',  
		            async : false, // 同步  
		            params: extraParam,
		            success : function(response) {  
		                var text = response.responseText;  
		                var data = Ext.decode(text, true);  // 将字段串转换成本地变量  
		               
		                if(data.success){
		                	 Ext.each(data.menulist,function(value, index){
									var disable = (value.authPriority=='DISABLE');
									var item = {
										itemId:value.fId,
										text:value.fName,
										glyph:value.fGlyph,
										handler:value.fUrl,
										tooltip:value.fDescr,
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
