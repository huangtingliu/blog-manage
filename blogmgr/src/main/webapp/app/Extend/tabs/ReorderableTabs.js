Ext.define('Extend.tabs.ReorderableTabs', {
    extend: 'Ext.tab.Panel',
    requires: [
        'Ext.ux.TabReorderer'
    ],
    xtype: 'reorderable-tabs',
    controller: 'reorderable-tabs',
    plugins: 'tabreorderer',
    defaults: {
        bodyPadding: 10,
        scrollable: true,
        closable: true
    },
    items: [{
        title: 'Tab 1',
        html: 'The tabs in this example are reorderable. Drag any tab to change the order.'
    },{
        title: 'Tab 2',
        html: 'The tabs in this example are reorderable. Drag any tab to change the order.'
    }]
});  