package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.CauseController;
import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.repository.CauseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
@SpringBootTest(classes = {CauseController.class })
public class CauseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CauseRepository causeRepository;

    @MockBean
    private CauseController causeController;

    @Test
    public void shouldReturnCauseFindById() throws Exception {
        Optional<Cause> cause = Optional.of(new Cause(1, "saude", "Saúde", "images/health_cause.svg"));
        when(causeRepository.findById(1)).thenReturn(cause);
        this.mockMvc.perform(get("/id/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("id").value(1));
    }



//    @Test
//    public void deleteShouldRemoveData() {
//        Cause cause = new Cause(1, "saude", "Saúde", "images/health_cause.svg");
//                this.causeRepository.save(cause);
//                causeRepository.delete(cause);
//                assertThat(causeRepository.findById(1)).isNull();
//
//    }
//
//    @Test
//    public void updateShouldChangeAndPersistData(){
//        Cause cause = new Cause(1, "saude", "Saúde", "images/health_cause.svg");
//        this.causeRepository.save(cause);
//        cause.setId(1);
//        cause.setValue("Saúde");
//        cause = this.causeRepository.save(cause);
//        assertThat(cause.getId()).isEqualTo(1);
//        assertThat(cause.getValue()).isEqualTo("Saúde");
//
//    }
}
