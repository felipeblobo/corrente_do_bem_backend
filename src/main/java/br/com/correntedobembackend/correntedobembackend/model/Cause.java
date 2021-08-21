package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cause")

public class Cause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;
    private String value;
    private String img;

    public Cause() {

    }

    public Cause(int id, String label, String value, String img) {
        this.id = id;
        this.label = label;
        this.value = value;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
