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

    public Project() {

    }

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

    public Project(int id, int status, String title, String img, String local_type, String description, int popularity,
                   Institution institution, List<Cause> causes, List<Hability> habilities) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.img = img;
        this.local_type = local_type;
        this.description = description;
        this.popularity = popularity;
        this.institution = institution;
        this.causes = causes;
        this.habilities = habilities;
    }

    public Project(int id, int status, String title, String img, String local, int i, String s) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLocal_type() {
        return local_type;
    }

    public void setLocal_type(String local_type) {
        this.local_type = local_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }

    public List<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(List<Hability> habilities) {
        this.habilities = habilities;
    }
}