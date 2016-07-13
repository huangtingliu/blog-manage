/**
 * 后台用户
 */
Ext.define('BlogMgr.model.MgrUser',{
	extend:'Ext.data.Model',
	idProperty:'fId',	//主键标识
	
	fields:[
		{name:'ck',type:'boolean'},
		{name:'fId',type:'string'},
		{name:'fName',type:'string'},
		{name:'fAccount',type:'string'},
		{name:'fGender',type:'string',convert:function(data){
			if("MALE"==data){
				return '男';
			}else if("FEMALE"==data){
				return '女';
			}
			return '未知'
		}},
		{name:'fStatus',type:'string',convert:function(val){
			if("ENABLE"==val){
				return '可用';
			}
			return '不可用';
			
		}},
		{name:'fPhone',type:'string'},
		{name:'fEmail',type:'string'},
		{name:'fCreater',type:'string'},
		{name:'fCreateDate',type:'date',convert:function(val){
			return Ext.Date.format(new Date(val),'Y-m-d H:i:s');
		}}
	],
	validators: {
        fId: 'presence',
        fAccount: 'presence',
        fName: 'presence',
        fStatus:'presence'
    }
    
})


