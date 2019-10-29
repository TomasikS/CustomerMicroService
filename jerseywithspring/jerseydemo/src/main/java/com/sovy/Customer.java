package com.sovy;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "order")
public class Customer implements Serializable {

    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "firstname")
    private String firstname;

    @XmlElement(name = "lastname")
    private String lastname;

    @XmlElement(name = "idbook")
    private int idbook;

    Customer(int id, String firstname, String lastname, int idbook) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.idbook = idbook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

}
