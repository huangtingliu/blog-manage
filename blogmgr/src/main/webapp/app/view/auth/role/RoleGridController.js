/**
 * 角色列表控制器
 */
Ext.define('BlogMgr.view.auth.role.RoleGridController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.auth_rolegrid',
			onRowclick:function( grid , record , tr , rowIndex , e , eOpts){
				//var moduleGrid = this.getView().ownerCt.down('auth_modulegrid');
				var store = Ext.getStore('privilegePagingStore');
				store.addFilter({
					property:'fRoleId',
					value:record.get('fId'),
					operator:'eq'
				});
				store.load();
//				Ext.getStore('privilegePagingStore').load({
//				    params : {
//				    	filter : '[{"property":"fRoleId","value":"'+record.get('fId')+'","operator":"eq"}]'
//					}
//				});

			}
});