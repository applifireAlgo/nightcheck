Ext.define('Project21.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project21.view.reportui.querycriteria.QueryCriteriaView',
			'Project21.view.reportui.datachart.DataChartViewTab',
			'Project21.view.reportui.datachart.DataChartViewPanel',
			'Project21.view.reportui.ReportViewController' ,
			'Project21.view.fw.MainDataPointPanel',
			'Project21.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
