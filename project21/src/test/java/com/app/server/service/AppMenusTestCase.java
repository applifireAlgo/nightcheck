package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AppMenusRepository;
import com.app.shared.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("qybZzdnGdcOKR2EJ3fNMTskVi5yCABa37UH45r07mihbXYFVlT");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(3);
            appmenus.setMenuAction("H2rw8LDN2dcpLFSEImxk8SM2P3dV6udQO0bxjAejcUiJAS85RY");
            appmenus.setMenuCommands("O9lGKDHZHCrWK0kmRPKCKvEUux1KTgPVQzs5cyW9ZRY0LQnXRx");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("zKsk6ihHqycmktEaw3L70SKuIeNJlYR9qsiv2bVKCRC1Mmjw6Q");
            appmenus.setMenuLabel("qpWkYlF2QV1RnBuBV2vUeLdxJNjPyyMoLtmeLQFbbN59j2fL0x");
            appmenus.setMenuTreeId("PWYgJh0bykIkqxvz9g9ykzRYhy3iNaMRsulFGsvcN5zk2NB3UJ");
            appmenus.setRefObjectId("JKyr2oA5WhxWW3Fsb7VUkcup6x38ScZo9z4px35LQh7cyH1hNm");
            appmenus.setUiType("IZh");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("PAwb8rsTFLm4APpYWcD7kfyx8EZ7A1lyKG9UjivrsFKXpIX34A");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuAction("KV67Xcrhd7o9gmGLQcCHXjN81w0SJghc5Ouhr2uDbxZyUledG9");
            appmenus.setMenuCommands("wA6D78S72qxhHtp5YKsmRxY5NIF62VNuRDvMFCZ15hHt902qkF");
            appmenus.setMenuIcon("OYnfjEmCVU020I1mSlcnXybYQKQh1HNWmbRG5CC7eGhMu9HQMM");
            appmenus.setMenuLabel("45UAxRkniD2e1D8cDVrPMcX7KceBYrEGL9xT5Is3s4QdAUd0kM");
            appmenus.setMenuTreeId("63DPk5hpl9GxenWuojTa0j3bJJHBkEDwDevdKPQ8ItVfD9080M");
            appmenus.setRefObjectId("rlMiZhUwLZzhQGBheo9sLDwz8vwn2qzDVH9eaGhwWP6s733M5r");
            appmenus.setUiType("SrY");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
