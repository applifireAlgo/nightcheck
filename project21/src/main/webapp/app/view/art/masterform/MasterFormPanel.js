Ext.define('Project21.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Project21.view.art.masterform.MasterFormModel','Project21.view.art.masterform.MasterFormViewModel','Project21.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	