import java.util.*;

public class array{
	public static void main(String[] args){
		//Scanner stdin= new Scanner(System.in);
		int studentID = 10;
		int[] stMembers = {10,2,3,4,5,6};
		System.out.println(checkStudent(studentID,stMembers));

	}
	static void printArrayMatrix(){
		int[][] mat = {{
			0,1,2,3,4
		},
		{
			4,5,6,7
		},
		{
			8,9,10,11
		},
		{
			11,12,13,14
		}};

		for(int i =0; i < 4;i++ ){
			System.out.println(mat[i][i]);
		}
	}

	static boolean checkStudent(int studentID, int[] studentMember){
		boolean valid = false;
		// for(int i = 0; i < studentMember.length; i++ ){
		// 	if(studentMember[i] == studentID){
		// 		System.out.println(i);
		// 		valid = true;
		// 		break;
		// 	}else{
		// 		valid = false;
		// 	}
		// }
		//boolean a = contains(studentMember, s);
		//boolean a = Arrays.asList(studentMember).contains(studentID);
		

		//int i = 0;
		// do{
		// 	if(studentID == studentMember[i]){
		// 		System.out.println("place: "+i);
		// 	System.out.println("value: " + studentMember[i]);
		// 		valid = true;
		// 		break;
		// 	}else{
		// 		valid = false;
		// 	}	
			
		// 	i++;
		// }while(i < studentMember.length);
		
		// while(i<studentMember.length){
		// 	if(studentMember[i] == studentID){
		// 		System.out.println("place: "+i);
		// 		System.out.println("value: " + studentMember[i]);
		// 		valid = true;
		// 		break;
		// 	}else{
		// 		valid = false;
		// 	}
		// i++;
		// }

		return valid;
	}

}