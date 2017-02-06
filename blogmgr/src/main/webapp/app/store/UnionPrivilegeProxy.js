/**
 * 将多个角色所持有的权限合并在一起
 */
Ext.define('BlogMgr.store.UnionPrivilegeProxy', {
			extend : 'Ext.data.proxy.Ajax',
			alias: 'proxy.union_privilege',
			model : 'BlogMgr.model.Privilege',
			url : '/blogmgr/privilege/union_privilege.data',
			constructor:function(config){
				this.callParent(arguments);
			},
			reader : {
				type : 'json',
				rootProperty : 'privilegelist',
				successProperty : 'success',
				messageProperty : 'message'
			}
		});