import java.util.*;
public class test{
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		if(b <10){
			do{
				System.out.println("again");
				b = a.nextInt();
			}while(b <10);
		}else{
			System.out.println(b);
		}
			
		
	
		
	}//end main
		
}