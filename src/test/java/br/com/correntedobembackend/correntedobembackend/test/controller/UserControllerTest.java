package br.com.correntedobembackend.correntedobembackend.test.controller;

import br.com.correntedobembackend.correntedobembackend.controller.UserController;
import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@WithMockUser(username = "joao@joao.com")
@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = {UserController.class })
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserController userController;

    @Test
    public void shouldReturnUserFindByEmail() throws Exception {
        Optional<User> user = Optional.of(new User(1,
                1,
                "João Francisco",
                "qualquercoisa.jpg",
                "55555555555",
                "75991663952",
                "joao@joao.com",
                "correntedobem"));
        when(userRepository.findByEmail("joao@joao.com")).thenReturn(user);
        this.mockMvc.perform(get("/user/byEmail/joao@joao.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("email").value("joao@joao.com"));
    }
    @Test
    public void shouldReturnUserFindById() throws Exception {
        Optional<User> user = Optional.of(new User(1,
                1,
                "João Francisco",
                "qualquercoisa.jpg",
                "55555555555",
                "75991663952",
                "joao@joao.com",
                "correntedobem"));
        when(userRepository.findById(1)).thenReturn(user);
        this.mockMvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("id").value(1));
    }
    @Test
    public void updateShouldChangeAndPersistData() {
        User user = new User("João Francisco", "joao@joao.com");
        this.userRepository.save(user);
        user.setName("João Francisco1");
        user.setEmail("joao11@joao.com");
        this.userRepository.save(user);
        user = this.userRepository.findOne(user.getId());
        assertThat(user.getName()).isEqualTo("João Francisco1");
        assertThat(user.getEmail()).isEqualTo("joao11@joao.com");
    }

//    @Test
//    public void shouldReturnAllUsers() throws Exception {
//        List<User> listUsers = new ArrayList<>();
//        when(userRepository.findAll()).thenReturn(listUsers);
//        this.mockMvc.perform(get("/user/list")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
////                .andReturn();
//    }
//    @Test
//    public void shouldDeleteUserById() throws Exception {
//        Optional<User> ct = Optional.of(new User(1,
//                1,
//                "João Francisco",
//                "qualquercoisa.jpg",
//                "55555555555",
//                "75991663952",
//                "joao@joao.com",
//                "correntedobem"));
//        when(userRepository.findById(1)).thenReturn(ct);
//        this.mockMvc.perform(delete("/user/delete/1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void deleteUserById() {
//        User user = new User(1);
//        User user2 = new User(1);
//
//        when(userRepository.deleteById(1)).thenReturn(user2);
//        this.mockMvc.perform(delete("/user/delete/1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//}

//    @Test
//    public void shouldNotReturnUserWithoutParam() throws Exception {
//        this.mockMvc.perform(get("/user")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
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
//}
//        @Test
//        public void shouldReturnOk() throws Exception{
//            User user = new User( 1,
//                    1,
//                    "João Francisco",
//                    "qualquercoisa.jpg",
//                    "55555555555",
//                    "2001-07-11",
//                    "75991663952",
//                    "joao@joao.com",
//                    "correntedobem");
//            Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//            this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
//                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(jsonPath("name").value("João Francisco"));
//        }
//    }
}