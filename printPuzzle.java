import java.util.*;

public class printPuzzle{

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int size = stdin.nextInt();
		printSquare(size);
		printTriangle(size);
		printReverseHaflTriangle(size);
		printHaflTriangle(size);
		printXshape(size);
		printOshape(size);
	}

	static void printXshape(int size){
		for(int c = 0 ; c <= size; c++){
			for(int r = 0; r <= size; r++){
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
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printTriangle(int size){
		for(int c = 0 ; c < size; c++){
			for(int r = 0; r < size-c ; r++){
				System.out.print(" ");
			}
			for(int k = 0 ; k <(2 * c -1); k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printHaflTriangle(int size){
		for(int c = 0 ; c < size; c++){
			for(int r=0; r < c; r++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printReverseHaflTriangle(int size){
		for(int c = 0; c < size; c++){
			for(int r = size; r > c; r--){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void printOshape(int size){
		for(int c = 0; c <= size; c++){
			for(int r = 0 ; r <= size; r++){
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