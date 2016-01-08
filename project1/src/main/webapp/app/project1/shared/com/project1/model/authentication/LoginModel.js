Ext.define('Project1.project1.shared.com.project1.model.authentication.LoginModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "loginPk",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "loginId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "serverAuthImage",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "serverAuthText",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "failedLoginAttempts",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "CoreContacts",
          "reference": "CoreContactsModel"
     }, {
          "name": "User",
          "reference": "UserModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});