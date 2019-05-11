package com.peter.demo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.peter.demo.controller.EntityService;
import com.peter.demo.entity.TokenEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
public class DarajaDemoApplicationTests {

	//@Autowired
	//private MockMvc mockMvc;

	//@MockBean
	//private EntityService entityService;

	@Test
	public void findAll() throws Exception {
		//TokenEntity tentity = new TokenEntity("tekn_string","12345");
		/*
		 * List<TokenEntity> tentities = Arrays.asList(tentity);
		 * given(entityService.findAll()).willReturn(tentities);
		 * 
		 * this.mockMvc.perform(get("/tokens")) .andExpect(status().isOk())
		 * .andExpect(content().
		 * json("[{'id': 1,'token': 'tekn_string';'expiry': '12345'}, " +
		 * "{'id': 2,'token': 'tekn_string2';'expiry': '1235245'}]"));
		 */
	}

}
