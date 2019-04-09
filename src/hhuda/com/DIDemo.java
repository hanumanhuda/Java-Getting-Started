package hhuda.com;

import org.junit.Test;

import java.awt.*;

public class DIDemo {

    TextField textField;
    public DIDemo(TextField textField){
        this.textField = textField;
    }
    //this method is not testable because Dependencies are calling to real method so all
    //dependencies must execute to run this Test
    //this issue can be resolved by factory pattern or DI
    public void postButtonClicked(){
            String text = textField.getText();
            if (text.length() > 140){
                Shortener  shortener =  new TinyUrlShortener();
                text =shortener.shorten(text);
            }
            if( text.length() < 140 ){
                Tweeter tweeter = new SMSTweeter();
                tweeter.send(text);
            }
    }
}

interface Tweeter{
    void send(String text);
}

class SMSTweeter implements Tweeter{

    @Override
    public void send(String text) {
        System.out.println("SMSTweeter.send(): SMS Tweeter send the text as: "+text);
    }
}


interface Shortener{
    String shorten(String text);
}


class TinyUrlShortener implements Shortener{

    @Override
    public String shorten(String text) {
        System.out.println("TinyUrlShortener.shorten()");
        return text.substring(0,text.length()>140 ?140 : text.length());
    }
}