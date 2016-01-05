Ext.define('Newproj.view.usermanagement.admin.AddUserDetailsViewModel',
{
	extend : 'Ext.app.ViewModel',
	
	alias : 'viewmodel.addUserModel',

	model: "AddUserDataModel",
	 
	requires:['Newproj.model.AddUserDataModel'],

});