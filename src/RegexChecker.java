import java.util.*;

import java.util.regex.*;

public class RegexChecker {
    
	public static boolean checkValidity(String input){
		boolean isRegex;
		try {
		  Pattern.compile(input);
		  isRegex = true;
		} catch (PatternSyntaxException e) {
			System.out.println("Not a valid regular expression, try again!");
		  isRegex = false;
		}
		return isRegex;
	}
	
	public static boolean match(String input, String regex){
		
		if(input.matches(regex)){
			return true;
		}else{
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex,input;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Please enter the regex:");
			regex = scan.nextLine();
		}while(checkValidity(regex) == false);
		System.out.println("Valid Regex, now enter the value to check if it is one:");
		input = scan.nextLine();
		
		if(match(input,regex)==true){
			System.out.println("Yay! It is a regex!");
		}else{
			System.out.println("Boo, invalid!");
		}
		
		

	}

}
