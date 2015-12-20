package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.TalukaRepository;
import com.app.shared.location.Taluka;
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
import com.app.shared.location.District;
import com.app.server.repository.DistrictRepository;
import com.app.shared.location.Region;
import com.app.server.repository.RegionRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("m1VUf8127aqysn609rmEZPnI0tZEIYgo");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(9);
            country.setCountryCode1("xEq");
            country.setCountryCode2("0iT");
            country.setCountryFlag("RyUYtj6EsjpXwbBOPor7aCglch4cLHwITjUSbnYUCgmYyd83Tn");
            country.setCountryName("cQlkVJowry4Jo66J6GCpf1NGEBEzzo9CAHeftMdCMDfxU9gP7u");
            country.setCurrencyCode("BVB");
            country.setCurrencyName("L2ocKV7eaBNkgdmBauvLuteWuRM7S3SOgSut4lNbr4CC0AzdDr");
            country.setCurrencySymbol("Fc5aURCJAWVwprhOLYHkgd82KxbRGCDn");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("hrkGz1jJF0OYwuKXLSYafEVsgEEcMo6d");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("gz1OfRY8uSGuuyRaIrwx7iu4uMRsnYOMiwHm91HUju1QrE2Uk7");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(6);
            state.setStateCode(0);
            state.setStateCodeChar2("wnLygT56DK3KLlgD6okfbpi7yE6GgxB0");
            state.setStateCodeChar3("IZboMhs4DrXypWY41LFJVOF3u0DW5NJX");
            state.setStateDescription("WhOqDFBelE1DPl0KiUufpD3np1O5LGfkWEHsjvdKlRIHTRJdnp");
            state.setStateFlag("yDGEiiqoNrbbyPehc04Z21BlFouqq38HYvvQaaKRwps2L6KQMb");
            state.setStateName("XChbMKCITtjJ5PABVfW7NY5QDv3Kkk6cAAmAWpxZlzMXpU74PT");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("n6EUujYVXzoFUFCfDyuPJWurwJZrHT8E");
            region.setRegionDescription("GXw1BNT81QlZFF7Z3C2C8jXRpvYXheeL3EavBPcqtV1727jBC1");
            region.setRegionFlag("NmCdYvwZTBgDpkg9QOGPkyb1uYpM1Dq4t3dIfmZ4VVS6edXM2O");
            region.setRegionLatitude(0);
            region.setRegionLongitude(5);
            region.setRegionName("ZXpE0dUPCSFHco5EQ0o4nBtNGtPtCm4BMrvaDiNnMFHryXVKoB");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("guUPmeAVWGgWpJeTYhJ3ocUtqoSHIf04");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("WfrLrScwmYgquk8DayzrZYLCvBSvG49ztnrgEYvRdqrWQhYDp5");
            district.setDistrictFlag("XghaA9PKFIk9ZuHYLPoqvfnvbU8rlz932Dl6ptHo2coQWIio9Y");
            district.setDistrictLatitude(8);
            district.setDistrictLongitude(1);
            district.setName("e0oVbunycxnNmLZuXvg80F8FfzwKA0cZa9c4SmcewKe86REhdZ");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("yTXrzaPiVBS0ciqJFGyrmZe46PxjbwIc");
            taluka.setTalukaDescription("uwifNrV1D7jXUjrRvqgmJ8Lig09gSRLiApUdtnKmB5my7qyo9Q");
            taluka.setTalukaFlag("fbSE5iq6yQLaVVaRThlWhVQj70xUhcdiBp2RJictj2Jgx9O55B");
            taluka.setTalukaLatitude(9);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("RCJBtENK9RNqVjRDVFJCyKcxNsn7gdT4blmmEyQqKwL685rSSw");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("hi1xqexmqTydmQBx9wBv4Pi2mSsoRg4g");
            taluka.setTalukaDescription("CAoKpnVlkJm3g4g0YWvpmSYptUPdFCXP9e7pxJ8CElas4HOnMG");
            taluka.setTalukaFlag("u8GRosVaIWsgOXX7M5mXJNOFMBsx8MJCSnr5DgJ92dmkUIVtOo");
            taluka.setTalukaLatitude(5);
            taluka.setTalukaLongitude(4);
            taluka.setTalukaName("vOONZ8nphZtraY8ctKQRCxFnoERddYLQsfcppkBoteb9NozisB");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
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
