package newproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newproj.app.server.repository.CoreContactsRepository;
import newproj.app.shared.contacts.CoreContacts;
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
import newproj.app.shared.contacts.Gender;
import newproj.app.server.repository.GenderRepository;
import newproj.app.shared.location.Language;
import newproj.app.server.repository.LanguageRepository;
import newproj.app.shared.location.Timezone;
import newproj.app.server.repository.TimezoneRepository;
import newproj.app.shared.contacts.Title;
import newproj.app.server.repository.TitleRepository;
import newproj.app.shared.location.Address;
import newproj.app.server.repository.AddressRepository;
import newproj.app.shared.location.AddressType;
import newproj.app.server.repository.AddressTypeRepository;
import newproj.app.shared.location.City;
import newproj.app.server.repository.CityRepository;
import newproj.app.shared.location.Country;
import newproj.app.server.repository.CountryRepository;
import newproj.app.shared.location.State;
import newproj.app.server.repository.StateRepository;
import newproj.app.shared.contacts.CommunicationData;
import newproj.app.shared.contacts.CommunicationGroup;
import newproj.app.server.repository.CommunicationGroupRepository;
import newproj.app.shared.contacts.CommunicationType;
import newproj.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("JWwKlXRLVGSS6wJZs5flLyZzaEjgJZOH6cGXr17UoFZFabWFaI");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("OW");
            language.setAlpha3("BHO");
            language.setAlpha4("sF1L");
            language.setAlpha4parentid(0);
            language.setLanguage("ey5LGFHtDzUmPMSOiV0BnRNIxTrqUG1lVlWOzsVQX6w62RNz19");
            language.setLanguageDescription("rXzo5VA3e0vXb7RDk9wwoZAl7mnyEdeST9u0c012EOhF1tNuIM");
            language.setLanguageIcon("sDG2lXNx2xB8Q9GTHLDhT63V7khhatKyPNhMApS9LwZs0v7jSd");
            language.setLanguageType("aSiMAdCEcn9iq6lwVYWmlgi5ug5brV5n");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("p3qNBbrbCoALjLyi19OCVvbTxftecHwwC0tgGt6t4SJZ1xVzCu");
            timezone.setCountry("lqhv20H5O0E37HrewCp8xzikiY0q9dJ4RfvjnSojG9N0EztqDi");
            timezone.setGmtLabel("Art26Tme0zlMIg33Qfny9GivU4SU5BlI7Gjy8h9ApoB62HoaFk");
            timezone.setTimeZoneLabel("QLoPczZSuhkUHekDr7CjAwmkEcmw9GeF3HE6260a5fdYGquWeN");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("aFhKtLOz1t3gxkluy0guTMdC4m7Nt5MwyiQxSMBmqHiVKPUjyb");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(4);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("9M9kIondomABTvoG6C8ghBEgWphn80G8zN85cdpDVhxn5wYIC7");
            corecontacts.setFirstName("bXpzKvtmWIXoBb7yuYnPZ6RIUoxRNNXsEL4ExqIWNfHzsapkDr");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("linG6pdWewcNsof9wZpqMiSG1glD8P9kcHRulXM94CDYjLbxMM");
            corecontacts.setMiddleName("vgOIV33naBt0RGx4BC2KCbTU87W7re1TQ6Q93UWMFtCIriB4xJ");
            corecontacts.setNativeFirstName("abm3m1bLUKb2z2b6QqMF7mun1URx3bkg5Lmw8RNDpt3bpD64J5");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("SzQcle5Hn3k82Ymg4Y0LGdZCnfPo9SefiTw96hwToMBPygiid0");
            corecontacts.setNativeMiddleName("ahfY9D5PnbobdIVxfpRZqs2EnwbyWK6ZEVvXmgJOCoYAhSAeWu");
            corecontacts.setNativeTitle("s4gqq8fwpvODi2SjA9hxC5cJYNLhlnRpoCkIzzy2oMDZ2UES3f");
            corecontacts.setPhoneNumber("K6Ity7wxfgdWy2x1QfWB");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("enk4rQE5muHIig776uCEFtXIlABzWVnkBXIw0GyfWPNdIiKPpj");
            address.setAddress2("Hh1szb2ihh6lGOdljmnXCxvYDEs3nnvkxz7ALFd4S5SPiJIIWU");
            address.setAddress3("hXFZ12znt9VcwGVeSl7YeEgZFnnMqIz223kUzu9N7aMvO9JUzk");
            address.setAddressLabel("geQ4a12mwLB");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("WNRzfm3JXUgox4rOtewlbTrn53FKY2heMXae8lFEKxoTMChLlA");
            addresstype.setAddressTypeDesc("b1A7VB4yTMikemgN3L0ek2AdrLm5AoFJMCmQBLN0KFXb0jeBRs");
            addresstype.setAddressTypeIcon("ES0bcWsc8xuX4NO23qfeldSy249kxyO7JqHPwMN2ZdXOyNhzV8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("NC2bME86PHtqzIxd2SErF63lhVRxxoa3");
            city.setCityDescription("uxK2xdX8kUfz9BSt1QG500ogKKOJg0PkAwiaBb2i8KB3tuwf0J");
            city.setCityFlag("V8qrbBLpLXVmY2fj2REAcJYbv9SzAFZhHs5kgRqeM3dknYl9yz");
            city.setCityLatitude(9);
            city.setCityLongitude(0);
            city.setCityName("W8yzWxmORAuq6CghD31LXnSVTInbwCOmwnc5EVWepwS6BchcTV");
            Country country = new Country();
            country.setCapital("orCMMwp21j2VLkCGBZzlzSubGJtR36mv");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(3);
            country.setCountryCode1("64F");
            country.setCountryCode2("QGz");
            country.setCountryFlag("38WZkBYr3oouIuzruOQm5RWzDCZSXXSkLq1vguBlbpAnL4yZW1");
            country.setCountryName("l1aVbSXr6aUoOHKKJ9PvuTmbESIOqvugo9UGA4rGC9EPkgACA3");
            country.setCurrencyCode("s8l");
            country.setCurrencyName("ehhdAKRRBOfo3kTH3TODtaUFa9q7ehU4Wp2cNQwfD0WKPO6w9B");
            country.setCurrencySymbol("vW8x41mn0OmQqP1uaooyGXKYHSy5w4KW");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("kePa1fYAMxkVhT4a9PhNoHCRRtvYXRX6z8lp4CIRQc3NUc3TPM");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("Vc1LDRnroPwq5SWXOrzkpxG3B0YOyzMu");
            state.setStateCodeChar3("HtaVy4VodcLKw4vFhRnlsqlzHeutFvoA");
            state.setStateDescription("hlysypOz3XjgsS8JhxuCPLcO3wf5EMBrwz6yPAjT9WShQTM6qa");
            state.setStateFlag("TLyFjnaV6j1dlNmbrgZBaaNEgtwLftQrrO7HbVMgTZ9cuzvQCH");
            state.setStateName("1HCdhCsDy00V84zfZbq7sjLuipjxUJEOGE1bCTCt2cnh9MssZN");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("aqOgnZMRxqxAA01UadWSfB0XLu2fMF5U");
            city.setCityDescription("RXzCVZjgew96r0n0s26eTYX4CxOhl7mUkUvrBZ78HgaB4UwVHL");
            city.setCityFlag("dfe83KquNZA0FBFAs5pbabMTFnh5vjljT3Rx1vknpNOXltDded");
            city.setCityLatitude(5);
            city.setCityLongitude(8);
            city.setCityName("jO9HJxBMy9iQepqLdQIhQYqzbWb8Tsxugmbpl9qh71msD0emiy");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("NoiHKD2gesPzmrnB7Dm3IbC5nmIGNIEBMv86EVCkc75ZfjFNZk");
            address.setAddress2("dYVqMiQIKTYPUm5maB3nhYABQwbLxH8o3lkyAudfUqFGgvy0yS");
            address.setAddress3("KRc0jqo3t5Ylc9MhiQDASRWzn6NuOQGjcASv20WawAmHnP0DHU");
            address.setAddressLabel("f7sgd4hneZw");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("vfz96VEypDWU56aSqdjJsDynqXjYJY794OXfTztaezoWahzirQ");
            address.setLongitude("4xNm4w7y5gH39MszhHEJecVhqslwaiFFMYgOMGZhb7zMm1nPlk");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Q5iRYq");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("qe5");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("4qWwRiIqmjlWIMO71DTJLallMM1zkmIckESs5AgY375WxUrO2W");
            communicationgroup.setCommGroupName("059wisFy6uNdMvV005koMq3Nl35JYdqQBA5k5uYfeV5FjMntjM");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("TsWGY4jIZTWfn2jeb8sIHV1VjiXFOcKvrN7LU1rWk1Rc55Ok7x");
            communicationtype.setCommTypeName("KOyVDpaqEjc15n9v7uZplXupjwmwIC8al81hlmJ7SZDXzDtvMU");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("b3U");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BrBmy7RjcOM4l7k9iTCPDXvuAvT5mLTVKgKLFYQnKnLw2S1NJs");
            corecontacts.setFirstName("6wpR0pXOBkF5fZGq0JOOy1asYDfTokYJzpuRlhztRYBAGQVC8H");
            corecontacts.setLastName("xo1Jd214Dw827MizUCA5KmYUQC25dVNCnTsMZE8WkA4grgU7Y9");
            corecontacts.setMiddleName("bnrohPKrXQ9jZDUb9G5JwrYnQAS6lesRFDWMqYAZ85AJCs5uUV");
            corecontacts.setNativeFirstName("BEqQK78wX5Yp9fTtEzGuc687cLjOd3Wc2D0k0gD3a4aqVfNXcM");
            corecontacts.setNativeLastName("23ueHQkqjQpAU7zB43bBDbZAviJIW28MAPKdlIEg2g4j8IgBfu");
            corecontacts.setNativeMiddleName("FwPVZ1cJJ6E1hVSZGmPftdrssWK9MaCSRWa7WyN62DbNQoNaTT");
            corecontacts.setNativeTitle("AGlIf5C9oCEnNmVmDZnwkKaxAStmYN5sMsfz8zAKpWyeDoCJYP");
            corecontacts.setPhoneNumber("J45PeeY6uq1FiSXFPJkc");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
