package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import java.util.Map;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repository;

    private final PasswordEncoder encoder;

    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> list() {
        ArrayList<User> all =(ArrayList<User>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public User getById (@PathVariable Integer id) {
        Optional<User> user = (Optional<User>)repository.findById(id);

        if(user.isPresent()){
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @GetMapping(path = {"/email"})
    public User getByEmail (@RequestParam String email) {
        Optional<User> user = (Optional<User>)repository.findByEmail(email);

        if(user.isPresent()){
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public User update(@RequestBody User user, @PathVariable int id){
        Optional<User> userToUpdate = repository.findById(id);
        User oldUser = repository.findById(id).get();

        if(userToUpdate.isPresent()){
            user.setId(id);
            user.setPassword(oldUser.getPassword());
            return repository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {

        if(repository.findByEmail(user.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email is already being used.");
        }

        user.setType(1);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }


    @GetMapping("/passwordvalidation")
    public ResponseEntity<Boolean> passwordValidation(@RequestParam String email, @RequestParam String password) {

        Optional<User>optUser = repository.findByEmail(email);
        if(!optUser.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optUser.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

}
