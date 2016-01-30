package springbook.learningtest.spring.factorybean;

/**
 * Created by dw on 2016. 1. 30..
 */
public class Message {
    String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }
}
