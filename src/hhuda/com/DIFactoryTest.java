package hhuda.com;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

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
        Assert.assertEquals("Hello DI",diDemo.postButtonClicked());

        System.out.println("Test Completed Successfully");
    }
}