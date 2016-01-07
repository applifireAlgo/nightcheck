Ext.define('Demop.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Demop.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Demop.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
