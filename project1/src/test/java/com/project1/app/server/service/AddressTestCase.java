package com.project1.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.AddressRepository;
import com.project1.app.shared.location.Address;
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
import com.project1.app.shared.location.AddressType;
import com.project1.app.server.repository.AddressTypeRepository;
import com.project1.app.shared.location.City;
import com.project1.app.server.repository.CityRepository;
import com.project1.app.shared.location.Country;
import com.project1.app.server.repository.CountryRepository;
import com.project1.app.shared.location.State;
import com.project1.app.server.repository.StateRepository;

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
            addresstype.setAddressType("e5ws3XpBwVwCcSCGBdR5TkAVg7gjKleWUdandGa9F9nbPOd1X5");
            addresstype.setAddressTypeDesc("De761JDFqbNmRsLCrbHnU2F4obZAf01MLFF5hXlsbSMoqvvCYZ");
            addresstype.setAddressTypeIcon("K9E8g4VfJ4T41cv1Iqyt6sc3SK71aMsoEaHHQGWMWiV73jp3Hg");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("kEWXtfOzQyaE1ySd6I6Iss1wxdFvzeD3");
            city.setCityDescription("AI1xkrz8SsjoMibvs7KbkwB6wt8tfr3c9fQ2oPBFHViQohKm2d");
            city.setCityFlag("ZUs3bnJjabyYo1hmRCSEHh86ekfbdCcSfcL75h0DIhOi40qhTC");
            city.setCityLatitude(0);
            city.setCityLongitude(2);
            city.setCityName("QPrMIMZb0NwBs2x70Fc81QA6ojg6XWNLxSyag1u3DqS9bSrKNA");
            Country country = new Country();
            country.setCapital("B6mQ1UxluOnIXk8m3wj3ug5ceTO4T90V");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(2);
            country.setCountryCode1("Hzj");
            country.setCountryCode2("6Vv");
            country.setCountryFlag("ieHz7Cjgbc3VZ5MOsPPzufKjNHfH6DtMhrx2lnbNTQagsNrl5Z");
            country.setCountryName("E8vBZVG2p4hluP1zqRcPM12xuZVbV3dOsif22ZJTBOZ0fsxSOW");
            country.setCurrencyCode("g2A");
            country.setCurrencyName("7UUkxLdGqzSxepANb2c9GiTqunNDWN3c6lN9xtKSdppbRN5yMT");
            country.setCurrencySymbol("0mLLcf28eZBMGCv8oJjAMlXoap7MSFzc");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("EiQvx0TkwCx8SiKMgfurvFOsrmhVPTZ96oWNEUN8ulF8ALTDfv");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("R5Uuo2vnOz6ivg2jhOJW0kCnIkqxSsSh");
            state.setStateCodeChar3("i0Yw1Qj2EtRD0Y3NhhQCsptC1tSLMsGj");
            state.setStateDescription("M7FrVZmHSsqKlHvR8bmIElQGhLN24DLjSkEEBR37HRADq69YUB");
            state.setStateFlag("LHHCIGMldOXkkF6rF5eSY4NVllhX0gg6l7Kk4R8HcpplQbV9qK");
            state.setStateName("4EwjrbVuv3A7h1gGLH4sIy01qu8xYa1MeLcD4SA7vSikJN2MC1");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("mevd8D7U2j0g31wQzA1jqrGDOhWOar9Y");
            city.setCityDescription("IG8PJAhOP6752STEaMYQ5U1EURlCpOCEYmTpBSMdjs5fpdg3RF");
            city.setCityFlag("iw0NIzOL8mYz4Bbks8BI9yVGJD82urFoOCTpBVJ5RkF17B8YrB");
            city.setCityLatitude(7);
            city.setCityLongitude(0);
            city.setCityName("ckV0WlhX322sCebU8Al4QfpLmSxlq0ZDUMOk99df62A9mIFg1V");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("hs3e6PIL7MXrOPZln8XeUUhHPeXVGww7fe6snMLHNKosKYrize");
            address.setAddress2("Nzi53pXEYw0GqSBbYZhUJHQdfCgnfoIaoVG55i22K7F0XyifGf");
            address.setAddress3("gEIm0JOiwfguA1ZVgJlmC0fGjTZ2i1SNRRjNAseCZRtOvHtty8");
            address.setAddressLabel("AfDbhGkbICQ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fLSvBBaF1powz7LrvsUhgbJcieH28L3stK6rxm5jmQwCe5osmP");
            address.setLongitude("mgdPSpqPV3Crguu2Mres4icMidQcVib4xyuEJk2TMisO2zkEPA");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("Tr65tO");
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
            address.setAddress1("EgjiIPXUUpLNzawFjISmSPvcqRaDX2ANx0bX5RvAb2UAMxDIP5");
            address.setAddress2("i5Mq4fgltL5qQTigPez96AdreZMJ3AdSbDUJrpTP3WsHSLoxO9");
            address.setAddress3("Q3V2XrqSTdHiv5hUaAjiuGwwMcCbpH6AwA89HxydgycN12IXgU");
            address.setAddressLabel("lKepJvojrVe");
            address.setLatitude("PCUi8E2Wg7Ap4nN80ActPcBbE24GaFXKBnfw6ENBbprMyZ9JlP");
            address.setLongitude("NfWTjGMVcUrOThODn0kB7WBkDYdez7VcNebCXsRg1FuIRW2HFF");
            address.setVersionId(1);
            address.setZipcode("pGaW3A");
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
