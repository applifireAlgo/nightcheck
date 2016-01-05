Ext.define('Newproj.newproj.shared.newproj.model.authentication.LoginSessionModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "appSessionId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userid",
          "reference": "User",
          "defaultValue": ""
     }, {
          "name": "appServerSessionId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "loginTime",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "lastAccessTime",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "logoutTime",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "clientIPAddress",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "clientIPAddressInt",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "clientNetworkAddress",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "clientBrowser",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "sessionData",
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