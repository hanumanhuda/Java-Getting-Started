package com.hhuda;

import java.awt.*;

public class DIFactory {

    TextField textField;
    public DIFactory(TextField textField){
        this.textField = textField;
    }

    public String postButtonClicked(){
        String text = textField.getText();
        if (text.length() > 140) {
            Shortener shortener = ShortenerFactory.get();
            text =shortener.shorten(text);
        }
        if( text.length() < 140 ){
            Tweeter tweeter = TweeterFactory.get();
            return tweeter.send(text);
        }
        return null;
    }
}

class ShortenerFactory{
    static Shortener shortener;
    public static Shortener get(){
        if (shortener != null)
            return shortener;
        return new TinyUrlShortener();
    }

    public static void setShortener(Shortener shortener1){
        shortener = shortener1;
    }
}


class TweeterFactory{
    static Tweeter tweeter;
    public static Tweeter get(){
        if (tweeter != null)
            return tweeter;
        return new SMSTweeter();
    }
    public static void setTweeter(Tweeter tweeter1){
        tweeter = tweeter1;
    }
}
