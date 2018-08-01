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
public enum Function implements Token {

    MIN("min") {
        public BigDecimal calculate(BigDecimal... values) {
            BigDecimal result = null;
            for (BigDecimal bd : values) {
                result = result == null ? bd : result.min(bd);
            }
            return result;
        }

        public boolean hasArity(int count) {
            return count > 0;
        }
    },

    MAX("max") {
        public BigDecimal calculate(BigDecimal... values) {
            BigDecimal result = null;
            for (BigDecimal bd : values) {
                result = result == null ? bd : result.max(bd);
            }
            return result;
        }

        public boolean hasArity(int count) {
            return count > 0;
        }
    },


    ABS("abs") {
        public BigDecimal calculate(BigDecimal... values) {
            return values[0].abs();
        }

        public boolean hasArity(int count) {
            return count == 1;
        }
    };

    private final String name;

    Function(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean hasArity(int count);

    public abstract BigDecimal calculate(BigDecimal... values);

}
