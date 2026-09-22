package rcastel.ui;

import java.util.ArrayList;

public class Console extends UILayer {

    @Override
    public void write(ArrayList<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    @Override
    public String ask(String message, ArrayList<String> options) {
        System.out.println(message);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        return null;
    }

}