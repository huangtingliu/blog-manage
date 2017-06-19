/**
 * 日程表
 */
Ext.define("BlogMgr.view.debug.developplan.view.ScheduleView",{
	extend:'Ext.panel.Panel',
	alias : ['widget.developplan_schedule'],
	layout: 'border',
	requires: [
		'Ext.Viewport',
		'Ext.layout.container.Border',
		'Ext.picker.Date',
		'Ext.calendar.util.Date',
		'Ext.calendar.CalendarPanel',
		'Ext.calendar.data.MemoryCalendarStore',
		'Ext.calendar.data.MemoryEventStore',
		'Ext.calendar.data.Events',
		'Ext.calendar.data.Calendars',
		'Ext.calendar.form.EventWindow'
	],
	constructor:function(){
		var me = this;
		 this.calendarStore = Ext.create('Ext.calendar.data.MemoryCalendarStore', {
            data: Ext.calendar.data.Calendars.getData()
        });
        this.eventStore = Ext.create('Ext.calendar.data.MemoryEventStore', {
            data: Ext.calendar.data.Events.getData()
        });
		me.items= [
//		 {
//            xtype: 'container',
//	        region: 'west',
//	        items: [{
//	            xtype: 'datepicker',
//	            id: 'app-nav-picker',
//	            cls: 'ext-cal-nav-picker',
//	            listeners: {
//	                'select': {
//	                    fn: function(dp, dt){
//	                        Ext.getCmp('app-calendar').setStartDate(dt);
//	                    },
//	                    scope: this
//	                }
//	            }
//	        }]
//	    },
	    {
	        xtype: 'calendarpanel',
	        eventStore: this.eventStore,
	        calendarStore: this.calendarStore,
	        border: false,
	        id:'app-calendar',
	        region: 'center',
	        activeItem: 3, // month view
	        
	        monthViewCfg: {
	            showHeader: true,
	            showWeekLinks: true,
	            showWeekNumbers: true
	        },
	        
	        listeners: {
	            'eventclick': {
	                fn: function(vw, rec, el){
	                    this.showEditWindow(rec, el);
	                    this.clearMsg();
	                },
	                scope: this
	            },
	            'eventover': function(vw, rec, el){
	                //console.log('Entered evt rec='+rec.data.Title+', view='+ vw.id +', el='+el.id);
	            },
	            'eventout': function(vw, rec, el){
	                //console.log('Leaving evt rec='+rec.data.Title+', view='+ vw.id +', el='+el.id);
	            },
	            'eventadd': {
	                fn: function(cp, rec){
	                    this.showMsg('Event '+ rec.data.Title +' was added');
	                },
	                scope: this
	            },
	            'eventupdate': {
	                fn: function(cp, rec){
	                    this.showMsg('Event '+ rec.data.Title +' was updated');
	                },
	                scope: this
	            },
	            'eventcancel': {
	                fn: function(cp, rec){
	                    // edit canceled
	                },
	                scope: this
	            },
//	            'viewchange': {
//	                fn: function(p, vw, dateInfo){
//	                    if(this.editWin){
//	                        this.editWin.hide();
//	                    }
//	                    if(dateInfo){
//	                        // will be null when switching to the event edit form so ignore
//	                        Ext.getCmp('app-nav-picker').setValue(dateInfo.activeDate);
//	                        this.updateTitle(dateInfo.viewStart, dateInfo.viewEnd);
//	                    }
//	                },
//	                scope: this
//	            },
	            'dayclick': {
	                fn: function(vw, dt, ad, el){
	                    this.showEditWindow({
	                        StartDate: dt,
	                        IsAllDay: ad
	                    }, el);
	                    this.clearMsg();
	                },
	                scope: this
	            },
	            'rangeselect': {
	                fn: function(win, dates, onComplete){
	                    this.showEditWindow(dates);
	                    this.editWin.on('hide', onComplete, this, {single:true});
	                    this.clearMsg();
	                },
	                scope: this
	            },
	            'eventmove': {
	                fn: function(vw, rec){
	                    var mappings = Ext.calendar.data.EventMappings,
	                        time = rec.data[mappings.IsAllDay.name] ? '' : ' \\a\\t g:i a';
	                    
	                    rec.commit();
	                    
	                    this.showMsg('Event '+ rec.data[mappings.Title.name] +' was moved to '+
	                        Ext.Date.format(rec.data[mappings.StartDate.name], ('F jS'+time)));
	                },
	                scope: this
	            },
	            'eventresize': {
	                fn: function(vw, rec){
	                    rec.commit();
	                    this.showMsg('Event '+ rec.data.Title +' was updated');
	                },
	                scope: this
	            },
	            'eventdelete': {
	                fn: function(win, rec){
	                    this.eventStore.remove(rec);
	                    this.showMsg('Event '+ rec.data.Title +' was deleted');
	                },
	                scope: this
	            },
	            'initdrag': {
	                fn: function(vw){
	                    if(this.editWin && this.editWin.isVisible()){
	                        this.editWin.hide();
	                    }
	                },
	                scope: this
	            }
	        }
	    }]
	    me.callParent(arguments);
	}
	
//	html:'<div style="position: absolute;top: 41%;left: 45%;"><i style="font-size:150px;color:gray" class="iconfont icon-gongju">'+
//	'<br><span style="font-size:60px">未开发</span></i><div>'
});