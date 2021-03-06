Ext.define('Project1.project1.shared.com.project1.model.location.TimezoneModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "timeZoneId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "utcdifference",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "gmtLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "timeZoneLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "country",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cities",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});