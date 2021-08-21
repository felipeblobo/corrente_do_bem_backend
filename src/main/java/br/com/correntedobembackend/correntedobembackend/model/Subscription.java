package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Subscription")
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private User user;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private Date date;
    private String status;

    public Subscription() {

    }

    public Subscription(int id, int i, int i1, String s, String cancelada) {

    }

    public Subscription(int id, User user, Project project, Date date, String status) {
        this.id = id;
        this.user = user;
        this.project = project;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
