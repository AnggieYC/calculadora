package com.company;
import java.lang.Math;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class operation {
    public String equation;

	public int precedence(char myChar){
		if(myChar == '^') return 3;
        	else if(myChar == '*' || myChar == '/') return 2;
        	else if(myChar == '+' || myChar == '-') return 1;
        	else return 0;
	}


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


	public boolean isOperator(char myChar) {
		return myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/' || myChar == '^';
    	}

    	public boolean isParentesis(char myChar){
        	return myChar =='(' || myChar == ')';
    	}
    
	public boolean isLeftParentesis(char myChar){
        	return myChar == '(';
    
	}
    
	public boolean isRightParentesis(char myChar){
        	return myChar == ')';
    	}
    
	public boolean isPlusOrMinus(char myChar){
        	return myChar == '-' || myChar == '+';
    	}
    
	public boolean isPlus(char myChar) {
        	return myChar == '+';
    	}
    
	public boolean isMinus(char myChar) {
        	return myChar == '-';
    	}
    
	public boolean isMult(char myChar){
        	return  myChar == '*';
    	}


    public String reduceOperator(String equation) {
        String myResult = ""; 
        for (int i = 0; i < equation.length(); i++ ) {
            if (isOperand(equation.charAt(1))) {
                myResult = myResult + equation.charAt(1);
            }
            if (isParentesis(equation.charAt(1))) {
                myResult = myResult + equation.charAt(1);
            }
            if (isOperator(equation.charAt(1))) {
                if (isPlusOrMinus(equation.charAt(1))) {
                    if (isPlus(myResult.charAt(myResult.length() - 1)) && isMinus(equation.charAt(i))) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '-';
                    } else if (isPlus(myResult.charAt(myResult.length() - 1)) && isPlus(equation.charAt(i))) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '+';
                    } else if (isMinus(myResult.charAt(myResult.length() - 1)) && isMinus(equation.charAt(i))) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '+';
                    } else if (isMinus(myResult.charAt(myResult.length() - 1)) && isPlus(equation.charAt(i))) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '-';
                    } else {
                        myResult = myResult + equation.charAt(1);
                    }
                } else {
                    myResult = myResult + equation.charAt(1);
                }
            }

        }
        return myResult;
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
