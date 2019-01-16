import java.util.*;
public class sum{
	public static void main(String[] args){
		Random stdin = new Random();
		int number = stdin.nextInt(99)+1;
		int totalOdd = 0;
		int totalEven = 0;
		double t = 0;
		
		for(int i = 1; i < number; i++){
			t+=1/i;
			if(i % 2 != 0){
				totalOdd += i;
			}else{
				totalEven+=i;
			}
		}
		System.out.println(number);
		System.out.println(t);
		System.out.println(totalOdd);
		System.out.println(totalEven);

	}
}