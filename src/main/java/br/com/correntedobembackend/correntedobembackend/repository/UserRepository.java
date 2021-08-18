package br.com.correntedobembackend.correntedobembackend.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.correntedobembackend.correntedobembackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
