package com.HM.SortNumbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.HM.SortNumbers.dao.SortNumbersAppDaoImpl;

public class TestWebApp extends SortNumbersApplicationTests {

	SortNumbersAppDaoImpl sortDaoImpl = new SortNumbersAppDaoImpl();
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void convertToCommaSeparatedString_test() throws Exception {
		assertEquals("1,2,3",sortDaoImpl.convertToCommaSeparatedString(new int[]{1,2,3}));

	}
}