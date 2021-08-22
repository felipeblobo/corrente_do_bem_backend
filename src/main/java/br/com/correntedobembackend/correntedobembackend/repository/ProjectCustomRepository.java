package br.com.correntedobembackend.correntedobembackend.repository;

import br.com.correntedobembackend.correntedobembackend.model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProjectCustomRepository {

    //Entity manager - connection with JPA
    private final EntityManager em;

    public ProjectCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Project> find(Integer status, String q, Integer institution_id, String local_type, Integer cause_id, Integer hability_id){
        String query = "Select P from Project as P ";
        
        if(cause_id == null && hability_id == null) {
            query = "Select P from Project as P ";
        }
        if(cause_id == null && hability_id != null) {
            query = "Select P from Project as P JOIN FETCH P.habilities H ";
        }
        if(cause_id != null && hability_id == null) {
            query = "Select P from Project as P JOIN FETCH P.causes C ";
        }

        if(cause_id != null && hability_id != null) {
            query = "Select P from Project as P JOIN FETCH P.causes C JOIN FETCH P.habilities H ";
        }

        String condition = "where ";

        if(status != null){
            query += condition + "P.status = :status";
            condition = " and ";
        }

        if(q != null){
            query += condition + "CONCAT(P.title, P.description, P.institution.name, P.institution.address.city) LIKE CONCAT('%',:q,'%')";
            condition = " and ";
        }

        if(institution_id != null){
            query += condition + "P.institution.id = :institution_id";
            condition = " and ";
        }

        if(local_type != null){
            query += condition + "P.local_type = :local_type";
            condition = " and ";
        }

        if(cause_id != null){
            query += condition + "C.id = :cause_id";
            condition = " and ";
        }

        if(hability_id != null){
            query += condition + "H.id = :hability_id";
            condition = " and ";
        }

        if(institution_id != null){
            query += condition + "P.institution.id = :institution_id";
            condition = " and ";
        }

        TypedQuery<Project> implementedQuery = em.createQuery(query, Project.class);

        if(status != null){
            implementedQuery.setParameter("status", status);
        }

        if(q != null){
            implementedQuery.setParameter("q",q);
        }

        if(institution_id != null){
            implementedQuery.setParameter("institution_id",institution_id);
        }

        if(local_type != null){
            implementedQuery.setParameter("local_type",local_type);
        }

        if(cause_id != null){
            implementedQuery.setParameter("cause_id", cause_id);
        }

        if(hability_id != null){
            implementedQuery.setParameter("hability_id", hability_id);
        }

        return new ArrayList<>(implementedQuery.getResultList());
    }
}
