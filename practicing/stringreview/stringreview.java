import java.util.*;
public class stringreview{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		String a = "this is a long 1 2sentence for testing finding wor7d met35hod";
		
		String[] b = a.split(" ");
		char[] c = a.toCharArray();
		String d = "abc";
		String e = "abcef";
		int x = stdin.nextInt();
		//System.out.println(d.compareTo(e));
		//System.out.println(findingWord(a,3).substring(0,4));
		
		printDashedLine(x);
		System.out.println(checkDigit(c));
		// printDashedLine(14);
		
	}
	static int checkDigit(char[] a){
		int count = 0;
		int total = 0;
		System.out.println("the digits are: ");
		for(char i : a){
			if(Character.isDigit(i)){
				System.out.print(i+", ");
				total+= Character.getNumericValue(i);
				count++;
			}
		}
		System.out.println();
		System.out.println(total);	
		return count;
	}

	static String findingWord(String a, int d){
		String[] c = a.split(" ");
		return c[d];
	}

	static void printDashedLine(int a){
		if(a > 0){
			for(int i =0 ; i <a; i++){
				System.out.print("- ");
			}
			System.out.println();
		}else if(a <= 0){
			System.out.println("nothing to do");
		}	
	}

	

}