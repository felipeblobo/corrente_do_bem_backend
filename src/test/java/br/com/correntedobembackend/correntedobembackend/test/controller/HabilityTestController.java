package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.HabilityController;
import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.repository.HabilityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = {HabilityController.class })
public class HabilityTestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HabilityRepository habilityRepository;

    @Test
    public void findHabilityByIdShouldReturnOk() throws Exception {
        Hability hability = new Hability();
        hability.setId(1);
        hability.setLabel("Educação");

        Mockito.when(habilityRepository.findById(1)).thenReturn(Optional.of(hability));
        this.mockMvc.perform(
                get("/hability/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("label").value("Educação"));
    }

}