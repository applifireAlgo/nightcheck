package com.project1.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.LoginRepository;
import com.project1.app.shared.authentication.Login;
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
import com.project1.app.shared.contacts.CoreContacts;
import com.project1.app.server.repository.CoreContactsRepository;
import com.project1.app.shared.contacts.Gender;
import com.project1.app.server.repository.GenderRepository;
import com.project1.app.shared.location.Language;
import com.project1.app.server.repository.LanguageRepository;
import com.project1.app.shared.location.Timezone;
import com.project1.app.server.repository.TimezoneRepository;
import com.project1.app.shared.contacts.Title;
import com.project1.app.server.repository.TitleRepository;
import com.project1.app.shared.authentication.User;
import com.project1.app.server.repository.UserRepository;
import com.project1.app.shared.authentication.UserAccessDomain;
import com.project1.app.server.repository.UserAccessDomainRepository;
import com.project1.app.shared.authentication.UserAccessLevel;
import com.project1.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(2);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("na6zyMOUL9QZ1eqQylTXpfhGppH4TXwhWpxdCaQs828C487pjt");
            corecontacts.setFirstName("loZxIzopLmj3bfeJaVrs6ySoPtC2JEFqyiZDVtoiuEME7hvH35");
            Gender gender = new Gender();
            gender.setGender("vH2F1FvPdr80GGvlKlHq75gltoEimC0oYVaKL9U6mZQ71OeNa8");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("vH");
            language.setAlpha3("wpk");
            language.setAlpha4("eTo9");
            language.setAlpha4parentid(0);
            language.setLanguage("TABAxMrV5o7EYDvsJwH6XotPttTu4DMyiDOo75FJgibr2igitO");
            language.setLanguageDescription("jWDFPkeZuCp54c7VPDZZFzqeqlBbsdr7hdXDwdzyaSTXK3CI3e");
            language.setLanguageIcon("rjIs3vrHTByYPrxs4HE4LdBNBstAhrAnJqHlPZy5MWOAOXWICc");
            language.setLanguageType("3ywUVPLBQHX8AShk4JH6Gxs5NJkdtOVL");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("98TD16UBWdZRbmyw2BT8BtIAYYvkIuAIUDmvsGcfwYkOccNLNd");
            timezone.setCountry("D03idXlQ275Wdt1d4XsZDd7GnesqeFqqQS0HQmCelvKdB9bM7g");
            timezone.setGmtLabel("QwRFoVODssbN4x1yHBpb0yUo2ssVWFCnCXyCJpej2pKkiWfe8F");
            timezone.setTimeZoneLabel("GVSKru2uIAB8HgNxdgSm87yKQAXphSOV3BlEI6u0VpMj6thShd");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("uaslasEqoG2StJz5PY0nIodQCWihUg09z8epAAc6Lvu0AuRzzM");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(26);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("jhVe7RnfW2uX61k4oRIA3TuSRarrFo0nLaQxYaY9u3NOM9E4Ec");
            corecontacts.setFirstName("UBS3hoDdpDSLrA7hu9cx8fobpUrJaOVp8zMxHGLFbBeRptMZAR");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("7Mv8sNHpWfrkJ0ummgAB8SUeiEWBrzJgXod86GqEKVDIwCPRYX");
            corecontacts.setMiddleName("thiXzDelbfJkyUVMcCtoHAiOMSpMWnkMGguyB716XUfDF8Z0Ny");
            corecontacts.setNativeFirstName("d4qb2kZfbbe3VkjIO6An9I4TCGnlUfXhbT5yGUEfG4D8ZfPIQ5");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("kQXJqQyKrCd1ioDCNa6wDvHSGgw32KNmelM4mbgAyJ5sQHzJxN");
            corecontacts.setNativeMiddleName("irfoCnzaClDNOiZC02dKNUiBbTg3LWRhjSlYt50epvbslX6LXR");
            corecontacts.setNativeTitle("7xHTybwHbOhLryefYbT2MrMg2Xr7g6I3dl1itgg8wJZT6Pf6Mc");
            corecontacts.setPhoneNumber("s38TeU1GeEriOK3kvgfc");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("4U0XGIBp5d0yJML9Az4pmXZvkTJDCPe2XWG521ljK3U6lYBift");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3172);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("qFhpP4t23xCppyzuHGEH97cl30VBPauBhxb6AaBfcYoYpUasN8");
            useraccessdomain.setDomainHelp("Y01vollRnfg2tunC6wQFzuAu9cAN7rOqnHo8H6qaBf2i1Imdwc");
            useraccessdomain.setDomainIcon("Vmktqr7B8D63DKJiFxDQtbvo752MNbYoouBh7C2xVCrvZzrlKb");
            useraccessdomain.setDomainName("BdFUXAQkqyo234pUynvlNjFzpwr3aI8N2sZqqt1k1PafFHckXQ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("jiKLyIfKI8cf7Wa7GxsARozkRkqhQl9scfti7eHiWqV7o5Va6x");
            useraccesslevel.setLevelHelp("htwvaiXwicV4xvbstKMER3RXmSQhQsuHIgQgHxbuEcAWRtXNgp");
            useraccesslevel.setLevelIcon("ZBIYAB3VJKqgMXMd7rsfckpfT8m35DM2iOlpGK8GZv7MZFFEjv");
            useraccesslevel.setLevelName("kBRLPUOQWbAS35sBQkuEvPgp95FDXGHjYdna80DdQ1hQbynjYr");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("VH6pEHDXdQyEF4v9jF9VNrxyPO8rqTrzxgzSz5QSGQWXU1VeXM");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1339);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(11);
            login.setIsAuthenticated(true);
            login.setLoginId("YE2vCRuLWts0bvdelt83ypfJ8hZex6vzoDeiZUFvCmSgvmfebs");
            login.setServerAuthImage("AQPY2wkHITN2EZUep8NEUMsN9Z0ZYkmC");
            login.setServerAuthText("LpG7XU0XPgvTMSvH");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(0);
            login.setLoginId("ssGH2S5mHpvob7c37T22GENoTj8FfHaXVfUoVXym3rszQipX8y");
            login.setServerAuthImage("67biTvjVR5MKiQoOoc5eE0IFMHAbnMAt");
            login.setServerAuthText("xIOETTaBoW2Lym09");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
