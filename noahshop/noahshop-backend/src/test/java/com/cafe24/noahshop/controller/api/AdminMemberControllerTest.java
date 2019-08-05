package com.cafe24.noahshop.controller.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminMemberControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void testgetMemberList() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/api/admin/user/list").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                     .andDo(print())
                     .andExpect(jsonPath("$.result", is("success")));
    }

    @Test
    public void testSearchMemberById() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/api/admin/user/search/{id}","us").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.result", is("success")));
    }

}
