package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.Address;
import br.com.correntedobembackend.correntedobembackend.model.Address;
import br.com.correntedobembackend.correntedobembackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Address> list() {
        ArrayList<Address> all =(ArrayList<Address>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public Address getById (@PathVariable Integer id) {
        Optional<Address> address = (Optional<Address>)repository.findById(id);

        if(address.isPresent()){
            return address.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Address update(@RequestBody Address address, @PathVariable int id){
        Optional<Address> addressToUpdate = repository.findById(id);

        if(addressToUpdate.isPresent()){
            address.setId(id);
            return repository.save(address);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address) {
        repository.save(address);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
