/**
This program will find out how many times appeared of an index in an array, then print out the index which is the most frequency in that array. 
*/

import java.util.*;
public class appeared{
	/*
	idea: 
	- declare new array B which is contains the unique element from original array A
	- compare B and A, count the times of every index in B that appeared in A
	- add every counting to Array C 
	- print out the max of C 
	*/
	public static void main(String[] args){
		int[] arr = createArray(50);
		int count = 0; 
		int[] arrB =uniq(arr);

		int[] arrC = new int[arrB.length];
		/*
		arrC has the same length with arrB, because we will have to count the times of arrB[i] in arr, for every arrB[i] we have arrC[i] times.
		*/
		int lenc = 0; //step of index in arrC
		int maxC; //storage the max value of arrC
		sort(arrB);
		
		System.out.println("original Array: "+Arrays.toString(arr));
		System.out.println("all elements in Array: "+Arrays.toString(arrB));
		for(int i= 0; i < arrB.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(arrB[i] == arr[j]){
					count++;
				}
			}
			arrC[lenc++] = count; //adding new element to array c
			count=0; // reset value of count
			
		}

		maxC = max(arrC); 
		/*
		-finding out the max value of counting in array c
		
		-if c[i] == maxC =>> print arrB[i]
		*/
		for(int index =0; index < arrC.length; index++){
			if(arrC[index] == maxC){
				System.out.println("the number that appeared more often: "+arrB[index]+ " "+ maxC);
			}
		}
		
	}
	public static int max(int[] arr){
		/*
		finding out the max value in an array
		*/
		int max = 0;
		for(int i =0; i< arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}

	public static int[] sort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length - 1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp; 
				}
			}
		}
		return arr;
	}

	public static int[] uniq(int[] arr){
		/*
			this method with create a new array that contains the unique element from original arr.
		*/

		int[] arrB = new int[arr.length];
		int len = arr.length;
		int arrBlen = 0;
		
		boolean isExist = false;

		for(int i = 0; i< len; i++){
			isExist = false;
			for(int j = 0; j < arrBlen; j++ ){
				if(arr[i] == arrB[j]){
					isExist = true;	
				}
			}
			if(!isExist){
				arrB[arrBlen++] = arr[i];
			}
		}
		return arrB;
	}

	public static int[] createArray(int num){
		/*
			- this method will be used to generate a random array with the length = num. 
			- this method could be used for testing.
		*/
		Random stdin = new Random();
		int number = stdin.nextInt(99)+1;
		int[] ranNum =  new int[num];

		for(int i=0; i<ranNum.length; i++){
			ranNum[i] = number;
			number = stdin.nextInt(99)+1;
		}
		return ranNum;
	}
}