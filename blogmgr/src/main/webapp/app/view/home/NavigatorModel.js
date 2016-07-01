/**
 * 导航栏view model
 */
Ext.define('BlogMgr.view.home.NavigatorModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.navigator',
			stores : {
				rootMenu:{	//顶级菜单数据
					model : 'BlogMgr.model.home.Menu',
					proxy : {
						type : 'ajax',
						url : '/blogmgr/menu/menus.data',
						extraParams:{
							parentId:''
						},
						reader : {
							type : 'json',
							successProperty:'success',
							rootProperty:'data',
							messageProperty :'content'
						}
					},
					listeners:{
						load:function(self,records,success){
							if(success){
								var navigator = Ext.getCmp('home_navigator');
								if(Ext.isEmpty(navigator)){
									Ext.log({msg:"[BlogMgr.view.home.NavigatorModel]无法根据[home_navigator]找到导航栏！",level:'error'});
									return;
								}
								navigator.fireEvent('proxyLoad',records);
							}else{
								Ext.log({msg:"[BlogMgr.view.home.NavigatorModel]导航栏数据加载失败！",level:'error'});
							}
						}
					}
					
				}
			}
		})