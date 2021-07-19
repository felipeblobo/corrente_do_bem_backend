package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String state;
    private String street;
    private String address_number;
    private String complement;
    private String neighborhood;
    private String zip_code;
}
