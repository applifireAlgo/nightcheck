Ext.define('Newproj.view.databrowsercalendar.DBCalendar', {
	extend : 'Newproj.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Newproj.view.databrowsercalendar.DBCalendarController',
	             'Newproj.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
