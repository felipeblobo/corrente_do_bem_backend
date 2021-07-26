package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.User;
import br.com.correntedobembackend.correntedobembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public User update(@RequestBody User user, @PathVariable int id){
        Optional<User> userToUpdate = repository.findById(id);

        if(userToUpdate.isPresent()){
            user.setId(id);
            return repository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        repository.save(user);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}