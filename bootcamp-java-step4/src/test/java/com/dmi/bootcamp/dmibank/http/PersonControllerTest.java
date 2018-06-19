package com.dmi.bootcamp.dmibank.http;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.dmi.bootcamp.dmibank.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@DirtiesContext(classMode=ClassMode.BEFORE_EACH_TEST_METHOD) // forces the DB to be recreated
public class PersonControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void testInsertFred() throws Exception {
        Person p = new Person("Fred", "Flintstone");
        
        String json = new ObjectMapper().writeValueAsString(p);
        
        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
        .andExpect(status().is(HttpStatus.CREATED.value()))
        .andExpect(header().string("Location", "http://localhost/person/1"));
        
        mockMvc.perform(get("/person/1"))
        .andExpect(status().is(HttpStatus.OK.value()))
        .andExpect(jsonPath("$.firstName", is("Fred")))
        .andExpect(jsonPath("$.lastName", is("Flintstone")));
    }

    @Test
    public void testInsertWilma() throws Exception {
        Person p = new Person("Wilma", "Flintstone");
        
        String json = new ObjectMapper().writeValueAsString(p);
        
        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
        .andExpect(status().is(HttpStatus.CREATED.value()))
        .andExpect(header().string("Location", "http://localhost/person/1"));
        
        mockMvc.perform(get("/person/1"))
        .andExpect(status().is(HttpStatus.OK.value()))
        .andExpect(jsonPath("$.firstName", is("Wilma")))
        .andExpect(jsonPath("$.lastName", is("Flintstone")));
    }
}
