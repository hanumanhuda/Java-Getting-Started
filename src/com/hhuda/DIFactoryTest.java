package com.hhuda;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DIFactoryTest {

    @Test
    public void postButtonClicked() {
        System.out.println("Tested Started");
        TextField textField =new TextField();
        textField.setText("Button Text is test");

        Tweeter tweeter;
        tweeter = mock(SMSTweeter.class);
        TweeterFactory.setTweeter(tweeter);
        when(tweeter.send(anyString())).thenReturn("Hello DI");

        //here tweeter.send can mocked so which will not call actual method
        DIFactory diDemo =new DIFactory(textField);
        assertEquals("Hello DI",diDemo.postButtonClicked());

        //Issues: EOP, Dependencies has to be cleaned up otherwise can impact other test cases.
        //TweeterFactory.setTweeter(null); and this should be in finally to execute it safely

        System.out.println("Test Completed Successfully");
    }
}