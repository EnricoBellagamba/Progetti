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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

	private Student createStudent() throws Exception {
		Student student = new Student();
		student.setIsWorking(true);
		student.setName("Giovanni");
		student.setSurname("Verdi");

		return createStudent(student);
	}

	private Student getStudentFromId(long id) throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/student/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		try {
			String studentJson = mvcResult.getResponse().getContentAsString();
			return objectMapper.readValue(studentJson, Student.class);
		} catch (Exception e) {
			return null;
		}


	}

	private Student createStudent(Student student) throws Exception {
		MvcResult result = createStudentRequest(student);
		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		return studentFromResponse;
	}

	private MvcResult createStudentRequest() throws Exception {

		Student student = new Student();
		student.setIsWorking(true);
		student.setName("Giovanni");
		student.setSurname("Verdi");

		return createStudentRequest(student);
	}

	private MvcResult createStudentRequest(Student student) throws Exception {

		if (student == null) return null;

		String studentJson = objectMapper.writeValueAsString(student);

		return this.mockMvc.perform(post("/student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJson)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void createStudentTest() throws Exception {
		MvcResult result = createStudentRequest();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
	}

	@Test
	void readStudentList() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/student"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<Student> studentFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertThat(studentFromResponse.size()).isNotZero();
	}

	@Test
	void readSingleStudent() throws Exception {

		Student student = createStudent();

		assertThat(student.getId()).isNotNull();

		MvcResult mvcResult = this.mockMvc.perform(get("/student/" + student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
	}

	@Test
	void updateStudent() throws Exception {

		Student student = createStudent();
		assertThat(student.getId()).isNotNull();

		String newName = "Marco";
		student.setName(newName);

		String studentJson = objectMapper.writeValueAsString(student);

		MvcResult mvcResult = this.mockMvc.perform(put("/student/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJson)).andDo(print())
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn();

		Student studentFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.getName()).isEqualTo(newName);
	}

	@Test
	void deleteStudent() throws Exception {

		Student student = createStudent();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/student/" + student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponseGet = getStudentFromId(student.getId());
		assertThat(studentFromResponseGet).isNull();

	}

	@Test
	void isWorkingStudent() throws Exception {

		Student student = createStudent();
		assertThat(student.getId()).isNotNull();

		MvcResult mvcResult = this.mockMvc.perform(put("/student/" + student.getId() + "/working?working=true"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.getIsWorking()).isEqualTo(true);

		Student studentFromResponseGet = getStudentFromId(student.getId());
		assertThat(studentFromResponseGet.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponseGet.getId()).isNotNull();
		assertThat(studentFromResponseGet.getIsWorking()).isEqualTo(true);
	}
}
