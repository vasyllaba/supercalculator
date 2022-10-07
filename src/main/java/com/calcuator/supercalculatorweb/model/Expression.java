package com.calcuator.supercalculatorweb.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Expression {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String exp;

    @Column
    @NotNull
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
