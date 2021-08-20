package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.UserController;
import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
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
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, properties = "spring.main.lazy-initialization=true")
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    public UserControllerTest() {
    }

    @Test
    public void shouldReturnUserFindById() throws Exception {
        Optional<User> user = Optional.of(new User(1,
                1,
                "João Francisco",
                "qualquercoisa.jpg",
                "55555555555",
                new Date("11/07/2001"),
                "75991663952",
                "joao@joao.com",
                "correntedobem"));
        Mockito.when(userRepository.findById(1)).thenReturn(user);
        this.mockMvc.perform(get("/user/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(1));
    }

    @Test
    public void shouldReturnUserFindByEmail() throws Exception {
        Optional<User> user = Optional.of(new User(1,
                1,
                "João Francisco",
                "qualquercoisa.jpg",
                "55555555555",
                new Date("11/07/2001"),
                "75991663952",
                "joao@joao.com",
                "correntedobem"));
        when(userRepository.findByEmail("joao@joao.com")).thenReturn(user);
        this.mockMvc.perform(get("/user/byEmail/{email}", "joao@joao.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("email").value("joao@joao.com"));
    }

    @Test
    public void addUserShouldReturnOk() throws Exception {
        User user = new User(1,
                1,
                "João Francisco",
                "qualquercoisa.jpg",
                "55555555555",
                new Date("11/07/2001"),
                "75991663952",
                "joao@joao.com",
                "correntedobem");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        this.mockMvc.perform(
                post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteUserById() {
        userRepository.deleteById(1);
        Optional<User> optionalCause = userRepository
                .findById(1);
        assertFalse(optionalCause.isPresent());
    }
}

//    @Test
//    public void updateShouldChangeAndPersistData() {
//        User user = new User(1,
//                1,
//                "João Francisco",
//                "qualquercoisa.jpg",
//                "55555555555",
//                new Date("11/07/2001"),
//                "75991663952",
//                "joao@joao.com",
//                "correntedobem");
//        userRepository.save(user);
//        user.setName("João Francisco1");
//        user.setEmail("joao11@joao.com");
//        userRepository.save(user);
//        Optional<User> user2 = userRepository.findById(1);
//        assertThat(user2.get().equals(user));

//    @Test
//    public void shouldReturnAllUsers() throws Exception {
//        List<User> listUsers = new ArrayList<>();
//        when(userRepository.findAll()).thenReturn(listUsers);
//        this.mockMvc.perform(get("/user/list")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
////                .andReturn();
//    }
//    }

//    @Test
//    public ResponseEntity<Boolean> passwordValidation() throws Exception {
//        User user = new User("joao@joao.com", "123456");
//        Optional<User> optUser = userRepository.findByEmail("joao@joao.com");
//        if (optUser.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//        }
//        return null;
//    }
////}
//@Test
//public void shouldNotReturnUserWithoutParam() throws Exception {
//    this.mockMvc.perform(get("/user")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//
//}