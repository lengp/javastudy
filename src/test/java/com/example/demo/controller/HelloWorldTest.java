package com.example.demo.controller;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    DemoApplication.class
})
public class HelloWorldTest {

  protected MockMvc http;

  @Autowired
  private WebApplicationContext context;

  @Before
  public final void setUp() {

    this.http = MockMvcBuilders.webAppContextSetup(this.context)
        .alwaysDo(print())
        .build();
  }

  @Test
  public void testHello() throws Exception {
    http.perform(
        get("/hello")
    ).andExpect(status().isOk())
        //.andExpect(content().string("HelloWorld"))
        .andDo(result -> assertEquals("", "Hello", result.getResponse().getContentAsString().substring(0, 5)));
  }
}
