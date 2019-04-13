package com.services.finder_service;

import static org.junit.Assert.*;
import com.hello.Finder;
import com.services.finder_service.FinderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FinderServiceRealTest {

    @MockBean
    private FinderService finderService;

    @Test
    public void processShouldReturnEntity (){
        when(finderService.process('l', "hello")).thenReturn(new Finder("2", 'l'));
        when(finderService.process('l', "hello world")).thenReturn(new Finder("3", 'l'));
    }

    @Test
    public void validateShouldReturnBoollean(){
        when(finderService.validate('l', "hello")).thenReturn(true);
        when(finderService.validate('\n', "hello")).thenReturn(false);
        when(finderService.validate(' ', "hello")).thenReturn(false);
    }
}