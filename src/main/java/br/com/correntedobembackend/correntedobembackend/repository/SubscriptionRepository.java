package br.com.correntedobembackend.correntedobembackend.repository;

import br.com.correntedobembackend.correntedobembackend.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer> {
}
