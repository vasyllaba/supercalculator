package com.calcuator.supercalculatorweb.controller;

import com.calcuator.supercalculatorweb.model.Calculator;
import com.calcuator.supercalculatorweb.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        List<Calculator> goals = calculatorService.getAll();
        return "index";
    }

    @GetMapping("/calculation")
    public String list(Map<String, Object> model) {
        model.put("calculations", calculatorService.getAll());
        return "calculation";
    }
}
