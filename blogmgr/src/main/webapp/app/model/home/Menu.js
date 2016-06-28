Ext.define('BlogMgr.model.home.Menu',{
	extend:'Ext.data.Model',
	 fields: [
	    {name: 'code', type: 'string'},
        {name: 'name',  type: 'string'},
        {name: 'icon',   type: 'string'},
        {name: 'url', type: 'string'}
    ],
    validators: {
        name: 'presence',
        code: 'presence'
    }
});