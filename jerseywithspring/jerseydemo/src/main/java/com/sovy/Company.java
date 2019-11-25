/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author stefan.tomasik
 */
public class Company {

    public Company(Long id, String ico) {
        this.id = id;
        this.ico = ico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "ICO")
    private String ico;

}
