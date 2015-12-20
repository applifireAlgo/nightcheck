package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
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
            gender.setGender("mXDIq8gfs5cWcqyO0RoAaSyUowI28D5ygVhP5vvNxfYqpQSWRN");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("uQ");
            language.setAlpha3("8w2");
            language.setAlpha4("yNaM");
            language.setAlpha4parentid(1);
            language.setLanguage("yKjEMhW17N5SdPCgQGWjcRHx2Yguo8aMOXaAtx8Dc7jUYdJXQ1");
            language.setLanguageDescription("puCvZuIYFQKuAVCtDA0IU3G6DGGv2NiPhvnTuGp7kyzb1YZISJ");
            language.setLanguageIcon("WPaE6sdQpqSH86muRV56jDg8YeTlGTAb9BdT2lKaIY0EdfOP1r");
            language.setLanguageType("ofeYoYKstWpueYyImnokeyTpnrtX1KoH");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("8L1JgHZvbU9KL2bqeCK77n97yUxi2gx16rngVuOaf6zq2HR0Bu");
            timezone.setCountry("VK8ZX9NeqSxl2wowptPDsFWNNEuY1rm2JDNDLCBzqQfFlk77FO");
            timezone.setGmtLabel("dKGsHSxGzaI0YMpEa8Ul8bppGk7w11VKcOCcYVtHZmAUHuieNA");
            timezone.setTimeZoneLabel("fqgKTz6AVCokbXa5bJbLMTIaqA9GAdYvFNw9Qmp93BapZy2JWS");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("YyiK4o7xOM5KSer9ZSsG8SOCBy3Pn1maYcJCNRv6AAsy3KlDvd");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(58);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BKpoTCL7c8yr6BbtK67htGbiCSfLB7nKric2elWaLvf4Y2Bc9P");
            corecontacts.setFirstName("LN8o9kerNKhwJ4bMrFtoaf5EuPGKQ97X9z4WORIRNtDJHNz6P0");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("2ViJ2DavWP1UnO6E34d8GjlSHUE2PaoaJoARaXwBtOkGynLOGv");
            corecontacts.setMiddleName("uFBM8yDv24E9H8ZcVRzxIqA8g0JfuIAFXZkq2umrwNopZYANXM");
            corecontacts.setNativeFirstName("nYtZYhU2wIuc9xesZkpmbteMB3JewAL8Il9zDDqhbbMtihk42Z");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YRcGTEYSWf7HkWEGxvgzp4DV7eaOQ9IrephXQls8NA0Kah4MR3");
            corecontacts.setNativeMiddleName("JsGvryvUAaqmQnYSMEUkh2oCrruBj1hxR8rS58YqVQqhLMBrTZ");
            corecontacts.setNativeTitle("7Riy4ByW4GbxvQlM0nwYK9iISsQWs6GZ9BYZUva2h1pvkzYOKx");
            corecontacts.setPhoneNumber("GzOsBWfv0qzThkVSGGoN");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Rlx");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("J1qEd4jcvcGxecfNbDPlELd2hvCdTZZW97zXrWxzDEz7d327iD");
            communicationgroup.setCommGroupName("iJgdW0PFYOFj47ToZeFqmeQcEF7VeKr8eE5v7gTv5xL7FKgDvf");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("lN1k6BDtolifqPJmmmtUNHX0aaN4jYtSF1QOQ8Reqn1MOnTNpc");
            communicationtype.setCommTypeName("y8sanUsQQu5RLhHv5pJB46FDi8mO2DZkdH2SwBNv9D2ZXM0T1u");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("TZK");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("NWMLp2YwK86vW3XFbj2Nz7TWk72JgPXuFwmqSflpHH6ymjiohk");
            address.setAddress2("QvmU69ztXIq1cbMMchdCNYjsjgkBBtcOZ1Robj1jj6rf9eAOwB");
            address.setAddress3("78RIUwvEQDNftDIWitvOCkarqDOP6EjvG9I8DRgvwn5HoFd18R");
            address.setAddressLabel("mhMEeuMuuxb");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("KtXSa3vngxd6NafYUf9CAmVBbCRigzbtarX6mJPLTZbNBUiOGq");
            addresstype.setAddressTypeDesc("AuxrN4rcXIuXG17bGUkLAg6L9GYTwHYhTDD1M2FniSTnzJDNw8");
            addresstype.setAddressTypeIcon("LhEqDlHb9ochbvCQV9y9vPj8z8BSHjxJeMvzYdyMW3OXrhg9ZI");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("TChxfqSZyipKBAQ0vmORaa8sjpSLeRkw");
            city.setCityDescription("vHQGv6ENrXvgnpJY1YAHUFseXOF4N2bHrWQA18ZqbKs6J9GMXV");
            city.setCityFlag("x7NCMREcOuwjw8FqNZ2gNZJNuusS4XzRexlghnqzbqUhANjvrX");
            city.setCityLatitude(11);
            city.setCityLongitude(2);
            city.setCityName("p1mo2vdBj1x83kA879UlUka0Zm0FJ8dza1wSitKnT18KJjg8Ae");
            Country country = new Country();
            country.setCapital("TVeokGfS4GT2RGoYqmMoBKOiTcbFQitH");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(1);
            country.setCountryCode1("ZBQ");
            country.setCountryCode2("taR");
            country.setCountryFlag("H8TPXjmDAOD1M6COM02NR7MuxJogmmadGTbS3uJelBesQMzbYy");
            country.setCountryName("SEkofUrgL4jQCP24xkYTaLoccOfRSAJIbgNE0D0ENiJBK8PkDV");
            country.setCurrencyCode("wfL");
            country.setCurrencyName("up3tidyHavSZ4bRZX4EFvSDQyLzRmgy10OFluOWtdfQ1UMUZq5");
            country.setCurrencySymbol("61lH3lbtzlUlb0afExiBA4pH6HFFzzgw");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("LML9ltwvyHB7ra69LaV2EOVFl71ViMJx5Vz9b4TlRMw1ZonBCK");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(8);
            state.setStateCode(2);
            state.setStateCodeChar2("4Lvfii38XsqJQCTtJIssmWFgvyYnpq4c");
            state.setStateCodeChar3("ZebDKshzCf3EDIBnyIb5Uo4OAXP7SWGh");
            state.setStateDescription("YHtq3NB02VW2RNhP1fEGalVnperb7ga2wpFvxpwtd8Vb2dF8Zq");
            state.setStateFlag("3zwNIUocl7YX0W2AM6TXYYUHBdaV2EYS3iKZfu3Hexu1KscoFB");
            state.setStateName("IROI4Nk0Gr3lua05lCRDf4o0hKEu3Q1UUtLwZ5rawtov9BE87n");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("youXGpczSITkJBdfFv6EhoxfiUSPOCtQ");
            city.setCityDescription("H4PpThCq5rSxDuJ67sOxqU38LAEWiClzxJ5f9KfxscAP2g2mJd");
            city.setCityFlag("E5cDGjE6psh1bpmOyxvghV7O9G6AVkRXK9vL5b4DJF1XU9nFr3");
            city.setCityLatitude(10);
            city.setCityLongitude(7);
            city.setCityName("VdjfhwD9O2J1DENQpsFdCFsIH8cEKa4JJzhMvFBDwwHLuHn3JC");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("a33EKBjiFaDnNN6jHEMYqz2HqNZhD8Y9DADkYbcErVr41xgAf9");
            address.setAddress2("5lLd0gqmT0wE5CG1RENwoo0yzlpWtZGH8OcuLbI9okIKNG7os3");
            address.setAddress3("q9w68bJeyQKqQGXV6xZ2hy9USTDnIDb21YiaZOFNfZLht2KXhT");
            address.setAddressLabel("9sOoVN1tK8g");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("cwBcygvsGJM7ELP41KUFPeTb1OjPioDe9SdXWWx7sgZPELM0ss");
            address.setLongitude("U8XaESBLaLWN17cUP3JdcKmWg3gaYD4IHHCQzEpWrW1DbMFZHQ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("5iyUSa");
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
            corecontacts.setAge(34);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("C2TWn7zhvwdKaB1eui1KusQSvuD2PFVc6rV1nxZWzQd5ZeMIwZ");
            corecontacts.setFirstName("zSOgfH5ZTtIdO3U8yrAGW18ekxDf7kGe1tahBlcrs43GPkZdlX");
            corecontacts.setLastName("jU0YceweUu6XcJqdPpuPWaUps0HqSYldjRLKIXgSi8Uv2otZNy");
            corecontacts.setMiddleName("3V0yQkU8SYBAt7QBKHCG45jXVxjDzrY2C919rL0CDBWnnbU6I0");
            corecontacts.setNativeFirstName("9ZYlLdydMsRDadh4RZ67c92xCB4Lgh5qUHxAaRlZmbWeM2pUFm");
            corecontacts.setNativeLastName("guK7u7cvQ6e8aTvVTLnV9kfuPudQKsYViRdo7wEmS9aJ1CtoPm");
            corecontacts.setNativeMiddleName("KvsgphjTJlVjggzrCEbwNX2WFfIqQC25zuQrbZBD0zevvtZzR1");
            corecontacts.setNativeTitle("Exf5Pu0aaSsBfFL8lcUa4awMIZUvrOEKIGv46ixUHVKtOCHxPy");
            corecontacts.setPhoneNumber("GspaweZ94dRqLA37WNKc");
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
