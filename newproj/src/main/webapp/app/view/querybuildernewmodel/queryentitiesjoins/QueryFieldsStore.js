Ext.define('Newproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Newproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Newproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
