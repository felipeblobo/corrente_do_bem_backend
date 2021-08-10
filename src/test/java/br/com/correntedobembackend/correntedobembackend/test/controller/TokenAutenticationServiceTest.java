package br.com.correntedobembackend.correntedobembackend.test.controller;


import br.com.correntedobembackend.correntedobembackend.security.AuthorizationFilter;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenAutenticationServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorizationFilter filter;

    @Test
    public void shouldNotAllowAcessToUnanthenticateUsers() throws Exception {
        mvc.perform(get("/user")).andExpect(status().isForbidden());
    }
}

