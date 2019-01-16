// get a number, calculating the sum of all digits of that number.

import java.util.*;
public class indexSum{
	public static void main(String[] args){
		Random stdin = new Random();

		int number = stdin.nextInt();
		
		String a = String.valueOf(number);

		char[] b = a.toCharArray();

		int total = 0;
		System.out.println(number);
		for(int i = 0; i < b.length; i++){
			total += Character.getNumericValue(b[i]);
			System.out.print(b[i]+"+");	

			if(i == b.length -1){
				System.out.print(b[i]);
			}
		}
		System.out.println();
		System.out.println(total);
	}
}