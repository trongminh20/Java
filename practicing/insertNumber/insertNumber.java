import java.util.*;
/*
	given a list of numbers, and a random number x;

	inert x into list whitouth impacting the sorting of numbers list
*/
public class insertNumber{
	public static void main(String[] args){
		int[] number = {1,2,3,4,5};
		int insert = 0;
		StringBuilder stdin = new StringBuilder(number.length);

		for(int i = 0 ; i < number.length; i++){
			stdin.append(number[i]);

		}

		for(int j = 0; j < stdin.length(); j++){
			if(Character.getNumericValue(stdin.charAt(j)) >insert){
				stdin.insert(j,insert);
				break;
			}
		}
		
		String res = stdin.toString();

		System.out.println(res);
	}
}