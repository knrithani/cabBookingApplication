package com.project.cabbooking.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AdminAccount {
    @Id
    @GeneratedValue
    private Integer id;
    private String cdsId;
    private String password;

    public AdminAccount() {
    }

    public AdminAccount(String cdsId, String password) {
        this.cdsId = cdsId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCdsId() {
        return cdsId;
    }

    public void setCdsId(String cdsId) {
        this.cdsId = cdsId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
