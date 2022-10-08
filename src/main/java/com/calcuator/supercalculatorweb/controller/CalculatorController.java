package com.calcuator.supercalculatorweb.controller;

import com.calcuator.supercalculatorweb.model.Calculator;
import com.calcuator.supercalculatorweb.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/aa")
    public String index(Map<String, Object> model) {
        List<Calculator> goals = calculatorService.getAll();
        return "index";
    }

    @GetMapping("/calculation")
    public String list(Map<String, Object> model) {
        model.put("calculations", calculatorService.getAll());
        return "calculation";
    }

    @GetMapping("/")
    public String addPage(Model model) {
        model.addAttribute("calculator", new Calculator());
        model.addAttribute("btnSubmit", "Calculate");
        return "index";
    }

    @PostMapping("/calculator/add")
    public String add(@ModelAttribute("calculator") Calculator calculator, BindingResult bindingResult, Model model,
                      @RequestParam(value = "id", required = false) Long id) {
        if (bindingResult.hasErrors()){
            if (id==null)
            {
                model.addAttribute("btnSubmit", "Create");
            }else {
                model.addAttribute("btnSubmit", "Save");
            }
            return "add";
        }
        if (id==null)
        {
            model.addAttribute("btnSubmit", "Create");
        }else {
            model.addAttribute("btnSubmit", "Save");
        }
        calculatorService.save(calculator);
        return "index";
    }
}
