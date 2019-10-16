package com.company;
import java.lang.Math;

public class operation {

	public int precedence(char myChar){
		if(myChar == '^') return 3;
        	else if(myChar == '*' || myChar == '/') return 2;
        	else if(myChar == '+' || myChar == '-') return 1;
        	else return 0;
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
}
