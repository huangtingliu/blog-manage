Ext.define('BlogMgr.model.home.Menu',{
	extend:'Ext.data.Model',
	 fields: [
        {name: 'name',  type: 'string'},
        {name: 'icon',   type: 'string'},
        {name: 'url', type: 'string'}
    ],
    validators: {
        name: 'presence'
    }
});