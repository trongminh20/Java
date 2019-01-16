import java.util.*;
public class printPuzzle{
	
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int size = stdin.nextInt();
		//printSquare(size);
		printTriangle(size);
		//printReverseHaflTriangle(size);
		//printHaflTriangle(size);
		//printXshape(size);
	}

	static void printXshape(int size){
		for(int r = 0 ; r <= size; r++){
			for(int c = 0; c <= size; c++){
				if(r == c || r+c == size -1){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	static void printSquare(int size){
		for(int r = 0; r < size; r++){
			System.out.print(r+" ");
			for(int c = 0; c < size; c++){
				System.out.print(c);
				//System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printTriangle(int size){
		for(int r = size ; r > 0; r--){
			//System.out.print(r+" ");
			for(int c = size; c >r ; c--){

				System.out.print(" ");
			}
			for(int k = 0; k < (r*2-1); k++){
				//System.out.print(k);
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printHaflTriangle(int size){
		System.out.println();
		System.out.println();
		for(int r = 0 ; r < size; r++){
			System.out.print(r+" ");
			for(int c=0; c < r; c++){
				System.out.print(c);
			}
			System.out.println();
		}
	}

	static void printReverseHaflTriangle(int size){
		for(int r = 0; r < size; r++){
			for(int c = size; c > r; c--){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printOshape(int size){
		for(int r = 0; r <= size; r++){
			for(int c= 0 ; c <= size; c++){
				if(r ==0 || c == 0 || c == size || r == size){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}//end class