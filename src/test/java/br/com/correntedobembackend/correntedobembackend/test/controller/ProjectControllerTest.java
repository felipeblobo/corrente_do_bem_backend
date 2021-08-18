package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.ProjectController;
import br.com.correntedobembackend.correntedobembackend.model.Project;
import br.com.correntedobembackend.correntedobembackend.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = {ProjectController.class })
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private ProjectController projectController;

    @Test
    public void shouldReturnProjectFindById() throws Exception {
        Optional<Project> project =
                Optional.of(new Project(6, 2, "Dentista(o)",
                        "https://images.unsplash.com/photo-1588776814546-1ffcf47267a5?ixid" +
                                "=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2" +
                                ".1&auto=format&fit=crop&w=1", "local", 6, "Estamos precisando de alguém com experiência em periodontia."));
        Mockito.when(projectRepository.findById(1)).thenReturn(project);
        this.mockMvc.perform(
                get("/project/9").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        //                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        //                .andExpect(jsonPath("id").value(1))
        ;
    }
}
