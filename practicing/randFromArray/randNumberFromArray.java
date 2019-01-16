// given an array of numbers from 1 to 100;
//guessing by input, if guess === random picked number from array
// print out

import java.util.*;
public class randNumberFromArray{
    public static void main(String[] args) {
        Random stdin = new Random();

        int[] number = new int[101];

        for(int i = 0; i < 101; i++){
            number[i]= i;
        }

        int i = 1;
        int a = stdin.nextInt(99)+1;
        int guess = stdin.nextInt(99)+1;
        while(i < 101){
        	a = stdin.nextInt(99)+1;
        	guess = stdin.nextInt(99)+1;
	     	 
	        if(guess == number[a]){
	        	System.out.println(guess);   
	        	System.out.println(number[a]);
	        	break;
	        }else{
	        	System.out.println(guess);   
	        	System.out.println(number[a]);
	        }
	    }
    }
}