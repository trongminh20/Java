import java.util.*;
/*
	this program will fix the wrong string that received from user
	- capital first letter of every word
	- delete wrong spaces
*/

public class standarString{

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		String str = stdin.nextLine();
		standar(str);
	}
	
	public static void standar(String str){
		/*
			get string whic was removed all spaces and made uppercase for the first characters

			if character at i is == uppercase itself, then, insert " " at i

			understanding about StringBuilder's method
			.append() and .insert()
		*/
		str=upperFirstChar(str);

		StringBuilder strb = new StringBuilder(str.length());
		
		strb.append(str);
		
		int len = str.length()-1;

		for(int i = len; i >= 0; i--){
			if(strb.charAt(i) == Character.toUpperCase(strb.charAt(i))){
				strb.insert(i," ");
			}
		}
		String res = strb.toString().trim();
		System.out.println(res);
	}

	public static String upperFirstChar(String str){
		String text="";
		String[] a = str.split(" ");
		for(String i : a){
			char[] temp = i.toCharArray();
			//change the first character of String i to upper case
			for(int c = 0; c<temp.length; c++){
				temp[0] = Character.toUpperCase(temp[0]);
			}
			//handle for joining every character in temp[] back to string
			text += String.valueOf(temp);	
		}
		return text;
	}	
}
