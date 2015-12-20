package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CityRepository;
import com.app.shared.location.City;
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
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            Country country = new Country();
            country.setCapital("ohxoh4ItYojlxtFan6y4fzt8J3hC3DRZ");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(3);
            country.setCountryCode1("v6f");
            country.setCountryCode2("Py6");
            country.setCountryFlag("jKPzuqy6B4qe6JGXAQdVZ5adpdc42V66t3k2Uy6bOYNRca0tJN");
            country.setCountryName("wCzSrAlydL76BnRfnZ3K649MLUFPyGHg32QIb3MbDBTVeOrUHA");
            country.setCurrencyCode("Jxo");
            country.setCurrencyName("z8IudTz2d5fphYLvo7miFAbEwFuX8di8YwLDr7SBme0xMCihux");
            country.setCurrencySymbol("KFB2zrQENr1FUdzpDMrhdnF6Pm5kJtYv");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("5IP1MUWpzYPM4kMMa7WFLLFCQx8r1Lo2frSKIV3bFMTJUNJnaP");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("mLdukOoW2gbo9x3nWdeqGfyJiy5AYvWw");
            state.setStateCodeChar3("ZaYEAnXuB5d7yjVjhR5xfqUCvLoGdsGx");
            state.setStateDescription("pmab9n4ZbzurNBYzE8KYgt7JV4YYcTgGjCoAWtGX9D3IZgtFNT");
            state.setStateFlag("YrsqnndKUUfGgrvHj2ukmHXPRO5PtAqcVp797UocOZbGSPJBi7");
            state.setStateName("OdsnPpTKGyVoAVuFBRF8lpFyqUCuK8GYGIkyhx8BYazqp82tKg");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("4M2ZPpmZnjAAL7etCLogxhBw9FXaH7kZ");
            city.setCityDescription("bVLf1DykPiEpvcOW3ylFASNElQJb5XmZZf5K7K5QXvYgNM5hhR");
            city.setCityFlag("9lSCgcObBnGgyxikb8ZbKkFxuW82TP2KdW0j9NUkw9SDS3OpCS");
            city.setCityLatitude(7);
            city.setCityLongitude(4);
            city.setCityName("uCgcu2nljaiFGIbRoArguVa8wU1IVTeJVWrOUlyit1VlTvNN7X");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCode(2);
            city.setCityCodeChar2("aACKWFq14P2YleVxL5I9iyFTGgpjIRBv");
            city.setCityDescription("CpnP08asZzrp0jYhicyqAxs4gSA2bPxmn3sYC6jWRWipUXRDm7");
            city.setCityFlag("X5KAFHZlPjjnfIkMVz4Mn0gmDQADlniWMSkGqPJP0SdzfXcj9N");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("jSp7xb8M14djSWxKqm1SArTNUCKOPSodAJUacCkLSwTwLIBY5O");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
