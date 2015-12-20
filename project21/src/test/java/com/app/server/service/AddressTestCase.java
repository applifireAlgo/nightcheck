package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("bhV81NtrlMgoAPbEBSMcFKJh1aQwkOQ1JotKJGTfW4i8ePNV0T");
            addresstype.setAddressTypeDesc("p8CoRNqVaWDxguzVnk1x2HOqCSQCrqkHePNHfox1Ph6YikUgm0");
            addresstype.setAddressTypeIcon("h2MF7grclp2K9BQLNNOHYBO76X45qCgMzaTuWDuVnAqhfvzsRx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("2JyDSOqZJqKsK2E3ttUvn1rLgufEFCPt");
            city.setCityDescription("7Ji65OYV5O37VQjhs8euBz4UDHQZ71iJ33fvPNU5fTN72Ru9M4");
            city.setCityFlag("iNgHN4tyIxJCOQOe1GVmjzdguGIrd5DBaTbybSyyTyRbjcpve4");
            city.setCityLatitude(11);
            city.setCityLongitude(2);
            city.setCityName("uRvp5pHACGCZloc6cnPnqIoBy2KXie1sPn5hlYCG9h2DmHzlSS");
            Country country = new Country();
            country.setCapital("p7TUxTws25YzVNN5LJ6gxMgNt093IA4Y");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(7);
            country.setCountryCode1("TyY");
            country.setCountryCode2("SLf");
            country.setCountryFlag("1yl0uzfPyqW5kqYD9P1nfqzZ0FoDbhxFkUnwBCoub7ux3HQ0Lf");
            country.setCountryName("s5fY5PdCWlz3zCiPx8iVDjM5cNFzaO9MWrTAlR2RaglRp7Fz8S");
            country.setCurrencyCode("Vke");
            country.setCurrencyName("13bb5mJoYP8OjAEemogDw5Nv13C9A8RpSxDYBWqy4mwwfM82pD");
            country.setCurrencySymbol("aeuZVVvDxcTnvULTkq6etSx9p6EXvYxM");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("xQ2PdNwKpuo2krpnvTAopyaYSN05tzoQh0E4cDX1FxRFsYhBU4");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("7mLJobZsbtkFTD0dqz0HKoUsxHfNSXo3");
            state.setStateCodeChar3("1lq60V8SpWRmurIUacZNo56pMir44Pqx");
            state.setStateDescription("K1v5GfPOM4cCZVFUkQOIoZuNQsTxqf4OJwd3db3wgOj3OKhe7f");
            state.setStateFlag("1ewvbL83Sw22bbYeyNGgU9TKpyPgWl5d10Rb9AW4S9SeqjpDM9");
            state.setStateName("sDktI2sqFOUXUxYQJFFMwMBm6YtFAx04y4gFhPunEA3VmHkTm0");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("1f72gXSc1AUuhFnrm8X8qUcbuyrLgZLD");
            city.setCityDescription("nWvHR6aJPlLQLbCK16LW6qu2Mw8xMHcZbI428zXkxCnBBR48RO");
            city.setCityFlag("7WIzH38fQHwZ54FcPymRI2VvleHiwLhc23lsFm9Sds6yR4VujE");
            city.setCityLatitude(7);
            city.setCityLongitude(8);
            city.setCityName("tCyJHFHaqsrQh8AglAVVSFkfGVdz5qU3kvMtFNyWhmWo996Kjc");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("SCtr6CBPfSgLmjxI5yoaJV5qe2qY89aQGs8omjvMjnWmQzNUlS");
            address.setAddress2("ewBuIVugG5iZpZLaXs9UuYh4oobzcaqduPFyx4BDjvx6JzEiVi");
            address.setAddress3("RBQBNwm0mw8mUKeY3jusYOE4oKMv3kFTw0L6inglzq1XG2RIFW");
            address.setAddressLabel("PVDUaQzfU2K");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("2rM55lenZc3kWmGxRgcafc1H93xwbN5RoQusOqh7LhABJ0LF8x");
            address.setLongitude("9fwA96w6OA1wTXgw8pb0HbfTux7Er18amKRb0RFS1HBJa6ZX4m");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("Jb3EOp");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("brezM3T8sei4lDdE68zo3M7lb0WyMMTAdyxpgAZGbF4RlyUyHq");
            address.setAddress2("GMV2flhHKMW9oR4zDqr0Z99rhgb8zWMvaxpFQC6IpZouOvE2D4");
            address.setAddress3("eZZxIv9xwmGtPxzBeNgHeEj2F8SGm40zJ9bqUUbT71AfPZKAHc");
            address.setAddressLabel("wmO11QmlFVm");
            address.setLatitude("ZTNXgbZCifE3HOgQXfri6Zi2dNXkFOAOrB2Fw4zQ3pJQ53rEu0");
            address.setLongitude("sMFoDCwf9yP5YGxnnR3b500i4rOzZMwHSWRnQKf0s5E6pgdweM");
            address.setVersionId(1);
            address.setZipcode("ZNkwVg");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
