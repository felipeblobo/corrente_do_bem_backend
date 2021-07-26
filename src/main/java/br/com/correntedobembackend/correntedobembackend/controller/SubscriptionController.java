package br.com.correntedobembackend.correntedobembackend.controller;


import br.com.correntedobembackend.correntedobembackend.model.Project;
import br.com.correntedobembackend.correntedobembackend.model.Subscription;
import br.com.correntedobembackend.correntedobembackend.model.Subscription;
import br.com.correntedobembackend.correntedobembackend.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Subscription> list() {
        ArrayList<Subscription> all =(ArrayList<Subscription>) repository.findAll();
        return all;
    }

    @GetMapping(path = {"/{id}"})
    public Subscription getById (@PathVariable Integer id) {
        Optional<Subscription> subscription = (Optional<Subscription>)repository.findById(id);

        if(subscription.isPresent()){
            return subscription.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Subscription update(@RequestBody Subscription subscription, @PathVariable int id){
        Optional<Subscription> subscriptionToUpdate = repository.findById(id);

        if(subscriptionToUpdate.isPresent()){
            subscription.setId(id);
            return repository.save(subscription);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubscription(@RequestBody Subscription subscription) {
        repository.save(subscription);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
