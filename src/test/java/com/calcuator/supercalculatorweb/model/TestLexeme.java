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
        Assert.assertEquals(7.6, result, 0.0015);
    }

    @Test
    public void testNumbersWithSpaces() {
        String str = "3 + 2 2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(25.0, result, 0.0015);
    }

    @Test
    public void testNegativeNumbers() {
        String str = "3 + -2";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(1.0, result, 0.0015);
    }

    @Test
    public void testNegativeNumbers2() {
        String str = "4*-7";
        List lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
        Assert.assertEquals(-28.0, result, 0.0015);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectInput() {
        String str = "3+*4";
        List<Lexeme> lexemes = Lexeme.lexAnalyze(str);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        double result = Lexeme.expr(lexemeBuffer);
    }



}
