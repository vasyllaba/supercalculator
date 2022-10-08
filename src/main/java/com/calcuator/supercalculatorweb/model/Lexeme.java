package com.calcuator.supercalculatorweb.model;

import com.calcuator.supercalculatorweb.model.enums.LexemeType;

public class Lexeme {
    LexemeType type;
    String value;

    public Lexeme(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Lexeme(LexemeType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }
}
