/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.calculator;

/**
 *
 * @author Kim
 */
import java.math.BigDecimal;

import java.util.List;


public interface Tokenizer {

  public List<Token> tokenize(String formula);

  public void addOperation(Operation operation);

  public void addFunction(Function function);

  public void addConstant(String name, BigDecimal value);

}
