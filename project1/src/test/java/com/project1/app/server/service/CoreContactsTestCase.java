package com.project1.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.CoreContactsRepository;
import com.project1.app.shared.contacts.CoreContacts;
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
import com.project1.app.shared.contacts.Gender;
import com.project1.app.server.repository.GenderRepository;
import com.project1.app.shared.location.Language;
import com.project1.app.server.repository.LanguageRepository;
import com.project1.app.shared.location.Timezone;
import com.project1.app.server.repository.TimezoneRepository;
import com.project1.app.shared.contacts.Title;
import com.project1.app.server.repository.TitleRepository;
import com.project1.app.shared.contacts.CommunicationData;
import com.project1.app.shared.contacts.CommunicationGroup;
import com.project1.app.server.repository.CommunicationGroupRepository;
import com.project1.app.shared.contacts.CommunicationType;
import com.project1.app.server.repository.CommunicationTypeRepository;
import com.project1.app.shared.location.Address;
import com.project1.app.server.repository.AddressRepository;
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
            gender.setGender("3JfCcCydIy6ay51pjMA40OkTd0Ic39TZZj6j7qGWY94VoxCLVr");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("t2");
            language.setAlpha3("6zR");
            language.setAlpha4("POTV");
            language.setAlpha4parentid(1);
            language.setLanguage("1gW3m0w1EVV6B3gPIuz3Onx96tKdCQpTpcglz1qhHz4tlrJL2z");
            language.setLanguageDescription("lPDFcOkKQYRgSBWMnX84fGZblDJCGqTGzLfgaYGtGWpnBDMbbl");
            language.setLanguageIcon("aPQgeySMKVyHJa3ZyN8O3QDIU4qBiCxxVU8ceEjOaWUEdcGiMF");
            language.setLanguageType("kcmA0oChgEJgjW5WTVMDwgHmqXQ8RBna");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("RSQ9JFiQJHplNpvdllYwaTuWZNju1g23VvShfDdkzbLrYqrt2b");
            timezone.setCountry("2F30WLHtSkCRp43P9Ijq8hMshQZmMCQTrPIj6ThWYErlW8SDVm");
            timezone.setGmtLabel("dkKdAWni7b0wBaiOH86x3BVrUycXCpvpRVaFUWXMJ59HI3FX2b");
            timezone.setTimeZoneLabel("KUcbLPBGgfeuGumd90vmkMXy4FuVG4Y6Tk7xNG9PhbXk3qcEtG");
            timezone.setUtcdifference(7);
            Title title = new Title();
            title.setTitles("rJEr1AjUVhhnz3i0lmDt4U8eeCaTq6Zk1lIKl8FPwaatyePelF");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(120);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("HzhEq6QvCzhqUzdnRegNDnWHFtaZEpTC7hyTXq4WqW938iaHuD");
            corecontacts.setFirstName("Zxi4DCoE16HEzEAPHgvS4xawF1ZomW4zWKirbhBPbtkIY2mXqB");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("VnFJzwBm8T5ooYI9GgFGG9ZXhJS13zDcBkWfk1TNYxx3zxpcKZ");
            corecontacts.setMiddleName("KX7NcpjBMZe9WgjeRg793GSXnm6kOYbN3zTiIGDTVk3uB8PjaU");
            corecontacts.setNativeFirstName("cRRpXQXTDzHyguuUuh3pQlo9MWg5o1gB1eL09V6ez1xvkOR1uB");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("iwqbmhVp6xJed31X4B6EuwthRBNnhWOBgKJyvnVQpKrpSUdyvX");
            corecontacts.setNativeMiddleName("4YZOLHeJ4pcR9iaPR7AuNG4CySwP1ZU8hJACuIORI9lHsSd8MT");
            corecontacts.setNativeTitle("RiqNLkaQGhAD5ia5EPTQaM4NWGEvZQiKq9ItLaSKLbWcoR1zO8");
            corecontacts.setPhoneNumber("Gh0QaOMCpIzG4lWecEDv");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Rbw");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("gqazYGU9GlBA1GXiMFsx53BI7bXOG51RzrTKg5ijOQFiMlwqvI");
            communicationgroup.setCommGroupName("xjSAzU34XCCX9tVIH5qxSbUvi9C43cAKBTaWQ4oz5GMxqCtS2h");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("yJC17JN5xzKeabOq3VFS0SribKl2UKyyrFxn3vuaOVA0jsrYpk");
            communicationtype.setCommTypeName("3BFygFDxVQbnHyWiDFtOpi15QrEZcOCl0SLX4bO8KqfqGOV4yD");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("5tW");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("APULWlg2gnH0Jx519GzGjxnvgoVvFCfDNdXxsl3rL7wCSoz8Kw");
            address.setAddress2("mRUilwVGAT5A4AggC4GhFpgsjxtClfFGaWZLw5aQWCCKw989K9");
            address.setAddress3("tZZFeDYkRJAQk9H2CgQjGfNEe2l4oi9w3FDJ31DxQKSbqO8ycd");
            address.setAddressLabel("e4gtim3gPRc");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("QjCItQkm1speP7tg2qASen2qXN8Q98rz86p0aWnJAiqkfNFrQy");
            addresstype.setAddressTypeDesc("jcrpw0oq4aJkQNKsCXp6HQ5VITHw9RyTH5SzTEXvInBvpZ2rv1");
            addresstype.setAddressTypeIcon("1hL8uQ61M60VjXcARNoLVGJZWKCq7nLQfYnjKai5SqDXNVxDR2");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("8NVJCfdu49t4Sqcj0DZcmj01ebvXtF0T");
            city.setCityDescription("xy7Kaj5ru5qQMbDPTN3vbMTpakJXKoww6nkVnMLtIk4kIxm5SP");
            city.setCityFlag("Ckt02FG0g2pSafANmOh0invrJwqaex8XcT0iwjZJIf1FdVWPkl");
            city.setCityLatitude(0);
            city.setCityLongitude(7);
            city.setCityName("d1eYMoiNIEt962rqbSo8TCeWZ1tl8jsvtPOwEsfptbR8t5HZE2");
            Country country = new Country();
            country.setCapital("DN8x6xa54KAA9g0zyT9HbAxyxtxto9gT");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(0);
            country.setCountryCode1("ArI");
            country.setCountryCode2("sRH");
            country.setCountryFlag("M9eJUGSHT77fGJVHwSnYCq4zoekoIrq6Yew5xKqNUIySwwm74P");
            country.setCountryName("gyPbmoTuSdaaP8KgujIvsSHM2xAT0ex5wvwgLZxvO8ngCSP5OJ");
            country.setCurrencyCode("Hz5");
            country.setCurrencyName("JPnVw4enk5I5Ygt8VlKq1oPWerhse0cgGK1TdvnOOVnnTOaIn5");
            country.setCurrencySymbol("zYqmXl9bBfEZvxmeqzQYf21bxlmajOqk");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("LWxG0PyzSgux3nJWstaA5ee94RzoxaJSnLoG0NEtqy5xe7UzVZ");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("k0L9AAMh1yLdDAko3fdyQ6ZtjN7LcF15");
            state.setStateCodeChar3("L3TfGN9EOvJgGd7V2A2i74ApOLBbc5ka");
            state.setStateDescription("mLKlm2e4zIHX3TJQLuCqkBEgasiC17jxjxBqJseyCDTnU6dVMa");
            state.setStateFlag("15q9wwHWggUAIj88RiT59O1o3dJG8OB0NcmstKrJyPgS7U1z0r");
            state.setStateName("cHdqsk9RLPByXT6Zpk2E4jpJCwJxRxMOd1VkulguMk26YI8g8D");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("FhrGNt9okdYKDAhyLNSUkszNu7NJHeRQ");
            city.setCityDescription("P9iaPKtdYIsIScIAXAyQ9nSEoWt1HFVA1Bkrkgtms3FebYf5lG");
            city.setCityFlag("GHEo38QJAwTAoKKpmEhYEQ78bAg3dNrXTp96cXCjO7QuyOS79G");
            city.setCityLatitude(11);
            city.setCityLongitude(7);
            city.setCityName("Ys0Rd9M7il5MrAUc3rZChZUqoLTagzrTrux7ujZ0lK6k4YMTEF");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("QpN3dHbG71MqwILQmPy26g3Q9TFLMfibhej7OCKUieUPRsbuM8");
            address.setAddress2("29BvdLPX9L6jZOuygaPgt4xEf0nuvlBiMbXi4UUXuDOUcrX6Gm");
            address.setAddress3("yU2KfAP8NUnC8ZJlTmuCd7LrSwKrlag78MmbT6VTGEZbKrr6DS");
            address.setAddressLabel("2352SAmYFPu");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("hiUvBI3VzD2CYXmpxMhtwzUDUDROlJxmV35F7KVPfGfnvUJt9X");
            address.setLongitude("c0ca0oJHGoW1GBkH0eZNvCLekfYDDVlUff5m71tEqUk4SGWpib");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("LRFHKp");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("iFXedltDci56ktbup1VczxBHVnvhizk9xAALWPL8yyz0QiOgx6");
            corecontacts.setFirstName("54gcmbsWk5igvjFRgs7f1J9WKXKWAVKkGlqsg0VhVbC9A2Ikzz");
            corecontacts.setLastName("FI6uMNiQBZ9OmuW4dr9OQaniKggIuO4nhmB0seP0UxKVZTbowR");
            corecontacts.setMiddleName("GbI7VTICvgRu4AbRz3xxslcfnq39ulvOZB7wv6hVhDdpVEUz9U");
            corecontacts.setNativeFirstName("wbEd7s6HYbn2DSCs4HQq7O3MkmyqejojIZbwmCWCCOLAzuwdf9");
            corecontacts.setNativeLastName("sOuozhGtbD8T8srqRJNaKi9HT1SeJT8emlUtgupZdbmtLKd7po");
            corecontacts.setNativeMiddleName("hB0Il5zeTOok3ZnmnFYxTLF3Ll4L8uGLQTcy0EmvBSNIIpDVGn");
            corecontacts.setNativeTitle("xjYOnIFH6NMGy9Hhn4kret7iiz9h5urBuklvPhdoRQrcmj3V5Q");
            corecontacts.setPhoneNumber("i9vFH1v9iShEYZxEUGOE");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
