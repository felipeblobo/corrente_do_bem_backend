package br.com.correntedobembackend.correntedobembackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String img;
    private String email;
    private String summary;
    private String cnpj;
    private String phone;
    private String site;
    private String facebook;
    private String instagram;
    private String bio;

    public Institution() {

    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "institution_cause",
            joinColumns = @JoinColumn(name = "institution_id"),
            inverseJoinColumns = @JoinColumn(name = "cause_id"))
    private List<Cause> causes;

    public Institution(int id, String name, String img, String email, String summary, String cnpj, String phone,
                       String site, String facebook, String instagram, String bio, Address address,
                       List<Cause> causes) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.email = email;
        this.summary = summary;
        this.cnpj = cnpj;
        this.phone = phone;
        this.site = site;
        this.facebook = facebook;
        this.instagram = instagram;
        this.bio = bio;
        this.address = address;
        this.causes = causes;
    }

    public Institution(int id, String cozinhando_amor, String img, String email, String summary, String cnpj, String phone, String site, String aNull, String instagram,
                       String bio) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }
}
