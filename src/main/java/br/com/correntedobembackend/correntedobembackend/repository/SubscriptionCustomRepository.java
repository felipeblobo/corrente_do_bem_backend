package br.com.correntedobembackend.correntedobembackend.repository;

import br.com.correntedobembackend.correntedobembackend.model.Subscription;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubscriptionCustomRepository {

    //Entity manager - connection with JPA
    private final EntityManager em;

    public SubscriptionCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Subscription> find(Integer user_id, Integer project_id, Integer institution_id, String status){

        String query = "Select S from Subscription as S ";
        String condition = "where ";

        if(user_id != null){
            query += condition + "S.user.id = :user_id";
            condition = " and ";
        }

        if(project_id != null){
            query += condition + "S.project.id = :project_id";
            condition = " and ";
        }

        if(institution_id != null){
            query += condition + "S.project.institution.id = :institution_id";
            condition = " and ";
        }

        if(status != null){
            query += condition + "S.status = :status";
            condition = " and ";
        }

        var implementedQuery = em.createQuery(query, Subscription.class);

        if(user_id != null){
            implementedQuery.setParameter("user_id", user_id);
        }

        if(project_id != null){
            implementedQuery.setParameter("project_id", project_id);
        }

        if(institution_id != null){
            implementedQuery.setParameter("institution_id", institution_id);
        }

        if(status != null){
            implementedQuery.setParameter("status", status);
        }

        return implementedQuery.getResultList()
                .stream()
                .collect(Collectors.toList());
    }
}
