package newproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newproj.app.server.repository.AddressRepository;
import newproj.app.shared.location.Address;
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
import newproj.app.shared.location.AddressType;
import newproj.app.server.repository.AddressTypeRepository;
import newproj.app.shared.location.City;
import newproj.app.server.repository.CityRepository;
import newproj.app.shared.location.Country;
import newproj.app.server.repository.CountryRepository;
import newproj.app.shared.location.State;
import newproj.app.server.repository.StateRepository;

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
            addresstype.setAddressType("2axkqZVV5IXvn5H9ZFr2Q3b7s7Dqh88dUTWVEEPNZmld0NNUzF");
            addresstype.setAddressTypeDesc("8CYugp4p65uYFfe4K1C14Onh8DhOkC9QvZNoDw9kAucq8fsDWx");
            addresstype.setAddressTypeIcon("sRLm2VbWHkAq9302HU7KIacwZQrWy2OmD3ihkNWWDFtUneOkQk");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("lcpwZ2z2HOyES48BhMGOkDZLXiRuA83i");
            city.setCityDescription("KB6GRQp0zLsVV6MNZiNlL5DrMUniCfvCS49DuML1MLs6h1iqrx");
            city.setCityFlag("bF2xaVOmR2fvjuGnYX7bLxRuQ5rvJoBTUiDQwZ13dRARRFmszN");
            city.setCityLatitude(8);
            city.setCityLongitude(3);
            city.setCityName("XT2295SCcbSdxW6vpXXHmFNT18GjSZMgywM8t9sEea6jYavbbG");
            Country country = new Country();
            country.setCapital("itkcDPfeWpYQvolBGEmSSqfqlX1JLsms");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(2);
            country.setCountryCode1("QXj");
            country.setCountryCode2("tP5");
            country.setCountryFlag("FuC1NdNCE2nDzqzXRt9ab7W2ATUXnkit666fcC8eT3TBw8SPee");
            country.setCountryName("jBoaIlD32bTWWCd3WE2FtYScFLipE7TbVQeGxbB7k7J1vA0hju");
            country.setCurrencyCode("dMJ");
            country.setCurrencyName("ZeIpfe3t7dgPrGP6IMRPlsJhLlrsd0zyvnqDSma6BW49v8hzpu");
            country.setCurrencySymbol("yUkd0HZVA89iwSkt32GP2zNnP1tgHAV1");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("W2lPOGrKSr1Gaglo8TGV0aIROTnnx263bDvfiMVtEzH7XgGzV4");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("d5SfvEuTYTZSA0DHYKw7NMwffEfBPkbW");
            state.setStateCodeChar3("zN6Mf0NDbNj4xtwDPNiDA16q8mpxYoBk");
            state.setStateDescription("hK6Oy3wKBljyrKhgZByB8iyAtI0gHNyOwSYE4TPAZ4jxRMyp4R");
            state.setStateFlag("U0Zyo5vzat9PHatKRLTNJwl607lBgIWpL6jp50tguIDMSjrOWw");
            state.setStateName("YM0p1cu2gHU3QJ7znizadUO0RNA2s37tjuG1udJNyTlTMG4Owb");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("XZHw1umCEqRDBeFoqVmk5l0N2WAOtHBu");
            city.setCityDescription("oNYt8e4g2uohg2vPHSHUcqMAx82LquoiZQCYnjtZCwTUD3u9ch");
            city.setCityFlag("E93rRjo3eyz6q6mYOLOauZ1y60Yy2ajKQTf8LkGU2mlwZzFLSf");
            city.setCityLatitude(4);
            city.setCityLongitude(5);
            city.setCityName("SpCKgxiX9kOMUhn9o10YgpLi8b6GxVAgL3FJoOPFIBltcwnjud");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ZQNA9qxdyobTBnChsrV1ztthwOj3rV0wwZhThxql0WkIbtLHJK");
            address.setAddress2("bfMS9vax0sqdpnR5aZLdoEswWmixi7S00IpQioTqAslMrzAD5y");
            address.setAddress3("0NOz2n7PxktK9PcmBFKJyE959EMjEjXSqTes61qNfLKieMaP7Y");
            address.setAddressLabel("hdixGzdMAG5");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("zHrZwSpg8tuYh8uYKYTI6vn14L6C8MdOk2iUB25WNtU4ZIKNQ7");
            address.setLongitude("dCEEwO9tO9nRuh56NRpMVOOhHKjtxLQrZSbc5HbpimlrAZ31FL");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("nYGcpr");
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
            address.setAddress1("kV0Z3hdsn7YYKYjemFbAasQltcajXYb3usnvNDwxoGFqJxdZvf");
            address.setAddress2("9J4f57z7cuUe0aJVgdPmVpfkhrry2sGJxfEtnwqF5r5cI7fqLn");
            address.setAddress3("XUwcsNcdGlO6lUDOZ8z6phkQQ8dg7KKl4Mf8cen4mYuK573KYE");
            address.setAddressLabel("w4UIZq5oHLH");
            address.setLatitude("jFPwOB8wHV1sbgOE3KoEHqtk1KbBgnLJhnLpCr9IrWT4qwO9rO");
            address.setLongitude("peaKHKrb9wuBPD361RERlMgkO2JFt3kflbax2aL21ezeiGB4eb");
            address.setVersionId(1);
            address.setZipcode("MdRnTl");
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
