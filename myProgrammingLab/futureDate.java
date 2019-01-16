import java.util.Scanner;
public class futureDate{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter today's day: ");
		int numberInput = stdin.nextInt();
		System.out.println("Enter the number of days elapsed since today: ");
		int elapsed = stdin.nextInt();
		String date="";
		int futureDate = (numberInput + elapsed) % 7;
		String fDate="";
		
		switch(numberInput){
			case 0:
				date = "Sunday";
				break;
			case 1:
				date = "Monday";
				break;
			case 2:
				date = "Tuesday";
				break;
			case 3:
				date = "Wenesday";
				break;
			case 4:
				date = "Thursday";
				break;
			case 5:
				date = "Friday";
				break;
			case 6: 
				date = "Saturday";
				break;

		}
		//System.out.println("today is "+ date);

switch(futureDate){
			case 0:
				fDate = "Sunday";
				break;
			case 1:
				fDate = "Monday";
				break;
			case 2:
				fDate = "Tuesday";
				break;
			case 3:
				fDate = "Wenesday";
				break;
			case 4:
				fDate = "Thursday";
				break;
			case 5:
				fDate = "Friday";
				break;
			case 6: 
				fDate = "Saturday";
				break;
			}
			//System.out.println(fDate);
			System.out.println("Today is "+date +" and the future day is "+fDate);
	}
}