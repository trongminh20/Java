/*
studying about StringBuilder class

*/

public class stringClass{
	public static void main(String[] args){
		StringBuilder str = new StringBuilder();

		str.append("Minh");
		str.append("Phan");
	
		String name = str.toString();
		System.out.println(name+" ");

	}
}