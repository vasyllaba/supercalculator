package com.calcuator.supercalculatorweb.controller;

import com.calcuator.supercalculatorweb.model.Calculator;
import com.calcuator.supercalculatorweb.model.Lexeme;
import com.calcuator.supercalculatorweb.model.LexemeBuffer;
import com.calcuator.supercalculatorweb.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String addPage(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "index";
    }

    @GetMapping("/calculation")
    public String list(Map<String, Object> model) {
        model.put("calculations", calculatorService.getAll());
        return "calculation";
    }

    @PostMapping("/calculator/add")
    public String add(@ModelAttribute("expression") String expression, Model model) {
        Calculator calculator = new Calculator(expression);
        model.addAttribute("calculator", calculator);
        try{
            LexemeBuffer lexemeBuffer = new LexemeBuffer(Lexeme.lexAnalyze(expression));
            calculator.setResult(Lexeme.expr(lexemeBuffer));
        }catch(RuntimeException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "index";
        }
        calculatorService.save(calculator);
        return "index";
    }

    @GetMapping("/calculation/edit")
    public String edit(@RequestParam(name="id")Long id, Model model) {
        model.addAttribute("calculator", calculatorService.getById(id));
        return "edit";
    }

    @PostMapping("/calculation/edit")
    public String update(@RequestParam(name="id")Long id,
                         @ModelAttribute("calculation") Calculator calculation, Model model) {
        try{
            LexemeBuffer lexemeBuffer = new LexemeBuffer(Lexeme.lexAnalyze(calculation.getExpression()));
            calculation.setResult(Lexeme.expr(lexemeBuffer));
        }catch(RuntimeException e){
            model.addAttribute("id", calculation.getId());
            model.addAttribute("errorMessage", e.getMessage());
            return "edit";
        }
        calculatorService.update(calculation, id);
        model.addAttribute("calculations", calculatorService.getAll());
        return "calculation";
    }

    @PostMapping("/calculation/search")
    public String searchByResult(@ModelAttribute("search") String search,
                                 @ModelAttribute("search-param") String searchParam,
                                 Model model) {
        try{
            model.addAttribute("calculations", calculatorService.getByResultWithSearchParam(Double.valueOf(search), searchParam));
        }catch(NumberFormatException e){
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("calculations", calculatorService.getAll());
            return "calculation";
        }
        model.addAttribute("backBtn", true);
        return "calculation";
    }
}
