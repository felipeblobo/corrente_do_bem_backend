package Models;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private int id;
    private int type;
    private String name;
    private String img;
    private String phone;
    private String email;
    private String password;
    private Date birth_date;
    private String document;
    private String street;
    private String address_number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private ArrayList<Cause> causes = new ArrayList<Cause>();
    private ArrayList<Hability> habilities = new ArrayList<Hability>();


    public User(int id, int type, String name, String phone, String email, String password,
                Date birth_date, String document, String img, String street, String address_number,
                String complement, String neighborhood, String city, String state, ArrayList<Cause> causes,
                ArrayList<Hability> habilities) {

        this.id = id;
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.document = document;
        this.img = img;
        this.street = street;
        this.address_number = address_number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.causes = causes;
        this.habilities = habilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<Cause> getCauses() {
        return causes;
    }

    public void setCauses(ArrayList<Cause> causes) {
        this.causes = causes;
    }

    public ArrayList<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(ArrayList<Hability> habilities) {
        this.habilities = habilities;
    }
}
