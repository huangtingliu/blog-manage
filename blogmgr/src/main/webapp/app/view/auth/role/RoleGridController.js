/**
 * 角色列表控制器
 */
Ext.define('BlogMgr.view.auth.role.RoleGridController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.auth_rolegrid',
			selectedRecId:null,	//已经选中的记录id
			onRowclick:function( grid , record , tr , rowIndex , e , eOpts){
				var newSelectedRec = record.get('fId');
				if(newSelectedRec==this.selectedRecId){return;} //避免点击多次就加载多次记录的情况
				this.selectedRecId = newSelectedRec;
				var store = Ext.getStore('privilegeTreeStore');
				store.getProxy().extraParams = null;
				store.getRootNode().removeAll();
				store.load({
					params:{
						filter:'[{"property":"fRoleId","value":"'+this.selectedRecId+'","operator":"eq"}]'
					}
				});
			}
});