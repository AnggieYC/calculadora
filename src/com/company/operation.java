package com.company;

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



}
