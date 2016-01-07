Ext.define('Demop.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Demop.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Demop.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
