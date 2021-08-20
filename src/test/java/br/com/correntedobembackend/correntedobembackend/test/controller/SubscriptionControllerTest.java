package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.SubscriptionController;
import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.model.Subscription;
import br.com.correntedobembackend.correntedobembackend.repository.SubscriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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
@WebMvcTest(value = SubscriptionController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class SubscriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionRepository subscriptionRepository;

    @Test
    public void shouldReturnSubscriptionFindById() throws Exception {
        Subscription subscription = new Subscription(1, 1, 1, "2021-07-07", "Cancelada");
        Mockito.when(subscriptionRepository.findById(1)).thenReturn(Optional.of(subscription));
        this.mockMvc.perform(
                get("/subscription/{id}", 1).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    public void shouldDeleteSubscriptionById() {
        subscriptionRepository.deleteById(1);
        Optional<Subscription> optionalSubscription = subscriptionRepository
                .findById(1);
        assertFalse(optionalSubscription.isPresent());
    }

}
