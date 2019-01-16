import java.util.*;
public class uniqElement{
	public static void main(String[] args){
		Random stdin = new Random();
		int[] numList = new int[40];
		int number = stdin.nextInt(99)+1;
		
		for(int i = 0; i< numList.length; i++){
			numList[i] = number;
			number = stdin.nextInt(99)+1;
		}
		sort(numList);
		int[] b = unique(numList);
		
		System.out.println(Arrays.toString(numList));
		
		System.out.println(Arrays.toString(b));
	}
	public static int[] sort(int[] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length-1; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	//the following function may use to delete the duplicated elements in an array
	public static int[] unique(int[] a){
		int[] b = new int[a.length] ;

		int bLen = 0; 
		int aLen = a.length;

		boolean isExist = false; 

		for(int i = 0; i < aLen; i++){
			isExist = false; 
			for(int j = 0 ; j < bLen; j++){
				if(a[i] == b[j]){
					isExist = true;
				}
			}
			if(!isExist){
				b[bLen++] = a[i];
			}
		}
		return b;
	}
}