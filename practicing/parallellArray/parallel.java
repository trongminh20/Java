import java.util.*;

public class parallel{
	public static void main(String[] args){
		int[] arr1 = {1,2,3,2,1};
		int[] arr2 = {2,2,3,2,2};
		int[] arr3 = {0,1,2,3,4,5};

		System.out.println(checkParallel(arr1));
		System.out.println(checkParallel(arr2));
		System.out.println(checkParallel(arr3));
	}

	public static int[] reverseArr(int[] a){
		for(int i = 0; i < a.length/2;i++){
			int temp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length - i -1] = temp;
		}
		return a;
	}

	public static boolean checkParallel(int[] arr){
		boolean checked = false;
		int[] c = new int[arr.length];
		int i = 0;
		//System.arraycopy(source array, start position on source, destination array, start position on destination, length)
		System.arraycopy(arr,0, c, 0, arr.length);
		//use system.arraycopy to create a deep copy which prevent the 
		//changing of arr while we are working with it.
		int[] b = reverseArr(c);
		while(i < arr.length){
			if(arr[i] == b[i]){
				checked= true;
			}
			i++;
		}
		return checked;
	}
}