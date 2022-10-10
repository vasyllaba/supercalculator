package com.calcuator.supercalculatorweb.model;

import com.calcuator.supercalculatorweb.model.enums.LexemeType;

import java.util.ArrayList;
import java.util.List;

public class Lexeme {
    LexemeType type;
    String value;

    public LexemeType getType() {
        return type;
    }

    public Lexeme(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Lexeme(LexemeType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        checkBrackets(expText);
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        expText = expText.replaceAll("\\s+", "");
        int pos = 0;
        char c, prev;
        while (pos < expText.length()) {
            prev = (pos > 0) ? expText.charAt(pos - 1) : 'n';
            c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                case '-':
                    if (isNumber(prev)) {
                        lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                        pos++;
                        continue;
                    }
                default:
                    if (isNumber(c) || c == '.' || c == '-') {
                        StringBuilder sb = new StringBuilder();
                        negativeNumbersCheck(c, sb.toString());
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0' || c == '.');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    private static void negativeNumbersCheck(char symbol, String str) {
        if (symbol == '-' && str.contains("-"))
            throw new RuntimeException("Unexpected character: " + symbol);
    }

    private static boolean isNumber(char sym) {
        if (sym <= '9' && sym >= '0')
            return true;
        return false;
    }

    private static void checkBrackets(String str) {
        int lBrackets = 0, rBrackets = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                lBrackets++;
            }
            if (c == ')') {
                rBrackets++;
            }
        }
        if (lBrackets != rBrackets)
            throw new RuntimeException("The brackets are not placed correctly");
    }

    public static double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusMinus(lexemes);
        }
    }

    public static double plusMinus(LexemeBuffer lexemes) {
        double value = multDiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multDiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multDiv(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    public static double multDiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    public static double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case LEFT_BRACKET:
                double value = expr(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value + " at position " + lexemes.getPos());
        }
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}