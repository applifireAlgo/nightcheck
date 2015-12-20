Ext.define('Project21.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Project21.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Project21.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
