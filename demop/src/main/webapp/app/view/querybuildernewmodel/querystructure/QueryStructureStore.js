Ext.define('Demop.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Demop.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Demop.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
