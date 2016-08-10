/**
 * 菜单树model
 */
Ext.define('BlogMgr.model.MenuTree',{
	extend:'Ext.data.TreeModel',
	idProperty:'fId',
	fields: [
	    {name: 'fId', type: 'string'},
        {name: 'fName',  type: 'string'},
        {name: 'fParentId',   type: 'string'},
        {name: 'fIcon',   type: 'string'},
        {name: 'fGlyph', type: 'int'}
    ]
})