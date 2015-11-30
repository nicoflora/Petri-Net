import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class PNet {

	int places, transitions;
	int placesCount = 0;
	String temp = "";
	int[] initialMarking;
	
	HashMap<Integer, int[]> inputMap;
	HashMap<Integer, int[]> outputMap;
	
	public PNet(int places, int transitions)
	{
		this.places = places;
		this.transitions = transitions;
		
		inputMap = new HashMap<Integer, int[]>();
		outputMap = new HashMap<Integer, int[]>();
		initialMarking = new int[places];
	}
	
	public void addInput(int transition, String marking){
		int[] inputTransition = new int[places];
		marking += ",";
			for(int i = 0; i<marking.length(); i++){
				if(marking.charAt(i)!=',')
					temp += marking.charAt(i);
				else{
					System.out.println(temp);
					inputTransition[placesCount] = Integer.parseInt(temp);
					placesCount++;
					temp = "";
				}
				
			}
			inputMap.put(transition, inputTransition);
	}
	
	public void addOutput(int transition, String marking){
		int[] outputTransition = new int[places];
		
			for(int i = 0; i<places; i++){
				outputTransition[i] = Character.getNumericValue(marking.charAt(i));
			}
			outputMap.put(transition, outputTransition);
	}
	
	public void prinOut(){
		Iterator iterator = inputMap.keySet().iterator();

		while (iterator.hasNext()) {
		   int key = Integer.parseInt(iterator.next().toString());
		   int[] value = inputMap.get(key);
		   System.out.println("TRANSITION "+key);
		   System.out.println("---------------------------");
		   for(int i = 0; i<value.length; i++)
		   {
			   System.out.print(value[i]);
		   }
		   System.out.println("\n---------------------------");
		}
	}
}
