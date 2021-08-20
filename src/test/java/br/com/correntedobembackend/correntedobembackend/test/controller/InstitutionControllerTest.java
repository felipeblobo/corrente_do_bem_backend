package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.InstitutionController;
import br.com.correntedobembackend.correntedobembackend.model.Institution;
import br.com.correntedobembackend.correntedobembackend.repository.InstitutionRepository;
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
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = InstitutionController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class InstitutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstitutionRepository institutionRepository;

    @Test
    public void shouldReturnInstitutionFindById() throws Exception {
        Institution institution = new Institution(9, "Cozinhando Amor",
                "https://storage.googleapis.com/atados-v3/project/associacao-a-gente-ajuda/cozinhe-para-quem-precisa.jpg",
                "cozinhando@cozinhando.com", "Cozinhamos com amor para aqueles que necessitam.", "6,52E+13",
                "99999999999", "www.cozinhando.com.br", "null", "@cozinhando",
                "Cozinhamos com amor para aqueles que necessitam.");
        Mockito.when(institutionRepository.findById(9)).thenReturn(Optional.of(institution));
        this.mockMvc.perform(
                get("/institution/{id}", 9).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("id").value(9))
        ;
    }

    @Test
    public void shouldDeleteInstitutionById() {
        institutionRepository.deleteById(1);
        Optional<Institution> optionalInstitution = institutionRepository
                .findById(1);
        assertFalse(optionalInstitution.isPresent());
    }

}
