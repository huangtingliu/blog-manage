/**
 * 首页视图模型数据
 */
Ext.define('BlogMgr.view.home.center.HomeIndexModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.home_index',
	data: {  
		firstName: 'John',  
		lastName: 'Doe'  
	},  
	
	formulas: {  
		// We'll explain formulas in more detail soon.  
		name: function (get) {  
		    var fn = get('firstName'), ln = get('lastName');  
		    return (fn && ln) ? (fn + ' ' + ln) : (fn || ln || '');  
		}  
	}
});
