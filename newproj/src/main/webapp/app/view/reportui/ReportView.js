Ext.define('Newproj.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Newproj.view.reportui.querycriteria.QueryCriteriaView',
			'Newproj.view.reportui.datachart.DataChartViewTab',
			'Newproj.view.reportui.datachart.DataChartViewPanel',
			'Newproj.view.reportui.ReportViewController' ,
			'Newproj.view.fw.MainDataPointPanel',
			'Newproj.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
