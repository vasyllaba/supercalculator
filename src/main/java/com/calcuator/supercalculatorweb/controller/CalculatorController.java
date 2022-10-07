package com.calcuator.supercalculatorweb.controller;

import com.calcuator.supercalculatorweb.service.CalculatorService;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}
