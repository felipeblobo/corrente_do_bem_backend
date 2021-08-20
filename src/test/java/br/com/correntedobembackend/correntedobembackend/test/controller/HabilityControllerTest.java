package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.HabilityController;
import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.HabilityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HabilityController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class HabilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HabilityRepository habilityRepository;


    @Test
    public void shouldReturnHabilityFindById() throws Exception{
        Hability hability = new Hability(1,"Educação","Educação","img");
        Mockito.when(habilityRepository.findById(1)).thenReturn(Optional.of(hability));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hability/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("label").value("Educação"));
    }

    @Test
    public void addHabilityShouldReturnOk() throws Exception {
        Hability hability = new Hability(1,"Educação","Educação","img");
        Mockito.when(habilityRepository.save(hability)).thenReturn(hability);
        this.mockMvc.perform(
                post("/hability")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(hability)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteHabilityById() {
        habilityRepository.deleteById(1);
        Optional<Hability> optionalHability = habilityRepository
                .findById(1);
        assertFalse(optionalHability.isPresent());
    }
}
