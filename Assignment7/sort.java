
/*
	Name: Minh Phan
	ID : 300269120
*/

import java.util.*;
public class sort{
	public static void sortInt(int[] x){
		int len = x.length;
		for(int i = 0; i < len;i++){
			for(int j = 0; j < len-1; j++){
				if(x[j] > x[j+1]){
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				System.out.println(Arrays.toString(x).replace("[","").replace("]",""));
				}
			}//end for 2		
		}//end for 1
	}//end of method

	public static void sortDouble(double[] x){
		int len = x.length;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len-1; j++){
				if(x[j] > x[j+1]){
					double temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				System.out.println(Arrays.toString(x).replace("[","").replace("]",""));
				}
			}//end for 2
		}//end for 1
	}//end of method

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Please enter the # of numbers to be sorted: ");
		int numbersToBeSorted = stdin.nextInt();
		System.out.print("Enter 1 for int's or 2 for doubles: ");
		int type = stdin.nextInt();

		switch(type){
			case 1:
				int[] myIntArray = new int[numbersToBeSorted];

				for(int i =0 ; i < myIntArray.length; i++){
					System.out.print("Enter number: ");	
					myIntArray[i] = stdin.nextInt();
				}
				sortInt(myIntArray);
				break;

			case 2:
				double[] myDoubleArray = new double[numbersToBeSorted];
				for(int i = 0; i < myDoubleArray.length; i++){
					System.out.print("Enter number: ");
						myDoubleArray[i] = stdin.nextInt();
				}
				sortDouble(myDoubleArray);
				break;

			default:
				System.out.println("Please try again, you should chose 1 or 2 only!");
		}//end switch
	}//end main
}//end class