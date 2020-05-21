package com.alvin.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@Slf4j
public class AppControllerTest extends TestBase {

    @Test
    public void testFindOne() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/findOne")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testLog() {
        log.info(new Date().toString());
    }
}