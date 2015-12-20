Ext.define('Project21.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Project21.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Project21.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
