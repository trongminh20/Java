/*
Name: Minh Phan
ID: 300269120
*/

import java.util.Scanner;
public class xPattern{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int size;

		System.out.println("Would you like to see an X or O? ");
		String choice = stdin.next();
		
		//the input should be checked if it's valid or not
		switch(choice){
			case "x":
				System.out.println("What size should it be? ");
				size = stdin.nextInt();
				for(int col = 0; col < size; col++){
					for(int row = 0; row< size; row++){
						if(row == col || row+col == size-1){
							System.out.print("*");
						}else{
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				break;

			/*people might be confused between "O" and "0", therefore, the case of "0" should be included. */
			case "o":
			case "0":
				System.out.println("What size should it be? ");
				size = stdin.nextInt();
				for(int col = 0; col <= size; col++){
					for(int row = 0; row <= size; row++){
						if(row == 0 || col == 0||col == size||row==size){
							System.out.print("*");
						}else{
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				break;
			default:
				System.out.println("Please try again with 'X' or 'O' only!!");
				break;	
		}
	}
}