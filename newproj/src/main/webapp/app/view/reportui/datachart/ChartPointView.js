Ext.define('Newproj.view.reportui.datachart.ChartPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Newproj.view.reportui.datachart.ChartPointController'],
	xtype : 'chart-point',
	controller : 'chartPointController',
	//bodyStyle : 'background:#D8D8D8',
	itemId:"chartpoint",
	
	//defualtHeight:100,
	layout : {
		type : 'hbox',
	}
});

