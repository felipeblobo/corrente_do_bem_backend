package br.com.correntedobembackend.correntedobembackend.service;

import br.com.correntedobembackend.correntedobembackend.data.UserDetailsData;
import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public ApplicationUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(userEmail);

        if(!user.isPresent()) {
            throw new UsernameNotFoundException("O usuário ou senha não encontrado!");
        }

        return new UserDetailsData(user);
    }
}
