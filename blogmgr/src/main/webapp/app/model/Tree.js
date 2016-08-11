/**
 * ext树模型
 */
Ext.define('BlogMgr.model.Tree',{
	extend:'Ext.data.TreeModel',
	idProperty:'id',	//主键标识
	 fields: [
	    {name: 'id', type: 'string'},
        {name: 'text',  type: 'string'},
        {name: 'parentId',   type: 'string'},
        {name: 'iconCls',   type: 'string',convert:function(val){
        	return 'fa '+val;
        }},
        {name: 'leaf', type: 'boolean'},
        {name: 'expanded', type: 'boolean'},
        {name: 'childrenSize', type: 'int'},
        {name: 'children', type: 'auto'},
        {name: 'attr', type: 'auto'}
    ]
});