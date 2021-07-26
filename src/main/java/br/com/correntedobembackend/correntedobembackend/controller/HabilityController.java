package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.Cause;
import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.repository.HabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("hability")
public class HabilityController {

    @Autowired
    HabilityRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Hability> list() {
        ArrayList<Hability> all =(ArrayList<Hability>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public Hability getById (@PathVariable Integer id) {
        Optional<Hability> hability = (Optional<Hability>)repository.findById(id);

        if(hability.isPresent()){
            return hability.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hability not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Hability update(@RequestBody Hability hability, @PathVariable int id){
        Optional<Hability> habilityToUpdate = repository.findById(id);

        if(habilityToUpdate.isPresent()){
            hability.setId(id);
            return repository.save(hability);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hability not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addHability(@RequestBody Hability hability) {
        repository.save(hability);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
