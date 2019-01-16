/*
Name: Minh Phan
ID:300269120
*/


import java.util.*;


public class method{

	public static boolean checkDigit(char c){
		return (Character.isDigit(c))? true : false;

	}//end digit checking method

	public static boolean checkletter(char c){
		return (Character.isLetter(c))? true : false;
	}//end letter checking method

	public static boolean checkVowel(char c){
		boolean check = false;
		char[] x = {'a','o','u','e','i'};
		for(char i : x){
			if(Character.toLowerCase(c) == i){
				check = true;
			}
		}
		return check;
	}//end vowel checking method

	public static boolean checkContains(String target){
		ArrayList<Character> awesome = new ArrayList<>(Arrays.asList('a','w','s','o','m','e'));
	    ArrayList<Character> test = new ArrayList<Character>();
	    
	    int count2E = 0;
	    // for each character i in String target
	    // simmilar with for(int i = 0; i < target.length(); i++)
	    for(char i : target.toCharArray()){
	    	
	    	if(i == 'e' || i == 'E'){
	    		count2E++;
	    	}
	    }

	    for(char x : awesome){
	    	for(char i : target.toCharArray()){
	    		if(awesome.contains(i)&& !test.contains(i)){
	    			test.add(i);
	    		}	
	    	}
	    }
	    
	    Collections.sort(awesome);
	    Collections.sort(test);
	    
	    return (test.equals(awesome) && count2E >=2)? true: false;

	}//end awsome checking method



	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		
		int sumDigit = 0;
		int countLetter = 0;
		int countVowel = 0;
		boolean containsOrNot = false;

		System.out.println("Please enter a sentence to analyze: ");
		String input = stdin.nextLine();

		for(char i : input.toCharArray()){
			if(checkDigit(i)){
				sumDigit += Character.getNumericValue(i);
			}
			if(checkletter(i)){
				countLetter++;
			}
			if(checkVowel(i)){
				countVowel++;
			}	
		}

		System.out.println("The sum of the digits is: "+sumDigit+"\nThe number of letters is: "+countLetter+"\nThe number of vowels is: "+countVowel);
		System.out.println((checkContains(input))? "The sentence is awesome":"The sentence is not awesome");
		
	}//end main

}//end class




