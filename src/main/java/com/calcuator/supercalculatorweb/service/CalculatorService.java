package com.calcuator.supercalculatorweb.service;

import com.calcuator.supercalculatorweb.model.Calculator;
import com.calcuator.supercalculatorweb.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {
    private final CalculatorRepository calculatorRepository;

    @Autowired
    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public Calculator getById(Long id) {
        return calculatorRepository.findById(id).get();
    }

    public List<Calculator> getAll() {
        return calculatorRepository.findAll();
    }

    public Calculator save(Calculator calculator) {
        return calculatorRepository.save(calculator);
    }

    public Calculator update(Calculator calculator, Long id){
        calculator.setId(id);
        return calculatorRepository.save(calculator);
    }

    public void delete(Calculator calculator){
        calculatorRepository.delete(calculator);
    }
}
