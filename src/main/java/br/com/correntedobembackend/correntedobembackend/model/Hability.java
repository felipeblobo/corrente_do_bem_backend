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

    public Hability(int id, String label, String value, String img) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.img = img;
    }
}
