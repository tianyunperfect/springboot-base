package com.alvin.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
}