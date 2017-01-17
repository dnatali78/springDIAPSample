package com.aurea.antipattern.sample.spring;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.services.ComponentService;
import com.aurea.antipattern.sample.spring.services.StatusService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDIApplicationTests {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpringDIApplicationTests.class);
  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
  private MockMvc mockMvc;

  @Autowired
  private StatusService statusService;
  @Autowired
  private ComponentService componentService;
  @Autowired
  private WebApplicationContext context;
  
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders
              .webAppContextSetup(context)
              .build();
  }
  
  
  @Test
  public void getAllStatusTest() {
    Iterable<Status> statuses = statusService.getStatusForAllComponents();
    assertEquals(5, statuses.spliterator().getExactSizeIfKnown());

  }

  @Test
  public void getStatusByComponentTest() {
    Status status = statusService.getStatusByComponent("Component1");
    assertNotNull(status);
    assertEquals("Component1", status.getComponent());
    assertEquals("OK", status.getState());

    LOGGER.debug(status.toString());

  }

  @Test
  public void getComponentDetails() {
    String detail = componentService.getComponentDetails("Component1");
    assertNotNull(detail);
    assertEquals("component1", detail);
  }

  @Test
  public void allStatusController() throws Exception {
    mockMvc.perform(get("/allstatus")).andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$", hasSize(5)))
        .andExpect(jsonPath("$[0].component", is("Component1")))
        .andExpect(jsonPath("$[0].state", is("OK")));

  }
  
  @Test
  public void findOneStatusControllerTest() throws Exception {
    mockMvc.perform(get("/status").param("component", "Component1")).andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("component", is("Component1")))
        .andExpect(jsonPath("state", is("OK")));
  }
  
  @Test
  public void componentDetailsControllerTest() throws Exception {
    mockMvc.perform(get("/allcomponents")).andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_UTF8));
  }

}
