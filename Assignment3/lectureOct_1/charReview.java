public class charReview{
	public static void main(String[] args){
		char c = 'a';
		char b = 'A';
		System.out.println("Looking at char: "+c);
		System.out.println("isLetter: "+Character.isLetter(c));
		System.out.println("isDigi: " + Character.isDigit(c));		
		System.out.println("isLetter or isDigit: " + Character.isLetterOrDigit(c));
		System.out.println("the uppeer case: "+Character.toUpperCase(c));
		System.out.println("conver toLowerCase: " +Character.toLowerCase(b));
	}
}