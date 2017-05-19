Ext.define('BlogMgr.component.picker.user.UserMultiSelector', {
	extend : 'Ext.form.field.Tag',
	requires:['BlogMgr.component.picker.user.unit.UserSelectorStore',
	          'BlogMgr.component.picker.user.unit.UserSelectorDialog'],
	alias : 'widget.user_multi_selector',
	store: {
	    type: 'user_selector_store'
	},
	displayField:'fName',
	valueField:'fAccount',
	queryDelay :500,
	queryMode:'remote',
	queryParam:'userName',
	multiSelect:true,
	minChars:1, //输出1个字后就开始查询
	delimiter:',', //分割符
	//pageSize:3,
	//emptyText:'请选择用户',
	//editable:true,
	//selectOnFocus:true,
	//hiddenName:'users', //真正提交时的字段名称
	listConfig:{
		maxHeight:150,
		emptyText:'未找到...',
		loadingText:'查找中...'
	},
	triggers : {
		picker : {
			weight : 0,
			cls : Ext.baseCSSPrefix + 'form-arrow-trigger',
			hidden : true,
			scope : 'this'
		},
		clear : {
			weight : 0,
			cls : Ext.baseCSSPrefix + 'form-clear-trigger',
			hidden : true,
			handler : 'onClearClick',
			scope : 'this'
		},
		search : {
			weight : 1,
			cls : Ext.baseCSSPrefix + 'form-search-trigger',
			handler : 'onSearchClick',
			scope : 'this'
		}
	},
	onClearClick : function() {},
	onSearchClick : function() {
		var me = this;
		
		Ext.create('BlogMgr.component.picker.user.unit.UserSelectorDialog', {
			callback:function(selectUsers){
				Ext.each(selectUsers,function(value,index){
					var _store = me.getStore();
					_store.add(value);
					me.addValue(value.data.fAccount);
				});
				
			}
		}).show();
	}
});