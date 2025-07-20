package com.example.unittest;

import com.example.unittest.controller.UserController;
import com.example.unittest.entity.User;
import com.example.unittest.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UnittestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserController userController;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
	}

	@Test
	void testFindAllUsers() throws Exception {
		mockMvc.perform(get("/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray());
	}

	@Test
	void testFindUserById() throws Exception {

		User user = new User();
		user.setName("Beppe");
		user.setSurname("Beppino");
		user.setAge(30);

		User savedUser = userRepository.save(user);

		assertThat(savedUser.getId()).isNotNull();

		MvcResult mvcResult = this.mockMvc.perform(get("/users/" + savedUser.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		User userFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
		assertThat(userFromResponse.getId()).isNotNull();
		assertThat(userFromResponse.getId()).isEqualTo(user.getId());
	}

	@Test
	void testCreateUser() throws Exception {
		String newUserJson = """
		{
			"name": "Mario",
			"surname": "Rossi",
			"age": 30
		}
	""";

		mockMvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newUserJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("Mario"))
				.andExpect(jsonPath("$.surname").value("Rossi"))
				.andExpect(jsonPath("$.age").value(30));
	}

	@Test
	void testUpdateUser() throws Exception {
		String updatedUserJson = """
		{
			"name": "Luigi",
			"surname": "Verdi",
			"age": 40
		}
	""";

		mockMvc.perform(put("/users/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedUserJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Luigi"))
				.andExpect(jsonPath("$.surname").value("Verdi"))
				.andExpect(jsonPath("$.age").value(40));
	}

	@Test
	void testDeleteUser() throws Exception {
		mockMvc.perform(delete("/users/{id}", 1))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
