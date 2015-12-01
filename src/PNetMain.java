import java.util.Scanner;


public class PNetMain {
	static Scanner scan = new Scanner(System.in);
	static PNet nico;
	static int p,t;
	
	public static int places(){
		System.out.println("Please enter the # of places:");
		p = scan.nextInt();
		return p;
	}
	
	public static int transitions(){
		System.out.println("Please enter the # of transitions:");
		t = scan.nextInt();
		return t;
	}
	
	public static void inputMarkings(){
		int trans = 1;
		
		while(trans<=t){
			System.out.println("Please enter the input marking for transition "+trans+" sepearated by commas:");
			String input = scan.nextLine();
			
			if(commaValue(input)==p){
				nico.addInput(trans,input);
				trans++;
			}else{
				System.out.println("Not enough input markings try again");
			}
		}
	}
	
	public static void outputMarkings(){
		int trans = 1;
		
		while(trans<=t){
			System.out.println("Please enter the output marking for transition "+trans+" sepearated by commas:");
			String output = scan.nextLine();
			
			if(commaValue(output)==p){
				nico.addOutput(trans,output);
				trans++;
			}else{
				System.out.println("Not enough output markings try again");
			}
		}
	}
	
	public static void initialMarking(){
		while(true){
			System.out.println("Please enter the initial marking:");
			String initialMarking = scan.nextLine();
			if(commaValue(initialMarking) == p){
				nico.addInitialMarking(initialMarking);
				return;
			}else{
				System.out.println("Not enough initial markings, try again");
			}
		}
	}
	
	public static int commaValue(String input){
		int val = 1;
		for(int i =0; i<input.length(); i++){
			if(input.charAt(i)==','){
				val++;
			}
		}
		return val;
	}
	public static void main(String[] args) {
		
		nico = new PNet(places(),transitions());
		scan.nextLine();
		inputMarkings();
		nico.prinOutInput();
		outputMarkings();
		nico.prinOutOutput();
		initialMarking();
		nico.printOutInitialMarking();
		
		nico.calculations();

	}

}
