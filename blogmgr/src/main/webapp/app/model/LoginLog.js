/**
 * 登录日志
 */
Ext.define('BlogMgr.model.LoginLog',{
	extend:'Ext.data.Model',
	idProperty:'fId',
	fields:[
		{name:'fId',type:'string'},
		{name:'fIp',type:'string'},
		{name:'fBrowser',type:'string'},
		{name:'fCreateDate',type:'date',convert:function(val){
			return Ext.Date.format(new Date(val),'Y-m-d H:i:s');
		}},
		{name:'fOperatingSystem',type:'string'},
		{name:'userName',type:'string'},
		{name:'userAccount',type:'string'},
		{name:'fUid',type:'string'}
	],
	validators: {
        fId: 'presence'
    }
    
})
