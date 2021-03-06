Ext.define('Demop.demop.web.com.controller.location.TalukaMainController', {
     extend: 'Demop.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.TalukaMainController',
     /*********************Main Controller Functions*********************************/
     init: function() {
          var but = this.view.down('#resetFormButton');
          but.up('form').reset();
          if (this.view.disableDB != null && this.view.disableDB) {
               this.hideDataBrowser();
          } else {
               this.renderTreeGridData();
          }
          this.countryIdLoad();
     },
     countryIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Country/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#countryId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'countryId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#countryId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     onCountryIdChange: function(me, newValue, oldValue, eOpts) {
          this.onCountryIdChangeStateId(me, newValue, oldValue, eOpts);
          this.onCountryIdChangeRegionId(me, newValue, oldValue, eOpts);
          this.onCountryIdChangeDistrictId(me, newValue, oldValue, eOpts);
     },
     onStateIdChange: function(me, newValue, oldValue, eOpts) {
          this.onStateIdChangeRegionId(me, newValue, oldValue, eOpts);
          this.onStateIdChangeDistrictId(me, newValue, oldValue, eOpts);
     },
     onRegionIdChange: function(me, newValue, oldValue, eOpts) {
          this.onRegionIdChangeDistrictId(me, newValue, oldValue, eOpts);
     },
     onCountryIdChangeStateId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/State/findByCountryId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var stateIdCombo = scope.element.up('form').down('#stateId');
                    scope.sender.controller.assignComboData(stateIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, stateIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onCountryIdChangeRegionId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/Region/findByCountryId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var regionIdCombo = scope.element.up('form').down('#regionId');
                    scope.sender.controller.assignComboData(regionIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, regionIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onCountryIdChangeDistrictId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/District/findByCountryId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var districtIdCombo = scope.element.up('form').down('#districtId');
                    scope.sender.controller.assignComboData(districtIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, districtIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onStateIdChangeRegionId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/Region/findByStateId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var regionIdCombo = scope.element.up('form').down('#regionId');
                    scope.sender.controller.assignComboData(regionIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, regionIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onStateIdChangeDistrictId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/District/findByStateId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var districtIdCombo = scope.element.up('form').down('#districtId');
                    scope.sender.controller.assignComboData(districtIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, districtIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onRegionIdChangeDistrictId: function(me, newValue, oldValue, eOpts) {
          debugger;
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/District/findByRegionId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var districtIdCombo = scope.element.up('form').down('#districtId');
                    scope.sender.controller.assignComboData(districtIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, districtIdCombo);
               },
               failure: function(response, scope) {
                    debugger;
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     fetchDataAjaxCall: function() {
          var url = this.getView().restURL;
          var me = this;
          var data = null;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               maskEnable: true,
               async: false,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    data = responseData;
                    me.addCommunicationLog(response, true);
               },
               failure: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
                    me.addCommunicationLog(response, false);
               }
          }, this);
          return data;
     },
     onTreeRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          var tree = this.view.down('#TalukaTree');
          var rootNode = tree.getRootNode();
          rootNode.removeAll();
          for (var index = 0; index < data.length; index++) {
               var childNode = {
                    text: data[index].primaryDisplay,
                    bConfig: data[index],
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
          tree.getStore().sort('text', 'ASC');
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          this.setGridData(data);
     },
     refreshMainForm: function(but, data) {
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          } /** Adding data to tree and grid */
          if (data != null && data instanceof Object) {
               var grid = this.view.down('#TalukaGrid');
               grid.store.add(data);
               var tree = this.view.down('#TalukaTree');
               var rootNode = tree.getRootNode();
               var childNode = {
                    text: data.primaryDisplay,
                    bConfig: data,
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
     },
     hideDataBrowser: function() {
          var form = this.view.down('#Taluka');
          var grid = this.view.down('#TalukaGrid');
          var tree = this.view.down('#TalukaTreeContainer');
          grid.setHidden(true);
          this.view.down('#addNewForm').destroy();
          tree.setHidden(true);
          if (this.view.primaryKey != null) {
               this.findById(this.view.primaryKey);
          }
     },
     renderTreeGridData: function(responseData) {
          if (responseData == null) {
               responseData = this.fetchDataAjaxCall();
          }
          if (responseData.response.success) {
               var data = responseData.response.data;
               var tree = this.view.down('#TalukaTree');
               var rootNode = tree.getRootNode();
               rootNode.removeAll();
               for (var index = 0; index < data.length; index++) {
                    var childNode = {
                         text: data[index].primaryDisplay,
                         bConfig: data[index],
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
               tree.getStore().sort('text', 'ASC');
               this.setGridData(data);
          } else if (!sessionTimeOutFlag) {
               Ext.Msg.alert('Server Response', responseData.response.message);
          }
     },
     /********************************Tree Controller Functions**********************************/
     onFilterClick: function(but, evt) {
          var currentObject = this.getView();
          var data = but.up('form').getForm().getValues();
          var searchData = {};
          for (key in data) {
               console.log(key, data[key]);
               if (data[key] != null && data[key] != '') {
                    searchData[key] = data[key];
               }
          }
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               maskMsg: 'Filtering data ...',
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, currentObject) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    currentObject.view.controller.renderTreeGridData(responseData);
               },
               failure: function(response, eopts) {
                    Ext.MessageBox.show({
                         title: 'Error',
                         msg: response.statusText,
                         icon: Ext.MessageBox.ERROR
                    });
               }
          });
     },
     treeClick: function(me, record, item, index, e, eOpts) {
          if (record.data.leaf) {
               var gridPanel = this.view.up().down('#TalukaGrid');
               var foundRecord = gridPanel.store.findRecord('primaryKey', record.data.bConfig.primaryKey);
               if (gridPanel && foundRecord) {
                    gridPanel.setSelection(foundRecord);
               }
               var formPanel = this.getView().up().down("#Taluka");
               var vm = formPanel.getViewModel(); /** Finding record by id */
               var data = this.findRecordById(this.view.restURL, record.data.bConfig.primaryKey);
               vm.setData(data);
               for (var key in data) {
                    if (formPanel.down('#' + key) != null && (formPanel.down('#' + key).xtype == 'datefield' || formPanel.down('#' + key).xtype == 'customdatetimefield')) {
                         var res = data[key].replace(' IST', '');
                         var dt = Ext.Date.parse(res, 'd-m-Y H:i:s');
                         formPanel.down('#' + key).setValue(dt);
                    }
               }
          }
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) { /** Finding record by id */
          record.data = this.findRecordById(this.view.restURL, record.data.primaryKey);
          var treePanel = this.view.up().up().down('#TalukaTree');
          var foundNode = this.findChild(treePanel.getRootNode(), 'primaryKey', record.data.primaryKey);
          if (treePanel && foundNode) {
               treePanel.setSelection(foundNode);
          } else {
               var formPanel = this.getView().up().down('#Taluka');
               var vm = formPanel.getViewModel();
               var data = record.data;
               vm.setData(data);
               for (var key in data) {
                    if (formPanel.down('#' + key) != null && (formPanel.down('#' + key).xtype == 'datefield' || formPanel.down('#' + key).xtype == 'customdatetimefield')) {
                         var res = data[key].replace(' IST', '');
                         var dt = Ext.Date.parse(res, 'd-m-Y H:i:s');
                         formPanel.down('#' + key).setValue(dt);
                    }
               }
          }
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#Taluka').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#TalukaGrid').store;
          gridStore.removeAll();
          gridStore.setData(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     findChild: function(node, key, value) {
          var dNode = node;
          if (node.data.bConfig != null && node.data.bConfig[key] == value) {
               return node;
          } else if (node.childNodes) {
               for (var index = 0; index < node.childNodes.length; index++) {
                    dNode = this.findChild(node.childNodes[index], key, value);
                    if (dNode) {
                         return dNode;
                    }
               }
          } else {
               return null;
          }
     },
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.talukaId;
          me = this;
          Ext.MessageBox.confirm({
               title: 'Confirm',
               msg: 'Delete Feature',
               buttons: Ext.MessageBox.YESNO,
               fn: function(clickedButtonId) {
                    if (clickedButtonId == 'yes') {
                         me.deleteRecord(recordId)
                    }
               },
               animateTarget: this,
               icon: Ext.MessageBox.QUESTION
          })
     },
     deleteRecord: function(recordId) {
          var restURL = this.view.restURL;
          var url = 'secure' + restURL + '/' + recordId;
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: {},
               success: function(response, opts) {
                    if (response.status == 204) {
                         Ext.Msg.alert('Server Response', 'Record Deleted Sucessfully');
                         me.refreshMainForm();
                    } else {
                         responseData = Ext.JSON.decode(response.responseText);
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
     /********************************Form Controller Functions***********************************/
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               controller: me,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, request) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         request.controller.loadData(responseData);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
               }
          }, this);
     },
     loadData: function(responseData) {
          this.view.down('#Taluka').getViewModel().setData(responseData.response.data);
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     resetForm: function(but) {
          var form = but.up('form');
          form.reset();
          var data = form.viewModel.getData();
          for (var element in data) {
               data[element] = '';
          }
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var jsonData = this.getData(form);
          var method;
          if (jsonData.talukaId == null) {
               method = 'POST'
          } else {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               maskMsg: 'Data saving ...',
               jsonData: jsonData,
               success: function(response, opts) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         me.refreshMainForm(but, responseData.response.data);
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
});