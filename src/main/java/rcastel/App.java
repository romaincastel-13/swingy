package rcastel;

import jakarta.validation.constraints.*;

public class App {

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].equals("console") && !args[0].equals("gui")) {
           System.out.println("!ERROR! provide ONE argument: 'console' or 'gui' ");
           return;
        }
        System.out.printf("Hello %s!\n", args[0]);
    }
}
