package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.CauseController;
import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.repository.CauseRepository;
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
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CauseController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class CauseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CauseRepository causeRepository;

    @MockBean
    private CauseController causeController;

    @Test
    public void shouldReturnCauseFindById() throws Exception {
        Cause cause = new Cause(1, "saude", "Saúde", "images/health_cause.svg");
        Mockito.when(causeRepository.findById(1)).thenReturn(Optional.of(cause));
        this.mockMvc.perform(
                get("/cause/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(1));
    }

    @Test
    public void addCauseShouldReturnOk() throws Exception {
        Cause cause = new Cause(1, "saude", "Saúde", "images/health_cause.svg");
        Mockito.when(causeRepository.save(cause)).thenReturn(cause);
        this.mockMvc.perform(
                post("/cause")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(cause)))
                .andExpect(status().isCreated());
    }

        @Test
        public void shouldDeleteCauseById(){
            causeRepository.deleteById(1);
            Optional<Cause> optionalCause = causeRepository
                    .findById(1);
            assertFalse(optionalCause.isPresent());
        }
    }