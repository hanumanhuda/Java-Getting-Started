package com.hhuda.fi.lambda;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> scores=new ArrayList<>();
        scores.add(10);
        scores.add(20);

        LambdaDemo lambdaDemo=new LambdaDemo();
        lambdaDemo.printScores(scores);
        scores = lambdaDemo.updateScores(scores);
        lambdaDemo.printScores(scores);
        System.out.println(lambdaDemo.sumScores(scores));
    }

    private int sumScores(List<Integer> scores) {
        return scores.stream().map((score)-> score)
                .mapToInt(Integer::intValue)
                .sum();

    }

    private List<Integer> updateScores(List<Integer> scores) {
        return scores.stream().map( score -> (int)(score+.10*score)).collect(Collectors.toList());
    }

    private void printScores(List<Integer> scores) {
        scores.forEach(score -> {
            System.out.println(score);
        });

    }
}
