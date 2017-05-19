Ext.define('BlogMgr.component.picker.user.unit.UserSelectorDialogController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.user_selector_dialog',
	
	/**
	 * 重置查询框
	 */
	reset:function(){
		var form = this.getView().down('form').getForm();
		var nameField = form.findField('name');
		var accountField = form.findField('account');
		var statusField = form.findField('status');
		var genderField = form.findField('gender');
		nameField.setValue("");
		accountField.setValue("");
		statusField.setValue("");
		genderField.setValue("");
		
		var store =  this.getView().items.get(0).items.get(1).getStore();
		store.clearFilter();
	},
	 /**
	  * 查询
	  */
	search:function(){
		var store =  this.getView().items.get(0).items.get(1).getStore();
		var form = this.getView().down('form').getForm();
		var nameField = form.findField('name');
		var accountField = form.findField('account');
		var statusField = form.findField('status');
		var genderField = form.findField('gender');
		
		if(!Ext.isEmpty(nameField.getValue())){
			store.filter([{
				property:'fName',
				operator:'like',
				value:nameField.getValue()
			}]);
		}
		
		if(!Ext.isEmpty(accountField.getValue())){
			store.filter([{
				property:'fAccount',
				operator:'like',
				value:accountField.getValue()
			}]);
		}
		
		if(!Ext.isEmpty(statusField.getValue())){
			store.filter([{
				property:'fStatus',
				operator:'eq',
				value:statusField.getValue()
			}]);
		}
		
		if(!Ext.isEmpty(genderField.getValue())){
			store.filter([{
				property:'fGender',
				operator:'eq',
				value:genderField.getValue()
			}]);
		}
	},
	  
	//确定选择
	selectorSubmit:function(){
		var view = this.getView();
		if(view._callback){
			var store =  this.getView().items.get(0).items.get(2).getStore();
			if(!Ext.isEmpty(store.getData().items)){
				view._callback(store.getData().items);
			}else{
				view._callback([]);
			}
		}
		this.getView().close();
	}



});