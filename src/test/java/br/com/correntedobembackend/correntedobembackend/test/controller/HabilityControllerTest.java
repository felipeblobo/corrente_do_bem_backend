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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
@SpringBootTest(classes = {HabilityController.class })
//properties = "spring.main.lazy-initialization=true",
public class HabilityControllerTest {

    @MockBean
    HabilityRepository habilityRepository;

    @MockBean
    HabilityController habilityController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHabilityFindById() throws Exception{
        Hability hability = new Hability(1,"Educação","Educação","img");
        Mockito.when(habilityRepository.findById(1)).thenReturn(java.util.Optional.of(hability));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hability/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("label").value("Educação"));
    }
}


//    @Test
//    public void findHabilityByIdShouldReturnOk() throws Exception {
//        Hability hability = new Hability();
//        hability.setId(1);
//        hability.setLabel("Educação");
//
//        Mockito.when(habilityRepository.findById(1)).thenReturn(Optional.of(hability));
//        this.mockMvc.perform(
//                get("/hability/1").with(oauth2Login())
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("label").value("Educação"));
//    }
//
//}