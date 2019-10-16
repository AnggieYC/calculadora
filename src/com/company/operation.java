package com.company;
import java.util.Scanner;
import java.util.Stack;

public class operation {
    public String ToPostfixed (String Infix)
    {
        String Postfixed = "";

        String[] arrayInfix = Infix.split(" ");

        Stack < String > E = new Stack < String > ();
        Stack < String > P = new Stack < String > ();
        Stack < String > S = new Stack < String > ();

        for (int i = arrayInfix.length - 1; i >= 0; i--) {
            E.push(arrayInfix[i]);
        }

        while (!E.isEmpty()) {
            switch (precedence(E.peek())) {
                case 1:
                    P.push(E.pop());
                    break;
                case 3:
                case 4:
                    while (precedence(P.peek()) >= precedence(E.peek())) {
                        S.push(P.pop());
                    }
                    P.push(E.pop());
                    break;
                case 2:
                    while (!P.peek().equals("(")) {
                        S.push(P.pop());
                    }
                    P.pop();
                    E.pop();
                    break;
                default:
                    S.push(E.pop());
            }
        }

        Postfixed = S.toString().replaceAll("[\\]\\[,]", "");

        return Postfixed;
    }
}
