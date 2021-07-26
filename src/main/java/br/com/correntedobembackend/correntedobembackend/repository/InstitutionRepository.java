package br.com.correntedobembackend.correntedobembackend.repository;

import br.com.correntedobembackend.correntedobembackend.model.Institution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Integer> {

}
