/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.calculator;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Kim
 */


public enum Tokens {

    ;

    @SuppressWarnings("unchecked")
    private static <T extends Token> Iterable<T> iterable(Token token, Class<T> clazz) {
        return clazz.isAssignableFrom(token.getClass())
                ? Arrays.asList((T) token)
                : Collections.<T>emptyList();
    }

    public static Iterable<NumberToken> number(Token token) {
        return iterable(token, NumberToken.class);
    }

    public static Iterable<ArgumentToken> argument(Token token) {
        return iterable(token, ArgumentToken.class);
    }

    public static Iterable<Operation> operation(Token token) {
        return iterable(token, Operation.class);
    }

    public static Iterable<Function> function(Token token) {
        return iterable(token, Function.class);
    }

}