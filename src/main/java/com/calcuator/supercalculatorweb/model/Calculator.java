package com.calcuator.supercalculatorweb.model;

import javax.persistence.*;

@Entity
@Table
public class Calculator {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String expression;

    @Column(nullable = true)
    private Double result;

    public Calculator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
