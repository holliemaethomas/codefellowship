package com.hollieThomasCodefellowship.codefellowship;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc


class CodefellowshipApplicationTests {

	@Autowired
	MockMvc mockMvc;


	@Test
	void contextLoads() {
	}
	@Test
	public void testHomeRoute() throws Exception {
		this.mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to CodefellowShip, a place to learn!")));
	}

	@Test
	public void testLoginPageRoute() throws Exception {
		this.mockMvc
				.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome back")));
	}

	@Test
	public void testSignUpPageRoute() throws Exception {
		this.mockMvc
				.perform(get("/signup"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Sign up so you can start sharing!")));
	}



}
