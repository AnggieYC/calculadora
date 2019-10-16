package com.company;

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

    String reduceOperator(String equation) {
        String myResult = '';
        for (int i = 0; i < equation.length(); i++ ) {
            if (isOperand(equation.charAt(1)) {
                myResult = myResult + equation.charAt(1);
            }
            if (isParentesis(equation.charAt(1)) {
                myResult = myResult + equation.charAt(1);
            }
            if (isOperator(equation.charAt(1)) {
                if (isPlusOrMinus(equation.charAt(1))) {
                    if (isPlus(myResult.charAt(myResult.length() - 1)) && isMinus(equation.charAt(i)) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '-';
                    } else if (isPlus(myResult.charAt(myResult.length() - 1)) && isPlus(equation.charAt(i)) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '+';
                    } else if (isMinus(myResult.charAt(myResult.length() - 1)) && isMinus(equation.charAt(i)) {
                        myResult = myResult.substring(0, myResult.length() - 2);
                        myResult = myResult + '+';
                    } else if (isMinus(myResult.charAt(myResult.length() - 1)) && isPlus(equation.charAt(i)) {
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
    }
    return myResult;
}
