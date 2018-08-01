/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
//import java.text.ParseException;
import test.calculator.ParseException;

/**
 *
 * @author Kim
 */
public enum Operation implements Token {

    ADD("+", 1) {
        public BigDecimal calculate(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    },

    SUBTRACT("-", 1) {
        public BigDecimal calculate(BigDecimal a, BigDecimal b) {
            return a.subtract(b);
        }
    },

    MULTIPLY("*", 2) {
        public BigDecimal calculate(BigDecimal a, BigDecimal b) {
            return a.multiply(b);
        }
    },

    DIVIDE("/", 2) {
        public BigDecimal calculate(BigDecimal a, BigDecimal b) {
            return a.divide(b, scale, roundingMode);
        }
    },


    POW("^", 3) {
        public BigDecimal calculate(BigDecimal n1, BigDecimal n2) {
            BigDecimal result = null;
            int signOf2 = n2.signum();
            try {
                double dn1 = n1.doubleValue();
                n2 = n2.multiply(new BigDecimal(signOf2));
                BigDecimal remainderOf2 = n2.remainder(BigDecimal.ONE);
                BigDecimal n2IntPart = n2.subtract(remainderOf2);
                BigDecimal intPow = n1.pow(n2IntPart.intValueExact(), MathContext.DECIMAL64);
                BigDecimal doublePow =
                        new BigDecimal(Math.pow(dn1, remainderOf2.doubleValue()));
                result = intPow.multiply(doublePow);
            } catch (Exception e) {
                throw new ParseException("Problem while calculating the power", e);
            }
            if (signOf2 == -1)
                result = BigDecimal.ONE.divide(result, scale, roundingMode);
            return result;
        }
    };

    private static RoundingMode roundingMode = RoundingMode.HALF_UP;

    private static int scale = 16;

    private final int priority;

    private final String name;

    Operation(String name, int priority) {
        this.priority = priority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public abstract BigDecimal calculate(BigDecimal a, BigDecimal b);

    public static RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public static void setRoundingMode(RoundingMode roundingMode) {
        Operation.roundingMode = roundingMode;
    }

    public static int getDevisionPrecision() {
        return scale;
    }

    public static void setDivisionPrecision(int precision) {
        Operation.scale = precision;
    }

}
