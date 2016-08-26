/**
 * 导航栏菜单
 */
Ext.define('BlogMgr.model.Menu',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	 fields: [
	    {name: 'fId', type: 'string'},
        {name: 'fName',  type: 'string'},
        {name: 'fParentId',   type: 'string'},
        {name: 'fViewClass', type: 'string'},
        {name: 'fUrl', type: 'string'},
        {name: 'fIcon', type: 'string'},
        {name: 'fGlyph', type: 'int'},
        {name: 'fOrder', type: 'int'},
        {name: 'fType', type: 'string'},
        {name: 'fUsability', type: 'string'},
        {name: 'fDescr', type: 'string'},
        {name: 'fExpand', type: 'int'}
        
    ],
    validators: {
        fId: 'presence',
        fName: 'presence'
    }
});