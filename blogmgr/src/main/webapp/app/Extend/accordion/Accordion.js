Ext.define('Extend.accordion.Accordion', {
    extend: 'Ext.panel.Panel',
    requires: [
        'Ext.layout.container.Accordion'
    ],
    xtype: 'layout-accordion',
    layout: 'accordion',
    defaults: {
        bodyPadding: 10
    },
    
    changeRenderer: function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    },
    
    pctChangeRenderer: function(val){
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }
});