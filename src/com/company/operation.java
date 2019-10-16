package com.company;
import javafx.geometry.Pos;

import java.lang.Math;
import java.util.Scanner;
import java.util.Stack;

public class operation {
    public String ToPostfixed (String Infix) {
        String Postfixed = "";

        Infix = reduceOperator(Infix);

        String[] arrayInfix = Infix.split(" ");

        Stack<String> E = new Stack<String>();
        Stack<String> P = new Stack<String>();
        Stack<String> S = new Stack<String>();

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

    public int precedence (String op){
        int prf = 99;
        if (op.equals("^")) prf = 5;
        if (op.equals("*") || op.equals("/")) prf = 4;
        if (op.equals("+") || op.equals("-")) prf = 3;
        if (op.equals(")")) prf = 2;
        if (op.equals("(")) prf = 1;
        return prf;
    };

    boolean isOperand(char myChar){
        if (myChar>='0' && myChar<='9') return true;
        else if (myChar>='a' && myChar<='z') return true;
        else if (myChar>='A' && myChar<='Z') return true;
        return false;
    }

    boolean isVariable(char myChar){
        if (myChar>='a' && myChar<='z') return true;
        else if (myChar>='A' && myChar<='Z') return true;
        return false;
    }

    boolean isOperator(char myChar) {
        return myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/' || myChar == '^';
    }

    boolean isParentesis(char myChar){
        return myChar =='(' || myChar == ')';
    }
    boolean isLeftParentesis(char myChar){
        return myChar == '(';
    }
    boolean isRightParentesis(char myChar){
        return myChar == ')';
    }
    boolean isPlusOrMinus(char myChar){
        return myChar == '-' || myChar == '+';
    }
    boolean isPlus(char myChar) {
        return myChar == '+';
    }
    boolean isMinus(char myChar) {
        return myChar == '-';
    }
    boolean isMult(char myChar){
        return  myChar == '*';
    }

    float operates(float first,float second, char op){
        switch (op){
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            case '^':
                return (float) Math.pow(first,second);
            default:
                return 0;
        }

    }
}
