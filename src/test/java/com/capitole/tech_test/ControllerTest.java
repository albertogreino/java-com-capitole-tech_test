package com.capitole.tech_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql("classpath:test-data/data.sql")

class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private String path = "/product-price";

	@Test
	public void shouldReturn3550PriceWhenRequestedForDay14And10H() throws Exception {
		mockMvc.perform(get(path)
				.contentType("application/json")
				.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2020-06-14-10.00.00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5));
	}

	@Test
	public void shouldReturn2545PriceWhenRequestedForDay14And16H() throws Exception {
		mockMvc.perform(get(path)
				.contentType("application/json")
				.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2020-06-14-16.00.00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	public void shouldReturn3550PriceWhenRequestedForDay14And21H() throws Exception {
		mockMvc.perform(get(path)
						.contentType("application/json")
						.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2020-06-14-10.00.00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5));
	}

	@Test
	public void shouldReturn3050PriceWhenRequestedForDay15And10H() throws Exception {
		mockMvc.perform(get(path)
						.contentType("application/json")
						.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2020-06-15-10.00.00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(30.5));
	}

	@Test
	public void shouldReturn3895PriceWhenRequestedForDay16And21H() throws Exception {
		mockMvc.perform(get(path)
						.contentType("application/json")
						.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2020-06-16-21.00.00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(38.95));
	}

	@Test
	public void shouldReturnNotFoundWhenRequestedForYear2023() throws Exception {
		mockMvc.perform(get(path)
						.contentType("application/json")
						.content("{\"brandId\":1,\"productId\":35455,\"date\":\"2023-06-16-21.00.00\"}"))
				.andExpect(status().isNotFound());
	}
}
