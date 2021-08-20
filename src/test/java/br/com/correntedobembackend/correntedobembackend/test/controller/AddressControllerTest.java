package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.AddressController;
import br.com.correntedobembackend.correntedobembackend.model.Address;
import br.com.correntedobembackend.correntedobembackend.repository.AddressRepository;
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
@WebMvcTest(value = AddressController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressRepository addressRepository;

    @Test
    public void shouldReturnAddressFindById() throws Exception {
        Address address = new Address(1, "São Paulo", "SP", "R. Paim", "394", "", "Bela Vista", "01306010");
        Mockito.when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        this.mockMvc.perform(
                get("/address/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(1));
    }

    @Test
    public void shouldDeleteAddressById() {
        addressRepository.deleteById(1);
        Optional<Address> optionalAddress = addressRepository
                .findById(1);
        assertFalse(optionalAddress.isPresent());
    }
}
