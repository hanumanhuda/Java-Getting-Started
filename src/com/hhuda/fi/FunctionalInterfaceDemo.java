package com.hhuda.fi;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterfaceDemo=new FunctionalInterfaceDemo();
        functionalInterfaceDemo.predicate();



    }

    private void predicate() {
        Predicate<String> predicate= (str)-> str.startsWith("H");

        List<String> names= Arrays.asList("Hanuman","Huda","Birloka");
        names.forEach(name -> {
            if (predicate.test(name)){
                System.out.println(name);
            }
        });
    }
}
