/*
Name: Minh Phan
ID: 300269120
COSC-111-Assignment 2
*/
import java.util.Scanner;

public class speedingTicket{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.println("How fast was the vehicle going?");
		int currentSpeed = stdin.nextInt();

		//the input has to be positive
		if(currentSpeed > 0){
			System.out.println("What was the speed limit?");
			int speedLimit = stdin.nextInt();
			int over = currentSpeed - speedLimit;
			//if currentSpeed is greater than limitation
			if(over > 0){
				System.out.println("Was it a school or construction zone? (1 for yes or 2 for no)");
				int zones = stdin.nextInt();
				//checking zone's value, it's only 1 or 2. If not, exit program
				if(zones == 2){
					if(over >= 1 && over <=20){
						System.out.println("Fine is $138");
					}
					else if(over >= 21 && over <= 40){
						System.out.println("Fine is $196");
					}
					else if(over >=41 && over <= 60){
						System.out.println("Fine is $368");
					}else if(over >=61){
						System.out.println("Fine is $483");
					}	
				}
				else if(zones == 1){
					if(over >= 1 && over <=20){
						System.out.println("Fine is $196");
					}
					else if(over >= 21 && over <= 40){
						System.out.println("Fine is $253");
					}
					else if(over >=41 && over <= 60){
						System.out.println("Fine is $368");
					}else if(over >=61){
						System.out.println("Fine is $483");
					}
				}
				else{
					System.out.println("Please enter only 1 or 2! Program will exit now, please try next times");
				}				
			}
			//if current speed is less than speed limitation, then to check how difference between current speed and speed limit
			else if(over < 0 && over > -20){
				System.out.println("your speed is under speed limit! keep safe");
			}
			else{
				System.out.println("Fine is $121");
			}
		}
	}
}