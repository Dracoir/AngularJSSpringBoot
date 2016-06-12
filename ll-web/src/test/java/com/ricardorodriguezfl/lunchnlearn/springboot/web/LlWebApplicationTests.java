package com.ricardorodriguezfl.lunchnlearn.springboot.web;

import com.ricardorodriguezfl.lunchnlearn.springboot.LlWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LlWebApplication.class)
@WebAppConfiguration
public class LlWebApplicationTests {

	@Test
	public void contextLoads() {}

}
