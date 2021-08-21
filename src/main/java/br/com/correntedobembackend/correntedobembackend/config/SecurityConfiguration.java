package br.com.correntedobembackend.correntedobembackend.config;

import br.com.correntedobembackend.correntedobembackend.security.AuthenticationFilter;
import br.com.correntedobembackend.correntedobembackend.security.AuthorizationFilter;
import br.com.correntedobembackend.correntedobembackend.service.ApplicationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;
import java.util.Collections;

import static br.com.correntedobembackend.correntedobembackend.constants.SecurityConstants.NO_AUTH_LIST;
import static br.com.correntedobembackend.correntedobembackend.constants.SecurityConstants.AUTH_LIST;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder getPasswordEnconder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.GET, NO_AUTH_LIST).permitAll()
                .antMatchers(HttpMethod.POST, "/user", "/institution", "/address").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager()))
                .addFilter((new AuthorizationFilter(authenticationManager())))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration conf  = new CorsConfiguration().applyPermitDefaultValues();
        conf.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
        conf.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        conf.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        conf.setExposedHeaders(Arrays.asList("Authorization", "content-type"));
        conf.setAllowedHeaders(Arrays.asList("Authorization", "content-type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf);
        return source;
    }


}
