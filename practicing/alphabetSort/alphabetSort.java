import java.util.*;
/*
	this program will sort the string in alphabetical order
	using buble sort algorith, join(); compareTo() and split();
*/
public class alphabetSort{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);

		String input = stdin.nextLine();
	
		System.out.println(sortString(input));
	}	

	public static String sortString(String str){
		String temp;
		String[] a = str.split(" ");
		for(int i = 0; i < a.length; i++){
			for(int j = i+1; j < a.length;j++ ){
				if(a[i].compareTo(a[j]) > 0){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return String.join(" ",a );
	}
}