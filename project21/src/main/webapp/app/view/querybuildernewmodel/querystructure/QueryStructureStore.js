Ext.define('Project21.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Project21.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Project21.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
