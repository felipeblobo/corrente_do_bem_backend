package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.Address;
import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.repository.CauseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cause")
public class CauseController {
    @Autowired
    CauseRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Cause> list() {
        ArrayList<Cause> all =(ArrayList<Cause>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public Cause getById (@PathVariable Integer id) {
        Optional<Cause> cause = (Optional<Cause>)repository.findById(id);

        if(cause.isPresent()){
            return cause.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cause not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Cause update(@RequestBody Cause cause, @PathVariable int id){
        Optional<Cause> causeToUpdate = repository.findById(id);

        if(causeToUpdate.isPresent()){
            cause.setId(id);
            return repository.save(cause);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cause not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCause(@RequestBody Cause cause) {
        repository.save(cause);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
