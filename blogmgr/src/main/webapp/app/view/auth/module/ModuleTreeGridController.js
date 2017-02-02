Ext.define('BlogMgr.view.auth.module.ModuleTreeGridController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.auth_moduletreegrid',
	treeGridIsExpandAll:false,
	//给treeGrid的【组件编号】标题添加双击事件,使其展开或收起
	treeGridAfterRender:function(treeGrid,eOpts){
		var _this = this;
		var treecolumn = treeGrid.down('treecolumn');
		treecolumn.getEl().on("dblclick",function(){
			if(!_this.treeGridIsExpandAll){
				treeGrid.expandAll(function(){
					_this.treeGridIsExpandAll = true;
				});
			}else{
				treeGrid.collapseAll(function(){
					_this.treeGridIsExpandAll = false;
				});
			}
		},this);
		
	}
	
});