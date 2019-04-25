package com.hello;

import com.services.finder_service.FinderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class FinderControllerTest {

    @MockBean
    private FinderService finderService;

    @Test
    public void greetingOkTest() throws Exception {

        when(finderService.validate('l', "hello")).thenReturn(true);
    }

    @Test
    public void greetingBadRequestTest() throws Exception {

        when(finderService.validate('\n', "hello")).thenReturn(false);
    }

    @Test
    public void greetingInnerServErrorTest() {

        when(finderService.validate(' ', "hello")).thenReturn(true);
    }
}