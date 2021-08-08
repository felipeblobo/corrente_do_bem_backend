package br.com.correntedobembackend.correntedobembackend.controller;

import br.com.correntedobembackend.correntedobembackend.model.Institution;
import br.com.correntedobembackend.correntedobembackend.model.Project;
import br.com.correntedobembackend.correntedobembackend.model.Project;
import br.com.correntedobembackend.correntedobembackend.repository.ProjectCustomRepository;
import br.com.correntedobembackend.correntedobembackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectRepository repository;
    @Autowired
    ProjectCustomRepository customRepository;



    @RequestMapping(method = RequestMethod.GET)
    public List<Project> findFiltered(
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "institution_id", required = false) Integer institution_id,
            @RequestParam(value = "local_type", required = false) String local_type
    ){
        return customRepository.find(status, q,institution_id,local_type);
    }

    @GetMapping(path = {"/{id}"})
    public Project getById (@PathVariable Integer id) {
        Optional<Project> project = (Optional<Project>)repository.findById(id);

        if(project.isPresent()){
            return project.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(path = {"/{id}"})
    public Project update(@RequestBody Project project, @PathVariable int id){
        Optional<Project> projectToUpdate = repository.findById(id);

        if(projectToUpdate.isPresent()){
            project.setId(id);
            return repository.save(project);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody Project project) {
        repository.save(project);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }


}
