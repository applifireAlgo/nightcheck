Ext.define('Demop.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Demop.view.reportui.querycriteria.QueryCriteriaView',
			'Demop.view.reportui.datachart.DataChartViewTab',
			'Demop.view.reportui.datachart.DataChartViewPanel',
			'Demop.view.reportui.ReportViewController' ,
			'Demop.view.fw.MainDataPointPanel',
			'Demop.view.googlemaps.map.MapPanel'
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
