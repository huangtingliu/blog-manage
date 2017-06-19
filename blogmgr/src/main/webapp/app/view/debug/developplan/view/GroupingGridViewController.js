Ext.define('BlogMgr.view.debug.developplan.view.GroupingGridViewController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.dph_grouping_grid_view',
	init : function() {
		this.mask = new Ext.LoadMask({
			msg : '删除中...',
			target : this.getView()
		});
	},
	gridViewTaskFinished:function(grid, td, cellIndex, record, tr, rowIndex, e, eOpts){
		if(cellIndex!=0){return;}
		//TODO 后台实现
		var store = grid.getStore();
		
		if(record.get('fPlanStauts')=='ENABLE'){
			record.set('fPlanStauts','FINISHED')
		}else{
			record.set('fPlanStauts','ENABLE')
		}
		store.commitChanges();
	}
});