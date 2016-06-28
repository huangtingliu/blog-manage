Ext.define('Widget.tabs.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    uses: [
        'Ext.ux.TabReorderer',
        'Widget.tabs.controller.ReorderableTabsCtrl',
        'Ext.ux.TabCloseMenu'
    ],
    alias: ['widget.reorderable-tabs'],
    controller: 'reorderable-tabs',
    plugins: ['tabreorderer','tabclosemenu'],
    defaults: {
        bodyPadding: 10,
        scrollable: true,
        closable: true
    },
    items: [{
    	id:'tab-index',
        title: '首页',
        closable:false
    }]
});  