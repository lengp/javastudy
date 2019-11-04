package com.example.demo.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.DemoApplication;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
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

  @Rule
  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

  @Before
  public final void setUp() {

    this.http = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.restDocumentation))
        .alwaysDo(print())
        .build();
  }

  @Test
  public void test() throws Exception {

    final long a = 24L * 60L * 60L * 1000L * 25L;

    Assert.assertEquals(1, 1);
  }

  @Test
  public void test2() throws Exception {
    Assert.assertEquals(1, 1);
  }

  @Test
  public void testHello() throws Exception {
    http.perform(
        get("/hello")
    ).andExpect(status().isOk())
        //.andExpect(content().string("HelloWorld"))
        .andDo(result -> assertEquals("", "Hello", result.getResponse().getContentAsString().substring(0, 5)));
  }


  @Test
  public void getName() throws Exception {
    http.perform(get("/name"))
        .andExpect(status().isOk())
        .andExpect(content().string("lengpeng:22"))
        .andDo(
            document("get-name")
        );
  }


  @Test
  public void mapReduceTest() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

    final List<Integer> doubleNumbers = numbers.stream()
        .map(number -> n2(number))
        .collect(Collectors.toList());

    Assert.assertEquals(2, doubleNumbers.get(0).intValue());

    Optional<Integer> num = numbers.stream().reduce((a, b) -> a + b);

    Assert.assertEquals(10, num.get().intValue());
  }

  private Integer n2(Integer i) {
    return i * 2;
  }
}
