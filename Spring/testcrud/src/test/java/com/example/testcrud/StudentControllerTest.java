package com.example.testcrud;

import com.example.testcrud.controller.StudentController;
import com.example.testcrud.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private StudentController studentController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void StudentControllerLoads() {
		assertThat(studentController).isNotNull();
	}

	@Test
	void createUser() throws Exception {
		Student student = new Student();
		student.setIsWorking(true);
		student.setName("Giovanni");
		student.setSurname("Verdi");

		String studentJson = objectMapper.writeValueAsString(student);

		MvcResult mvcResult = this.mockMvc.perform(post("/student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJson)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
	}

}
