package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(104);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("LzuARUeyBDDE5X1rkpmqhmqsC4tkqjj7kC5ZaOchfT9P7AgTtW");
            corecontacts.setFirstName("Bpgx8dLGfAWrhvPICCeVsGZCUOshU9hAGWcFw0O3C05jWDIPPo");
            Gender gender = new Gender();
            gender.setGender("3OdKafzPsFo8Sfb3WcJLyEsEPU0jjx6UsKoNoSXQTPizJrobOe");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("qT");
            language.setAlpha3("lf5");
            language.setAlpha4("0fDk");
            language.setAlpha4parentid(4);
            language.setLanguage("cXwFetUcHNAbFjxAFtrVYAb7CCmZkwqot76WsbBQGeDYc92nNu");
            language.setLanguageDescription("ADqMMzDg0AzQOODzQykCBsZvU8KGZ8GwOZnUrbW7JrUJcXJJA2");
            language.setLanguageIcon("H7FqUEGa1D5BQQiYZFL7Gq3PaKfEjvdVkcuLJvraO8cZKAZcRA");
            language.setLanguageType("wEmpkts6FdjThAwUnzgZlWzG0JhoF2Ud");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("SCxeleE4M6CdSC44czVHTt3Lx7DQp1QRE3WCc83L5pTNLnkOE3");
            timezone.setCountry("35LZ5d5tg1pkctsJOcW41a0gV2TKbcnGde2dXYLBylXCiqKWZe");
            timezone.setGmtLabel("4fNs4xF5zAAwwkpamAnjdu3rKm3BUIj4oOFxiSJgHIjsom346u");
            timezone.setTimeZoneLabel("56XtSr2lSQQdwr4IqxRVG7JrMFUcbCbWk7aEloUdqkgILWt8ws");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("YLAQ216NBYJXvN3sr7d1cGHr2ir7mA2uwyA2hxHukxMnhh7Lpg");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(90);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ZqwQD1RajjEKCpXLMC0OxKrKixdn5d1sMPoif5UJ7kXEZMGEBZ");
            corecontacts.setFirstName("CqqIcGbqI9WEGaDjIn3e38tGSSoobzu4m6NLRnR7yU4BwS3Dw6");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("QHGnmIfZS6a9nOM9mF0gTw77XHoD4DpOvf7ktmaRwXhi5jrVWG");
            corecontacts.setMiddleName("EQFC4Vzz8cNVpi036V8JyCg2k3kUxUiqyM4vFZXjKAWeQELmvG");
            corecontacts.setNativeFirstName("ZvU03pKaN24w8zgsvts45Er3yzTKwwLYjPaZWTlgXy1KpTok6y");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("tEwEYvNLM54BbMhAXOO1W8MkS5n5Xfyndbm2goVUhWmqiQz4NQ");
            corecontacts.setNativeMiddleName("c7AnyXCqjHpUIXP9JHsH0sBaUAy9JpspmzJRGvmp38JopO9LY9");
            corecontacts.setNativeTitle("WNed7Txkm1WGx2RjlnbwdwJVV09HnVhhcfW0h8C0fb60fLNc4Y");
            corecontacts.setPhoneNumber("hf2UaOzB4OaCiZ5pAQ0R");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("0KygHOPNckzW0LRQ11kCCftDSgXXulK6HGLfqs3V3i40TRUMRA");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2443);
            user.setUserAccessCode(10);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("swR3Xfra7Mu9tG5lu7GxOEaRiXngy1SZ194m5STpJF9C6dGmAB");
            useraccessdomain.setDomainHelp("WzmSRldGOpfm8C8bPzJnoLbQY4jZZlOa36NXlN6aLyghvyyriq");
            useraccessdomain.setDomainIcon("L7O4O0mOxUFH9Yf0fzRL5rRafJtVRVNFXd6Tk7s5zcTwPSCe9M");
            useraccessdomain.setDomainName("efT6XQvXmzZDgjvVJVVMYRt4sFpX13SArHCH9zrOROgGZy6wGY");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("tOPZITd6pyHPIvo2Kqicz6WNBOOjLhVxg4HSZc9WB1C7up9qQS");
            useraccesslevel.setLevelHelp("8HHqpkD5u1YcGIYC1eSljU8Ik8Nd9P61iLQFZNIJfq5cqWNovN");
            useraccesslevel.setLevelIcon("BtbiBDPTNQoav1S9nJz6ZaCXRccfLmkARpi8UdMrmKFxR1l7Vn");
            useraccesslevel.setLevelName("OnCLf5zq7QMLWDP1cLvTngl4a0MbR4gYTVLvdLYJCG8ahDjGHr");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("xOesLnE6hnGvhtX2U9jdWjd4XmhQbOA3DgbQR93W9FotAA4CoR");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(987);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("ttaJV5b96aPcLIpeIFIa3UMZMgeFWTxR7FDrvpBZrRAlyEFuF1");
            login.setServerAuthImage("BCFOvwQvIUhOSdmm0jyZ4Q49p7m0kqWs");
            login.setServerAuthText("JeB2Ay8Y7z7UEFdw");
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
            login.setFailedLoginAttempts(3);
            login.setLoginId("TgVvhqs5BPKwA6Pk5hoEoUZlHwDfmNKEWEuOabXEfaqYSqzqMz");
            login.setServerAuthImage("9tj4mxez4haTbAaF11Kw29AMRCt9dTJl");
            login.setServerAuthText("LcwJ257qYqKCS9iP");
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
