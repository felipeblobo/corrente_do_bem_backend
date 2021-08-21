package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.Hability;
import br.com.correntedobembackend.correntedobembackend.model.Institution;
import br.com.correntedobembackend.correntedobembackend.model.Institution;
import br.com.correntedobembackend.correntedobembackend.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    InstitutionRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Institution> list() {
        ArrayList<Institution> all =(ArrayList<Institution>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public Institution getById (@PathVariable Integer id) {
        Optional<Institution> institution = (Optional<Institution>)repository.findById(id);

        if(institution.isPresent()){
            return institution.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Institution not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Institution update(@RequestBody Institution institution, @PathVariable int id){
        Optional<Institution> institutionToUpdate = repository.findById(id);

        if(institutionToUpdate.isPresent()){
            institution.setId(id);
            return repository.save(institution);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Institution not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Institution addInstitution(@RequestBody Institution institution) {
        return repository.save(institution);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
