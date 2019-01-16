
/*
finding the prime number that is closest to the input number from an array. 
idea:
- generating an array of numbers called A 
- getting input from user 
- declare a variable temp = prime number in A and less than input

- print the last of temp


*/
import java.util.*;

public class primeNumber{
	public static void main(String[] args){
		 //Scanner stdin = new Scanner(System.in);

		int chosenNum = (int)(Math.random()*90);
		int[] numList = bubSort(createNumberArray(300));
		
		System.out.println(chosenNum);
		System.out.println(closestPrimeNumber(numList, chosenNum));	
		
	}
	
	public static int closestPrimeNumber(int[] a, int number){
		int len = a.length;
		int temp = 0;
		for(int i = 0 ; i< len; i++){
			if(isPrime(a[i]) == true){
				if(a[i] <= number){
					temp = a[i];
					//System.out.println(temp);
				}
			}
		}
		return temp;
	}

	

	// public static int[] createPrimeList(int[] a){
	// 	int[] primeList = new int[a.length];
	// 	for(int i = 0; i < a.length; i++){
	// 		if(isPrime(a[i]) == true){
	// 			primeList[i] =a[i];
	// 		}
	// 	}
	// 	return primeList;
	// }

	public static int[] bubSort(int[] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length-1; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}

	// public static int maxPrime(int[] a){
	// 	int max = 0; 

	// 	for(int i = 0 ; i < a.length; i ++){
			
	// 		if( max < a[i]){
	// 			max = a[i];
	// 		}
	// 	}
	// 	return max;
	// }

	public static boolean isPrime(int a){
		boolean isPrime = true;
		if(a == 0 || a == 1){
			isPrime = false;
		} else{
			for(int i = 2; i < a; i++){
				if(a%i == 0){
					isPrime = false;
					break;
				}
			}	
		}
	return isPrime;
	}

	public static int[] createNumberArray(int a){
		Random stdin = new Random();
		int newNum = stdin.nextInt(99)+1;
		int[] num = new int[a];

		for(int i = 0; i < num.length; i++){
			num[i] = newNum;
			newNum = stdin.nextInt(99)+1;
		}
		return num;
	}	
}