import java.util.Scanner;
import java.util.ArrayList;
public class palindrome{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		String input = stdin.nextLine();
		
		boolean isValid = true;
		int firstIndex = 0;
		int maxLen = input.length()-1;
		ArrayList<Character> x = new ArrayList<Character>();
		ArrayList<Character> y = new ArrayList<Character>();
		//System.out.println(input.length());
/*
		do{
			char c = input.charAt(firstIndex);
			char b = input.charAt(maxLen);

			if(c != b){
				isValid = false;
				break;
			}
				firstIndex++;
				maxLen--;
		}while(firstIndex == maxLen);
*/

		for(int i = 0; i < input.length();i++){
			x.add(input.charAt(i));
		}		
		for(int j = maxLen; j>=0;j--){
			y.add(input.charAt(j));
		}
		System.out.println(x);
		System.out.println(y);
		
		if(!x.equals(y)){
			System.out.println("not a palyndrome");
		}else{
			System.out.println("it is a palyndrome");
		}

	}//end main method
}//end class