package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int status;
    private String title;
    private String img;
    private String local_type;
    private String description;
    private int popularity;

    @OneToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToMany
    @JoinTable(name = "project_cause",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "cause_id"))
    private List<Cause> causes;

    @ManyToMany
    @JoinTable(name = "project_hability",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "hability_id"))
    private List<Hability> habilities;
}
