package com.company;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class operation {
    public int precedence (char myChar){
        if(myChar == '^') return 3;
        else if(myChar == '*' || myChar == '/') return 2;
        else if(myChar == '+' || myChar == '-') return 1;
        else return 0;
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
    float operatePostfix(String equation){
        String [] parts = equation.split(" ");
        String word;
        Stack<Float> myStack = new Stack<Float>();

        for (int i = 0; i < parts.length; i++){
            if(parts[i].length() > 1 && isOperator(parts[i].charAt(0)) && !isOperator(parts[i].charAt(1))){
                float number = Float.parseFloat(parts[i]);
                myStack.push(number);
            }
            else if (!isOperator(parts[i].charAt(0))){
                float number = Float.parseFloat(parts[i]);
                myStack.push(number);
            }else if(isOperator(parts[i].charAt(0))){
                float second = myStack.peek(); myStack.pop();
                float first = myStack.peek(); myStack.pop();
                float result = operates(first, second,parts[i].charAt(0) );
                myStack.push(result);
            }
        }
        return myStack.peek();
    }
}
