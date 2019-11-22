package com.sovy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "order")
@Entity
@Table(name = "Pouzivatel")
public class Customer implements Serializable {

    /*@XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "firstname")
    private String firstname;
    @XmlElement(name = "lastname")
    private String lastname;
    @XmlElement(name = "idbook")
    private int idbook;*/
    public Customer(String Firstname, String Lastname, String Address, String Sex, String Postalcode, String email, String password, String datumregistracie, String rola, String preferedLang, String mena) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Address = Address;
        this.Sex = Sex;
        this.Postalcode = Postalcode;
        this.email = email;
        this.password = password;
        this.datumregistracie = datumregistracie;
        this.rola = rola;
        this.preferedLang = preferedLang;
        this.mena = mena;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Firstname")
    private String Firstname;

    @Column(name = "Lastname")
    private String Lastname;
    
    
    @Column(name = "Address")
    private String Address;

    @Column(name = "Sex")
    private String Sex;

    @Column(name = "Postalcode")
    private String Postalcode;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "datumregistracie")
    private String datumregistracie;

    @Column(name = "rola")
    private String rola;

    @Column(name = "preferedLang")
    private String preferedLang;

    @Column(name = "mena")
    private String mena;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPostalcode() {
        return Postalcode;
    }

    public void setPostalcode(String Postalcode) {
        this.Postalcode = Postalcode;
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

    public String getDatumregistracie() {
        return datumregistracie;
    }

    public void setDatumregistracie(String datumregistracie) {
        this.datumregistracie = datumregistracie;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getPreferedLang() {
        return preferedLang;
    }

    public void setPreferedLang(String preferedLang) {
        this.preferedLang = preferedLang;
    }

    public String getMena() {
        return mena;
    }

    public void setMena(String mena) {
        this.mena = mena;
    }

}
