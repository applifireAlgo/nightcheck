package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.StateRepository;
import com.app.shared.location.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

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
            country.setCapital("2TsrCVzdhtF1gyiNc2hVrsAmDCnOJIsm");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(8);
            country.setCountryCode1("Qwb");
            country.setCountryCode2("V5b");
            country.setCountryFlag("nBGYqVGEni3Ybyhppg6DPzbKhBDUgYNVFCtqvVIpgFYoOV6eXn");
            country.setCountryName("Gpi4KStIkONYgPsrgF0Vkw8934HPxLNcl4TBhTwCLnN4nxtBdX");
            country.setCurrencyCode("ezb");
            country.setCurrencyName("tHfmMEoj8C8cHuc1W3AkfBqcuukGIIZVzCYjd14tdBsgoZJ8Xg");
            country.setCurrencySymbol("eQ4qWexAzEnBzF7IFSChXQ8kT5w8a4Fs");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("D9q2S5Mk2dSTdJhVVBveMc3C4A2yns6MXiUjs5lCGvPvbnR6zJ");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(6);
            state.setStateCode(2);
            state.setStateCodeChar2("oUsqXae1yI06twFbdzUbO37e7BewGuGM");
            state.setStateCodeChar3("UVpiF6AGiP3FFXlrbTWbdCk80aL09ijA");
            state.setStateDescription("zmPEDrHW8PNesysBW1ecQP9KiGU2AwFWLqrQ9KIR5rZaW4hxZn");
            state.setStateFlag("m0KFpEoBMoKp54b5ygRzYrh8zuuh7Suu6IlD445EOjmu6pgpOh");
            state.setStateName("ffmqoSEc7sQ9V8sB2tjG6JqoYbHYawUJB3L4m3I9D8oImSOpMO");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("f8YKXh2XwHHC9ruzBYJbxUBloFDa1jfBfCTZptppmAECD84yb5");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(9);
            state.setStateCode(1);
            state.setStateCodeChar2("pmg718nNU3poMq2RnZedstZqW0rAODxz");
            state.setStateCodeChar3("XVfpUU9h3sp78AX9cUsKpWbBaOHcBCvb");
            state.setStateDescription("NnX0V7glmEltVUFWM8LdBJVxLhqvvW2rfkECWMpkDr4vFAa4CI");
            state.setStateFlag("XqTSFiGNGyXUOoApO8b4fc2jiezJFj8w88fmZynG2WFpvCPLzd");
            state.setStateName("LeJ4z5NKQkScHMc7RGurOHKOM9kuGRVRVqfOxl7oc00l5ZDzcZ");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
