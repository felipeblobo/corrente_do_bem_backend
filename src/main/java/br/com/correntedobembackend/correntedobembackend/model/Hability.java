package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hability")
public class Hability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;
    private String value;
    private String img;
}
