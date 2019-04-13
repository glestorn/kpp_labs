package com.hello;

import com.services.finder_service.FinderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class FinderControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    private FinderService finderService;

    @MockBean
    private FinderController finderController;

    @Test
    public void greetingOkTest() throws Exception {
        //assertEquals(finderService.);
        when(finderService.validate('l', "hello")).thenReturn(true);
        //when(finderService.greeting("hello",'l')).thenReturn(new ResponseEntity("Ok", HttpStatus.OK));
    }

    @Test
    public void greetingBadRequestTest() throws Exception {

        when(finderService.validate('\n', "hello")).thenReturn(false);
        //when(finderController.greeting("hello", '\n')).thenReturn(new ResponseEntity("Bad_Request", HttpStatus.BAD_REQUEST));
    }

    @Test
    public void greetingInnerServErrorTest() {

        when(finderService.validate(' ', "hello")).thenReturn(true);
        //when(finderController.greeting("hello", ' ')).thenReturn(new ResponseEntity("Bad_Request", HttpStatus.INTERNAL_SERVER_ERROR));
    }
}