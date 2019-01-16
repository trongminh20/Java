/*
	NAME: Minh Phan
	ID: 300269120
	COSC 111 - Assignment 3
*/

public class crapsSimulator{

	public static int dice(int i){
		return (int)(Math.random()*i);
	}

	public static int total(){
		int dice1 = dice(5)+1;
		int dice2= dice(5)+1;
		return dice1+dice2;
	}

	public static void main(String[] args){
		int comeOut = total();
		if(comeOut == 7 || comeOut == 11){
			System.out.println("you rolled: "+comeOut+", you win");		
		}
		else if(comeOut ==2 || comeOut == 3 || comeOut == 12 ){
				System.out.println("you rolled: "+comeOut+", you lose");
		}
		else{
			System.out.print("you rolled: "+comeOut+" point is "+ comeOut);

			while(true){
				//generate the new roll
				int point = total();
				System.out.print("\n you rolled: "+point);
				if(point == comeOut){
					System.out.println(" you win!");
					break;
				}
				else if(point == 7){
					System.out.println(" it's crap! you lose");
					break;
				}
			}
		}
	}
}