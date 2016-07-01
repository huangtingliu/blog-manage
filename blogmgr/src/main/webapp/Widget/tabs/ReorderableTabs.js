/**
 * 一个可拖拽排序，并支持右键菜单操作
 */
Ext.define('Widget.tabs.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    uses: [
        'Ext.ux.TabReorderer',
        'Widget.tabs.controller.ReorderableTabsController',
        'Ext.ux.TabCloseMenu'
    ],
    alias: ['widget.reorderable-tabs'],
    controller: 'reorderable-tabs',
    plugins: ['tabreorderer','tabclosemenu'],
    defaults: {
        bodyPadding: 10,
        scrollable: true,
        closable: true
    }
});  