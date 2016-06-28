Ext.define('BlogMgr.view.index.Index', {
			extend : 'Ext.panel.Panel',
			alias : ['widget.tabindex'],
			items : [{
									xtype : 'datefield',
									fieldLabel : 'Start date'
								}, {
									xtype : 'datefield',
									fieldLabel : 'End date'
								}]
		});