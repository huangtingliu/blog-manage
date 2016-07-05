/**
 * 导航栏菜单
 */
Ext.define('BlogMgr.model.Menu',{
	extend:'Ext.data.Model',
	 fields: [
	    {name: 'fId', type: 'string'},
        {name: 'fName',  type: 'string'},
        {name: 'fIcon',   type: 'string'},
        {name: 'fLink', type: 'string'},
        {name: 'fGlyph', type: 'int'},
         {name: 'fExpand', type: 'int'}
    ],
    validators: {
        fId: 'presence',
        fName: 'presence'
    }
});