Ext.define('Widget.tabs.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    requires: [
        'Ext.ux.TabReorderer',
        'Widget.tabs.controller.ReorderableTabsCtrl'
    ],
    alias: ['widget.reorderable-tabs'],
    controller: 'reorderable-tabs',
    plugins: 'tabreorderer',
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