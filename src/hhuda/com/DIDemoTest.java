package hhuda.com;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class DIDemoTest {

    @Test
    public void postButtonClicked() {
        System.out.println("Tested Started");
        TextField textField =new TextField();
        textField.setText("Button Text is test");
        DIDemo diDemo =new DIDemo(textField);
        diDemo.postButtonClicked();
    }

    // Write a main method only if:
    //     - you don't want to give the runner in the command line and
    //     - you want your class to be self-executable.
    public static void main(String[] args) {
        System.out.println("Test Main Started");
        //org.junit.runner.JUnitCore.main("hhuda.com.DIDemoTest");
    }
}
