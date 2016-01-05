Ext.define('Newproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Newproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Newproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
