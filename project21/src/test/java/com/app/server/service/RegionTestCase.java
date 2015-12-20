package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.RegionRepository;
import com.app.shared.location.Region;
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
public class RegionTestCase {

    @Autowired
    private RegionRepository<Region> regionRepository;

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
            country.setCapital("R9LwoBLbuZPtKcJgaLaPct7kaGOXpMNV");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(1);
            country.setCountryCode1("RPo");
            country.setCountryCode2("ZCj");
            country.setCountryFlag("vGczcnZuyciACKmd2K2TbO8cw1lr5rUHXkRkgvQ4TjQ5yR5h0W");
            country.setCountryName("feizsUrGKNcUuIfMERwoeNOna8Z5DZDLrhWuzobY7uW4oqbnyQ");
            country.setCurrencyCode("mgZ");
            country.setCurrencyName("rZiL63bGbuSQ9XDU55kCEvpCyFDH3YFVQTpkZEAaCSKBaxPZOD");
            country.setCurrencySymbol("4nENywG4dsIf2NTHVSvAtndZufstCtyW");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("614sm1QHg0JylaskNnZfoKpgaPOwVADh8V6RulfwM0TybUsflM");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(6);
            state.setStateCode(0);
            state.setStateCodeChar2("RI7F50u5LqiOB54fpdCEGnHfSyiRzTVx");
            state.setStateCodeChar3("vApfFb9NzEtXKSPFGe3xbmWMwduQZild");
            state.setStateDescription("PQrIYIxARk4E2Z8pzLbdGdC660fIGUCCMtdPttrjMdQQ8MPN1i");
            state.setStateFlag("OfTqofF6dG4JuM86UETAI9YnTx05KpnD6ws9iP0aGhwd5SfM0B");
            state.setStateName("CnBgNipzkI0XdFvNEpVWdbS4EEH3DcEr7Dh2K5lJ6ufausWauI");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("916jepaA4r1nZ3ktZJmGZgGIMn8ykyIn");
            region.setRegionDescription("U6eYcN9ouhQOaUeW2rGbcO1v4cde4Zqk7UCGURUXq4ZQY5cTog");
            region.setRegionFlag("XXS9MqtBvlaSzsggHhgNl3DddRHQq8T2HkTWwTQPNca5EvuUhR");
            region.setRegionLatitude(11);
            region.setRegionLongitude(1);
            region.setRegionName("uGMuoOMVJNZH2yZbz5GUi5tpgUwxJLhhPYJRHCQsveIlIjZx3o");
            region.setStateId((java.lang.String) StateTest._getPrimarykey());
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.setEntityValidator(entityValidator);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionCode1(3);
            region.setRegionCodeChar2("Uuk2fvmKFvo9pV9AQCxmJFW3N63CzOhf");
            region.setRegionDescription("OhNdIxNJv1C1dfyPb5WPzpfUsQCIERXqq0TcnCDYOfxLWxcwzI");
            region.setRegionFlag("j1zPOBJDMvVfE42MQIKElS9xRNzCfan10dHT3ksNoGFp6LXxMr");
            region.setRegionLatitude(10);
            region.setRegionLongitude(2);
            region.setRegionName("xjNzbJrY9iPtwWDkztAGU9OuyqwJutEcuiR0Uw3AwldRhiy1hZ");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
