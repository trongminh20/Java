/*
Name: Minh Phan
ID: 300269120
*/

import java.util.Scanner;

public class valid{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		String password = "";

		int countNumber = 0;
		int countCap = 0;
		int countLower = 0;
		int countSpecial =0;
		boolean valid = false;


		System.out.println("==== PASSWORD VALIDATION ====");
		System.out.println("\n- Passwords must be at least 8 characters long.\n- Passwords can only contain ALPHA NUMERIC character (no spaces or special characters).\n- Passwords must contain at least 1 UPPERCASE character.\n- Passwords must contain at least 1 LOWERCASE character.\n- Passwords must contain at least 1 NUMERIC character (0-9).\n- Passwords cannot contain the word 'pasword'.\n\n");
		System.out.println("type 'endofinput' if you wan to quit!!");
		System.out.println("Please type your password!");

		do{
			countNumber = 0;
			countCap = 0;
			countLower = 0;
			countSpecial =0;
			
			System.out.print("password: ");
			password = stdin.nextLine();

			boolean checkContain = password.toLowerCase().contains("password");
			
			if(password.toLowerCase().equals("endofinput")){
					valid = true;
					break;
				}

			if(password.length() >= 8){
				for(int i = 0; i< password.length(); i++){
					char c = password.charAt(i);
					if(Character.isDigit(c)){
						countNumber++;
					}
					if(Character.isUpperCase(c)){
						countCap++;
					}
					if(!Character.isUpperCase(c)){
						countLower++;
					}
					if(!Character.isLetterOrDigit(c)){
						countSpecial++;
					}
				}//end for

				if(countNumber == 0){
					System.out.println("- Passwords must contain at least 1 numeric character \n");
				}
				if(countCap == 0){
					System.out.println("- password must contain at least one uppercase character!! \n");
				}
				if(countLower == 0){
					System.out.println("- Password must contain at least 1 lowercase character!! \n");
				}
				if(countSpecial > 0){
					System.out.println("- password can only contain alpha numeric characters!! \n");
				}

				if(countSpecial == 0 && countLower >0 && countNumber > 0 && countCap > 0 && !checkContain){
					System.out.println("password '"+password+"' is valid!!");
					valid = true;
				}
				if(checkContain){
					System.out.println("- Your password shoud not containts 'password'!!\n");
				}
			}else{
				System.out.println("- password must be greater than 8 characters\n");
			}

		}while(!valid);

	}//end main method
}//end class valid






