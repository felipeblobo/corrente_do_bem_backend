//package br.com.correntedobembackend.correntedobembackend.test.repository;
//
//import br.com.correntedobembackend.correntedobembackend.model.User;
//import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void updateUser() {
//
//    User oldUser = userRepository.findById(1).get(
//                "João Francisco",
//                "joao@joao.com",
//                "75991663952",
//                "correntedobem");
//
//
//            oldUser.setName(user.getName());
//            oldUser.setEmail(user.getEmail());
//            oldUser.setPhone(user.getPhone());
//            oldUser.setPassword(user.getPassword());
//            Mockito.when(userRepository.save(user)).thenReturn(oldUser);
//            this.mockMvc.perform(
//                    post("/updateUser/{id}")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(new ObjectMapper().writeValueAsString(user)))
//                    .andExpect(status().isUpdated());
//            return userRepository.save(oldUser);



//        }

//    @Test
//    public void insertUser() {
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
//
//        Integer countUsers = Math.toIntExact(userRepository.findAll().stream().count());
//        assertEquals(1, countUsers);
//    }
//
//    @Test
//    public void checkUserSavedWithName() {
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
//
//        Integer countUsers = Math.toIntExact(userRepository.findAll().stream().count());
//        assertEquals(1, countUsers);
//
//        User user1 = userRepository.findUserByName("João Francisco");
//
//        assertNotNull(user);
//        assertEquals(user, user1);
//    }
//
//    @Test
//    public void checkUserSavedWithNamePassingOtherNameShouldReturnNull() {
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
//
//        Integer countUsers = Math.toIntExact(userRepository.findAll().stream().count());
//        assertEquals(1, countUsers);
//
//        User user1 = userRepository.findUserByName("Maria Antonia");
//
//        assertNull(user);
//    }
//}
