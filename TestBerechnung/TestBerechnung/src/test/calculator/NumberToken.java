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
public class NumberToken implements Token {

    private final BigDecimal bd;

    public NumberToken(BigDecimal bigDecimal) {
        assert bigDecimal != null;
        this.bd = bigDecimal;
    }

    public BigDecimal getNumber() {
        return bd;
    }

}
