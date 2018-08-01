/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.calculator;

import java.math.BigDecimal;

/**
 *
 * @author Kim
 */
public class ArgumentToken implements Token {

    private BigDecimal[] bigDecimals;

    public ArgumentToken(BigDecimal... bigDecimals) {
        assert bigDecimals != null;
        this.bigDecimals = bigDecimals;
    }

    public BigDecimal[] getArguments() {
        return bigDecimals;
    }

}
