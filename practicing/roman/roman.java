/*
	this program converts roman numberic <=> decimal
*/
import java.util.*;
public class roman{
		private static String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		private static int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	
	
	public static void main(String[] args){


		// Scanner input = new Scanner(System.in);
		
		int num = randomtest();//input.nextInt();

		String co = decimalToRoman(num);
		String b =co;
		
		reverse(roman);
		reverse(decimal);
		
		int dec = romanToDecimal(b);
		String ro = decimalToRoman(dec);
		System.out.println("random roman number: "+co);
		
		System.out.println("decimal result is: "+dec);
		// reverse(roman);
		// 	reverse(decimal);
		// System.out.println("convert back: "+ ro);

	}


	public static int romanToDecimal(String a){
		int changed = 0;
		int placed = 0;
		/*
			print out step by step helps me to understand exactly what happen during the process. 

		*/
		int len = a.length()-1;
		for(int i = len; i>=0; i--){
			
			System.out.println("i: "+i);
			int temp = indexOf(Character.toString(a.charAt(i)));
			System.out.println("temp: "+temp);

			System.out.println("in decimal: "+decimal[temp]);
			System.out.println("placed: "+placed);
			
			if(temp >= placed){
				changed += decimal[temp];
			}
			if(temp < placed){
				changed -= decimal[temp];
			}
			placed = temp;
			System.out.println("changed: "+changed);
			}
		
		return changed;
	}

	public static String decimalToRoman(int number){
		String converted = "";
		for(int i = 0; i < decimal.length; i++){
			
				while(decimal[i] <= number){ //it must be <= for the cases of number in decimal array
					converted +=roman[i];
					number-=decimal[i];
				}
			}
			return converted;
	}
	public static int indexOf(String ch){
		/*
			searching string ch in roman[] and return the index, if not found, return -1
			instead uf using: 
			 Arrays.asList(roman).indexOf(ch)
		*/
		int i; 
		for(i = 0; i < roman.length; i++){
			if(ch.equals(roman[i])){
				return i;
			}
		}
		return -1; //if not found
	}

	public static int randomtest(){
		/*
		generate a random number to test probabilities of program
		*/
		Random stdin = new Random();
		int number = stdin.nextInt(999)+1; // from 1 to 1000

		return number;
	}
	/*
	reversing roman and decimal [] helps the "placed" and "temp" work well
	There are some logic error if keep orginal [].
	*/
	public static int[] reverse(int[] arr){
		for(int i = 0; i < arr.length/2; i++){
			int t = arr[i]; 
			arr[i] = arr[arr.length -i -1];
			arr[arr.length - i -1] = t;
		}	
		return arr;
	}

	public static String[] reverse(String[] arr){
		for(int i = 0; i < arr.length/2; i++){
			String t = arr[i]; 
			arr[i] = arr[arr.length -i -1];
			arr[arr.length - i -1] = t;
		}	
		return arr;
	}
}



