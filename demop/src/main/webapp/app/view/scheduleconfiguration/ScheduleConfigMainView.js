/**
 * 
 */
Ext.define("Demop.view.scheduleconfiguration.ScheduleConfigMainView", {
	extend : 'Ext.panel.Panel',
	xtype : 'schedulerConfigTreeMainView',
	layout : {
		type : 'border'
	},

	requires : [ 'Demop.view.scheduleconfiguration.tree.ScheduleConfigTree', 'Demop.view.scheduleconfiguration.tab.ScheduleConfigTab' ],
	items : [ {
		region : 'west',
		title : 'Schedules',
		width : '20%',
		split : true,
		layout : 'anchor',
		collapsible : true,
		xtype : 'schedulerConfigTreePanel',
		itemId : 'schedulerConfigTreePanel'
	}, {
		region : 'center',
		xtype : 'schedulerConfigTab',
		itemId : 'schedulerConfigTab'
	} ]
});