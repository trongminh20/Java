public class stringreview{

	public static void main(String[] args){
		String passwor= "something123!!";
		boolean hasNumber = false;

		for(int i = 0; i < passwor.length();i++){
			//System.out.println("Char at "+i+ " is "+passwor.charAt(i));

			char c = passwor.charAt(i);
			
			if(Character.isDigit(c)){
				hasNumber = true;
				break;
			}
		}
		System.out.println((hasNumber)?"valid":"not valid");




	}
}