package newproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newproj.app.server.repository.LoginRepository;
import newproj.app.shared.authentication.Login;
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
import newproj.app.shared.contacts.CoreContacts;
import newproj.app.server.repository.CoreContactsRepository;
import newproj.app.shared.contacts.Gender;
import newproj.app.server.repository.GenderRepository;
import newproj.app.shared.location.Language;
import newproj.app.server.repository.LanguageRepository;
import newproj.app.shared.location.Timezone;
import newproj.app.server.repository.TimezoneRepository;
import newproj.app.shared.contacts.Title;
import newproj.app.server.repository.TitleRepository;
import newproj.app.shared.authentication.User;
import newproj.app.server.repository.UserRepository;
import newproj.app.shared.authentication.UserAccessDomain;
import newproj.app.server.repository.UserAccessDomainRepository;
import newproj.app.shared.authentication.UserAccessLevel;
import newproj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(63);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("vIU29TKL9rF4BuEBZufgkvzvek9ppJDlVq8ZQGbGteEYyZq4S6");
            corecontacts.setFirstName("Ci8iW5nujhCiHJ7gX7V2SHJd0TAJpGKTdb4wOqOZXz73mMhTDc");
            Gender gender = new Gender();
            gender.setGender("PQN1yHEJ0vUrh2zmvVg1PsPWEo0ayKAKUW2IQsLQvtkScG2YcJ");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Ga");
            language.setAlpha3("Kb5");
            language.setAlpha4("yWOV");
            language.setAlpha4parentid(5);
            language.setLanguage("AtAEyaYMvIprzEuOT5iCOdgLsRKaoXje4O3jFLW2j0SGUYz8F1");
            language.setLanguageDescription("sIahqVnlLI6iPw49fuXCnU3T36YnJV7t11othtsMMqnWV4cS0Z");
            language.setLanguageIcon("84hH6xwPrbD1CJF5GnRI1a2ediFEm3doZACf1dRBMR88fCU3xC");
            language.setLanguageType("A6dAl4p9y5U7ZsmoDrbXCcnIIr1W7D6V");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("rl0SI88MRozbS7R2vEqJEn8K4tO6K1hAsAlxX7nhcIddTWO74B");
            timezone.setCountry("kUgVyboh3QGVfxDicwbzMNrNAbyi1T4SBwyDeIAcFSTPPrJ277");
            timezone.setGmtLabel("5X2ZpnP37e9APA6pSGO8IntOVuanX0VS1lWYFWInM9Sc4hPZvv");
            timezone.setTimeZoneLabel("F3By9wEfuj01jFgAYIYFzNhC2kKofNVvNV9kdnLW36OZ3JMKYu");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("CMNr5qi1iL6RbXV9f0qXdMW3QkFeCzXNDFmrSMdtzv8pLLSk82");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(35);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("n2qyl753eaCNzIvDpifMupdT6EhVtCuwA7NHlexTUaexcKekdE");
            corecontacts.setFirstName("Auoj2KSm8VnN0yaxQCE9cJaH6BAPJtAAk4i2ac2fzQLNxUcNhZ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("xr5lyvCpnhmCh1wA7b3M0rZaKc1mTu43DMEX19L8BUv1eCWNSO");
            corecontacts.setMiddleName("eLjEtBISXeO2yYwkOUCGcEHTAhOS5BzZV7BsOrS8AMtPYvHOqs");
            corecontacts.setNativeFirstName("X9ALOw8CplwznhmVdbIaQyKmSqYbUGnFR5xcFsKimODmMULJAj");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("oA3IC6LJzbtg6QLz07lMmOglAnBCYFljAfEDXvsPwdFKy9QqGu");
            corecontacts.setNativeMiddleName("DbUemfVtoLg6eDuXWAw4i82y6kcnhk6Hlox0Jqv7hfjUxjp1ii");
            corecontacts.setNativeTitle("4yOLdibS5s8KcG0hdW4roUD3N7W8pkCQqXnvs9VFNQXLVAInnP");
            corecontacts.setPhoneNumber("nTZ9eUbAlfLyJq45TwRD");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("SBmNp3oAMK5A9kbr305PpKOxl7W4uYUcTF8qDVFMycJofeQRQa");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1310);
            user.setUserAccessCode(10);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("Gd9ivLMFNjqtd91ajATov6CGAhWYuPRKiODasczPa6jKKYp7gV");
            useraccessdomain.setDomainHelp("jGbKZYv6D5JlBeFehtuBiwGDPLO2p195rvS8rRpZ6NseT4osdR");
            useraccessdomain.setDomainIcon("bzM1jUv3FKZF3ArJY0DcF0yEXrqBInGcnJIk0NVQ1zYAAYh15F");
            useraccessdomain.setDomainName("AmetM2OhQenfxfrOmzryTwllWEnqmryKZ9GjBfvK9utj2Bl9qk");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("1pU7qNWArdO3vcS4tOb1wpykdR5n2c7MH3K2GWD9fXzcDozSKT");
            useraccesslevel.setLevelHelp("kH9s28BpFVg2CtOyqT1jbHzWeUwrVrAQxhd9LhVl5juxDR9cLU");
            useraccesslevel.setLevelIcon("VDC9DeKtDSRgoVfD0LSLqJLHi1frBdBElSbqInLkWxVmiiiQN3");
            useraccesslevel.setLevelName("4nsw3nPaT6rx0Hx3Lw9mJnK7dVbOaawzJ4qutQ8AZ9y1uDgzWi");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Z6MMV2mCXQp8Cvi5YFNg9nNYPveFBs4yVEQgWlqB8ph5C7hYiY");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2324);
            user.setUserAccessCode(5);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("gXM2udEjv8gBa7Gq4QNrB9I8OfaMaXFkC1nfuCbCyaxsFtK9Kj");
            login.setServerAuthImage("0VRvIf7oalEtyH9J6oyOtyXELjZYNjTU");
            login.setServerAuthText("itxSMn9GPJSAK9xE");
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
            login.setLoginId("snj8Y1CuAxnwSHkuKJghpSRZbXUmKRJn3g5RQ0HKiGMgRxfC4Z");
            login.setServerAuthImage("FjcgIab1aPSyNiB9wcQZWV9xOy4oaNJU");
            login.setServerAuthText("Oqh75dHlypCwOpBS");
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
