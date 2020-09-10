package com.hhuda;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class DIDemoTest {

    @Test
    public void postButtonClicked() {
        System.out.println("Tested Started");

        TextField textField =new TextField();
        textField.setText("Button Text is test");

        DIDemo diDemo =new DIDemo(textField);
        Assert.assertNotEquals("Hello DI",diDemo.postButtonClicked());

        System.out.println("Test Completed Successfully");
    }

    // Write a main method only if:
    //     - you don't want to give the runner in the command line and
    //     - you want your class to be self-executable.
    public static void main(String[] args) {
        System.out.println("Test Main Started");
        //org.junit.runner.JUnitCore.main("DIDemoTest");
    }
}
