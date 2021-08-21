//package br.com.correntedobembackend.correntedobembackend.test.controller;
//
//import br.com.correntedobembackend.correntedobembackend.controller.HabilityController;
//import br.com.correntedobembackend.correntedobembackend.model.Hability;
//import br.com.correntedobembackend.correntedobembackend.repository.HabilityRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc(addFilters=false)
//@WithMockUser(username = "joao@joao.com")
//@WebMvcTest(value = HabilityController.class, properties = "spring.main.lazy-initialization=true")
////@WebMvcTest(value = HabilityController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
////@SpringBootTest(classes = HabilityController.class, properties = {"security.basic.enabled=false"})
//public class HabilityControllerTest {
//
//    @MockBean
//    private HabilityRepository repository;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void shouldReturnOk() throws Exception{
//        Hability hability = new Hability(1,"Educação","Educação","img");
//        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(hability));
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/hability/{id}", 1)
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("label").value("Educação"));
//    }
//}
