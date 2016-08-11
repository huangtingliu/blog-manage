/**
 * 一个可拖拽排序，并支持右键菜单操作
 */
Ext.define('Ux.tabs.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    uses: [
        'Ext.ux.TabReorderer',
        'Ux.tabs.ReorderableTabsController',
        'Ext.ux.TabCloseMenu'
    ],
    alias: ['widget.reorderable_tabs'],
    controller: 'reorderable_tabs',
    plugins: ['tabreorderer','tabclosemenu'],
    defaults: {
        bodyPadding: 10,
        scrollable: true,
        closable: true
    }
});  