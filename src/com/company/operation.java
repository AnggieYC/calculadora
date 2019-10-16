package com.company;
import java.lang.Math;

public class operation {
<<<<<<< HEAD

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



=======
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
>>>>>>> 31a3118679abc726bf99adb59e0c3b9bef7e98be
}
