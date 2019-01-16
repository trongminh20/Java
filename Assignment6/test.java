import java.util.*;

public class test{
	public static boolean checkVowel(char c){
		boolean check = false;
		ArrayList<Character> x = new ArrayList<>(Arrays.asList('a','o','u','e','i'));
		for(char i : x){
			if(c == i){
				check = true;
			}
		}
		return check;
	}

	public static void main(String[] args) {
		String a = "aouei";
		int count = 0;

		for(char c: a.toCharArray()){
			if(checkVowel(c)){
				count++;
			}
		}
			
		System.out.println(count);
	
	
	}	
		}
	
