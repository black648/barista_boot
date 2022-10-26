package org.barista.service.attach.service;

import org.barista.framework.utils.ServiceUtil;
import org.barista.service.attach.dto.AttachSearchDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AttachServiceTest {
    public MockHttpSession session;
    public MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        MockitoAnnotations.initMocks(this);

    }

    @Test
//    @Transactional
    @Rollback(false)
    public void getList() {
        AttachSearchDto searchDto = new AttachSearchDto();
        Map<String, Object> map = ServiceUtil.getAttachService().getList(searchDto);
        System.out.println("asdkfhkasd");
    }
}