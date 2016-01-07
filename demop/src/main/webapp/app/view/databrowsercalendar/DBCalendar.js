Ext.define('Demop.view.databrowsercalendar.DBCalendar', {
	extend : 'Demop.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Demop.view.databrowsercalendar.DBCalendarController',
	             'Demop.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
