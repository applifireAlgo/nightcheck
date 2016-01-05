Ext.define('Newproj.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Newproj.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Newproj.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
