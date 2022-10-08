package com.calcuator.supercalculatorweb.model;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestLexeme {
    @Test
    public void testPlus() {
        String str = "2 + 2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(4.0, result, 0);
    }

    @Test
    public void testMultiplication() {
        String str = "2 * 2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(4.0, result, 0);
    }

    @Test
    public void testNumber() {
        String str = "212";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(212.0, result, 0);
    }

    @Test
    public void testOperatorPriority() {
        String str = "2+2*2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(6.0, result, 0);
    }

    @Test
    public void testBracket() {
        String str = "(2+2)*2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(8.0, result, 0);
    }

    @Test
    public void testFactorialNumbers() {
        String str = "1.2 + 6.4";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(1.0, result, 0);
    }


    @Test
    public void testNegativeValues() {
        String str = "(3 + -(2))";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(1.0, result, 0);
    }


}
