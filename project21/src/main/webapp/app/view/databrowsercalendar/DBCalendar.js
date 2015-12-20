Ext.define('Project21.view.databrowsercalendar.DBCalendar', {
	extend : 'Project21.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project21.view.databrowsercalendar.DBCalendarController',
	             'Project21.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
