/**
 * 
 */
Ext.define
(
		'Project21.view.searchengine.searchsetup.ChartFieldsStoreX',
		{
			extend : 'Ext.data.Store',
			requires : ['Project21.view.searchengine.searchsetup.ChartFieldsModel'],
			alias: 'store.chartfieldsstorex',
			model : 'Project21.view.searchengine.searchsetup.ChartFieldsModel',
			autoLoad:false,
			/*proxy : 
			{
				type : 'ajax',
				url : 'queryBuilder_/getQueryDetails',
				params : 
				{
					queryID : this.fieldname
				},
				reader : 
				{	
					type : 'json'
				}
			},
			listeners : 
			{
				load : function(store, records, successful, operation, eOpts) 
				{
				}
			}*/

		}
);