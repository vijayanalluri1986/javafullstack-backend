package com.example.hexagonal_architecture_example.stepdefs;

import com.example.hexagonal_architecture_example.config.UserTestConfig;
import com.example.hexagonal_architecture_example.infrastructure.rest.spring.dto.UserDto;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DirtiesContext
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {UserTestConfig.class}
)
@AutoConfigureMockMvc
@ActiveProfiles("profile1")
public class UserStepDefinition {

    private String postUserurl = "users";

    @Autowired
    private MockMvc mockMvc;
    private MvcResult result;
    private List<UserDto> userDtoList = new ArrayList<>();

    private final ObjectMapper objectMapper =
            new ObjectMapper().registerModule(new JSR310Module());

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object defaultTransformer(Object fromValue, Type toValueType) {
        JavaType javaType = objectMapper.constructType(toValueType);
        return objectMapper.convertValue(fromValue, javaType);
    }


    @When("Create The user with following Details")
    public void createTheUser(List<UserDto> userDtos) throws Exception {

        for (UserDto userDto : userDtos) {
            String user = objectMapper.writeValueAsString(userDto);
            result = this.mockMvc
                    .perform(post("/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(user)
                    )
                    .andExpect(status().isCreated()).andReturn();

            UserDto resultDto = objectMapper.readValue(result.getResponse().getContentAsString(), UserDto.class);
            userDtoList.add(resultDto);
        }
    }

    @Then("Verify The User Details")
    public void verifyTheUser(List<UserDto> userDtos) throws Exception {

    }
}