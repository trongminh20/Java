public class craps2{
	public static void main(String[] args){
		int dice1=(int)(Math.random()*5+1);
		int dice2=(int)(Math.random()*5+1);

		int comeOut = dice1+dice2;



		if(comeOut == 7 || comeOut == 11){
			System.out.println("you rolled: "+comeOut+", you win");		
		}
		else if(comeOut ==2 || comeOut == 3 || comeOut == 12 ){
				System.out.println("you rolled: "+comeOut+", you lose");
		}
		else{
			System.out.print("you rolled: "+comeOut+" point is "+ comeOut);

			while(true){
				int point = dice1+dice2;
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