/*
	the following code is example of how to use ways to work with class Random, including
	- array
	- string
	- type of number
*/ 

import java.util.*;
public class RandomClass{
	public static void main(String[] args){
		Random stdin = new Random(); 
		int[][] randomArray = {
			{0,1,2,3,4,3},
			{5,6,7,87,8,9},
			{0,1,1,1,1,233,3},
			{0000,1111,222,3333,444,555,666}
		};
		String sentence = "this is random sentences from what";
		String[][] stringArray = new String[6][4];
		stringArray[0] = sentence.split(" ");
		int col = stdin.nextInt(6);
		int row = stdin.nextInt(4);
		String[] cha = sentence.split(" ");
		//int randomNumber = stdin.nextInt(); //get the number less than 100
		//int randomInRange = stdin.nextInt(71)+10; //from 10 to 80, 80-10 = 70 +1 (including 80)
		for(int i= 0; i < 20; i++){
			col = stdin.nextInt(5);
			row = stdin.nextInt(3);

			stringArray[row][col] = cha[i];
			
			//System.out.println(stringArray[row][col])
		}
		for(int r = 0; r <stringArray.length;r++){
				for(int c = 0; c < stringArray[r].length; c++){
					System.out.print(stringArray[r][c] +" ");
				}

				System.out.println();
			}

	}
}

