/**
 * 菜单树Store
 */
Ext.define('BlogMgr.store.MenuTreeStore',{
	extend:'Ext.data.TreeStore',
	alias:'store.menutree',
	storeId : 's_menutree',
	model: 'BlogMgr.model.MenuTree',
	//parentIdProperty:'fParentId',
	/*proxy:{
		type: 'ajax',
        url: '/tree/get-nodes.php'	
	}*/
	root:{
	 text: 'Ext JS',
                    id: 'src',
                    expanded: true
	},
	data: [{
		    fName: 'North America',
		    fId: 'NA'
		}, {
		    fName: 'Unites States',
		    fId: 'USA',
		    fParentId: 'NA'
		}, {
		    fName: 'Redwood City',
		    leaf: true,
		    fParentId: 'USA'
		}, {
		    fName: 'Frederick, MD',
		    leaf: true,
		    fParentId: 'USA'
		}]
});
Ext.create('BlogMgr.store.MenuTreeStore');