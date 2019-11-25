/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author stefan.tomasik
 */
@Entity
@Table(name = "Settings")
public class Settings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //  @OneToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)  
    //  private Customer customer;
    @Column(name = "preferedLang")
    String preferedLang;

    @Column(name = "mena")
    String mena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*  public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
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
