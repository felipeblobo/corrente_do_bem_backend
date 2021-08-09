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
}
