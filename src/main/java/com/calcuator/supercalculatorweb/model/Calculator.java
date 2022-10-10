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
    private String expResult;

    public Calculator() {
    }

    public String trimResult(){;
        if (expResult.endsWith(".0"))
            expResult = expResult.replaceAll(".0", "");
        return expResult;
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

    public String getResult() {
        return expResult;
    }

    public void setResult(String result) {
        this.expResult = result;
    }
}
