package br.com.correntedobembackend.correntedobembackend.service;

import br.com.correntedobembackend.correntedobembackend.data.UserDetailsData;
import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(userEmail);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("O usuário ou senha não encontrado!");
        }

        return new UserDetailsData(user);
    }
}
