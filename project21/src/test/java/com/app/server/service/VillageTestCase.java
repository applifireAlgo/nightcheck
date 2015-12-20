package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.VillageRepository;
import com.app.shared.location.Village;
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
import com.app.shared.location.Taluka;
import com.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("fMLkRCbGHFT1Fmw9WMMniUb9NTcq7FaO");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(6);
            country.setCountryCode1("Qmd");
            country.setCountryCode2("mxa");
            country.setCountryFlag("tdjiA7wqDD2uD3V1bFXBCwMX1vuZPXLrHjixtgeU3xAvCQ70j7");
            country.setCountryName("0CLdXPDzyUvjz2KfOsZ3bH3urKxVs354rbV3Kf4KGis3GWEyZ8");
            country.setCurrencyCode("kUz");
            country.setCurrencyName("7tDwR9QWmFcwDFa21knrNoTvw9rSGB38CYU1e7vekpylss89DJ");
            country.setCurrencySymbol("AqAWBiOnY2pweQpSAWjH0kh5XVzst7Q0");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("VXAM9bdmMT06Cr6vIcTBpclJg3rJQbqV");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("3IdsOLmNrqAyEFIf4Ro6oNEwg8tWxdyyVEkRoV6uMYF1JYf6SO");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("OdxaZDYgNpAhlOYt9QuOb0Q7dbPgKnEd");
            state.setStateCodeChar3("BmVuHev7vUbhn0lgujyGPKxt9qzg0Hkn");
            state.setStateDescription("aDNRledw3PbD8eifuVD71DNBZt8jQAboJNjlmZUTb60gmOT2LN");
            state.setStateFlag("u1gcHvDlGvsDLolNcNQpqIZrrMpTuxrLU4nZF16S4JpSAIMRqs");
            state.setStateName("eBqq2bPyhthlZIWnyLSEgKZzWskPUSD5VqCdbAUL6MMpVOy54c");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("ass1TAdAlMcFLWzTinDXVyQmOicOXWTU");
            region.setRegionDescription("ZS5SARpQByL44Mi5gQxsdgQh4MgiANEp2LNlKcMKDMcgGztdqy");
            region.setRegionFlag("jNPJmmwk8FjstUNxoFvUGABWIIOIYAKrvblPUIlUMtkiocH0OS");
            region.setRegionLatitude(5);
            region.setRegionLongitude(4);
            region.setRegionName("zHwgtgEYkLtmOogdfPacmCbgDKPKlqotjb0nPsD8ztVyBPwLI9");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("TaaRH7S93O5zPL1T9GVQzhwdbR4obqn5");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("8ubsCEfnfAQ0BR3j2PayAkp1ZIbTU4iS7IVugN02ivW20rMj0n");
            district.setDistrictFlag("KNAFxduKDeJRjpwoYwX1ExriIKofUKqakmFODKgSfaQuQUg7Jf");
            district.setDistrictLatitude(5);
            district.setDistrictLongitude(5);
            district.setName("PTWz6FV9myPlk3t9pYNSDPjV8dsY4Qhuk0YQ3wcikHTwd5Fvkb");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("zoIZOiN0rZT4xijVkPE7hnOjTloZPi0n");
            taluka.setTalukaDescription("HUEM27bRGCzBcxzVF3T0LdvNC9uGAKKYAJcZmeR7FpTf1xudHc");
            taluka.setTalukaFlag("8EXQ0l8gvLs9jezxZU6Dk5MGDiupM6Oo7F8MbmFswnUlMlQaJE");
            taluka.setTalukaLatitude(5);
            taluka.setTalukaLongitude(2);
            taluka.setTalukaName("3JCoDzKBMXWS2f5UZ7gY3BLA78wnEKwnw3ZXy3AqyrdDzkueXE");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("EsHc6K2XfrwcSw0f3x9k5R7aykXdHPsq");
            village.setVillageDescription("EEPmJHbIBIKb5pYmVRDqMYY5poCkqz5buFdXIBb2zpbhWS2GVG");
            village.setVillageFlag("CxFgF2eKyNfavZDtHpMNvY1tqMSjRmVXI5gfpiFkQU7EujW7tP");
            village.setVillageLatitude("wd9w3RrcESi");
            village.setVillageLongtitude(5);
            village.setVillageName("xwvhOvXfA1h9K23ZkI59Y9SUZZQKCXpaPHLlFbqC4MIwkg96MY");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("2jqJkHPu4NJU287zI7Sq4XW4efhP0Dui");
            village.setVillageDescription("cMhO5z2zfMfWFHbV3ppAuITo1bIR4nZQsM4MuzuxQQimaVv5pB");
            village.setVillageFlag("ayGy8rLUtVaVd3d550pcVcSltEqj3jY5aqJBjc14oIrFjlouYH");
            village.setVillageLatitude("Dtnh21vWpM5");
            village.setVillageLongtitude(10);
            village.setVillageName("wRrGsQrnWcTEkBwlOoKasrsL14EEFWX7fiU6HpsOnHzVXDPz6w");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
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
