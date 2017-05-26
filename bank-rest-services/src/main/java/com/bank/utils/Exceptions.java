package com.bank.utils;
import java.util.concurrent.Callable;

public class Exceptions {

    public static <T> T uncheck(Callable<T> function) {
        try {
            return function.call();
        } catch (Exception e) {
        	
            throw new RuntimeException("Invalid intrest calculatuion request: " + e.getMessage());
        }
    }

    public static <T> T ignore(Callable<T> function) {
        try {
            return function.call();
        } catch (Exception e) {
            return null;
        }
    }

}