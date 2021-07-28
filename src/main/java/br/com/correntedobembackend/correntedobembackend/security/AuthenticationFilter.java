package br.com.correntedobembackend.correntedobembackend.security;

import br.com.correntedobembackend.correntedobembackend.data.UserDetailsData;
import br.com.correntedobembackend.correntedobembackend.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRATION = 600_000;
    public static final String TOKEN_PASSWORD = "b2180839-c619-43a7-b49b-7cb7cc5d2de1";

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword(),
                    new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar o usuário!", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetailsData userData = (UserDetailsData)  authResult.getPrincipal();

        String token = JWT.create().
                withSubject(userData.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION)).
                sign(Algorithm.HMAC512(TOKEN_PASSWORD));

                response.getWriter().write(token);
                response.getWriter().flush();

    }
}
