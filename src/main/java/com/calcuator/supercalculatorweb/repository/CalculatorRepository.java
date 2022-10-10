package com.calcuator.supercalculatorweb.repository;

import com.calcuator.supercalculatorweb.model.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorRepository  extends JpaRepository <Calculator, Long> {
    List<Calculator> findAllByExpResult(String result);
}
