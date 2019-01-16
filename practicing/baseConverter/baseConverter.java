/*
	this program helps us to convert a number from base 10 to any base(2 => 36)

*/
import java.util.*;
public class baseConverter{
	public static final String values = "0123456789ABCDEFGHEKLMNOPQRSTVUWXYZ";
	//this variable storage the values of the bases
	public static void main(String[] args){
		int input = randomGenerate();
		int base = (int)(Math.random()*34)+2;
		System.out.println("number: "+input+"\nBase: "+base);
		System.out.println(convertToBase(input,base));
	}
	public static int randomGenerate(){
		Random stdin = new Random();
		int number = stdin.nextInt(99)+1;
		return number;
	}

	public static String reverseString(String str){
		int len = str.length()-1;
		String reversed = "";
		for(int i = len; i >=0; i--){
			reversed +=Character.toString(str.charAt(i));
		}
		return reversed;
	}
	public static String convertToBase(int number, int base){
		 
		 int remains = number % base;
		 //int len = 0; 
		 String res ="";
		 while(number!=0){
		 	remains = number % base;
		 	number/=base;
		 	System.out.println("R: "+remains);
		 	res+=Character.toString(values.charAt(remains));//Integer.toString(remains);
		 	System.out.println("res: "+ res);
		 	
		 	System.out.println("numb: "+number);
		 }
		 return reverseString(res);
	}
}