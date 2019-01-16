import java.util.*;
public class randomnum{
	public static void main(String[] args){
		try{
			int[] rangeNum = new int[101];

			for(int i = 0; i < 101; i++){
				rangeNum[i] = i;
			}

			System.out.println(Arrays.toString(rangeNum));	
		}catch(ClassNotFoundException e1){
   			
		}
	}
}

