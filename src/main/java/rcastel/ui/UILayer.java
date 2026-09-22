package rcastel.ui;

import java.util.ArrayList;

public abstract class UILayer {
    public abstract void write(ArrayList<String> messages);
    public abstract String ask(String message, ArrayList<String> options);
}