import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import sun.misc.Queue;


public class PNet {

	int places, transitions;
	int placesCount = 0;
	String temp = "";
	int[] initialMarking;
	
	
	Queue<String> answers = new Queue<String>();
	
	ArrayList<String> reach = new ArrayList<String>();
	HashMap<Integer, int[]> inputMap;
	HashMap<Integer, int[]> outputMap;
	HashMap<Integer, int[]> reachable;
	
	public PNet(int places, int transitions)
	{
		this.places = places;
		this.transitions = transitions;
		
		inputMap = new HashMap<Integer, int[]>();
		outputMap = new HashMap<Integer, int[]>();
		reachable = new HashMap<Integer, int[]>();
		initialMarking = new int[places];
	}
	
	public void addInput(int transition, String marking){
		int[] inputTransition = new int[places];
		placesCount = 0;
		marking += ",";
			for(int i = 0; i<marking.length(); i++){
				if(marking.charAt(i)!=',')
					temp += marking.charAt(i);
				else{
					inputTransition[placesCount] = Integer.parseInt(temp);
					placesCount++;
					temp = "";
				}
			}
			inputMap.put(transition, inputTransition);
			
	}
	
	public void addOutput(int transition, String marking){
		int[] outputTransition = new int[places];
		placesCount = 0;
		marking+=",";
			for(int i = 0; i<marking.length(); i++){
				if(marking.charAt(i)!=',')
					temp+=marking.charAt(i);
				else{
					outputTransition[placesCount] = Integer.parseInt(temp);
					placesCount++;
					temp = "";
				}
			}
			outputMap.put(transition, outputTransition);
	}
	
	public void addInitialMarking(String marking){
		placesCount = 0;
		marking+=",";
		for(int i = 0; i<marking.length(); i++){
			if(marking.charAt(i)!=','){
				temp+=marking.charAt(i);
			}
			else{
				initialMarking[placesCount] = Integer.parseInt(temp);
				placesCount++;
				temp = "";
			}
		}
	}
	
	public void calculations(){
		int[] tempIMarking = getMarking(initialMarking);
		
		String tempVal = "";
		int val = 0;
		for(int i =1; i<=transitions; i++){
			int[] mark = createUnique();
			for(int j = 0; j<places; j++){
				val = tempIMarking[j] - inputMap.get(i)[j] + outputMap.get(i)[j];
				mark[j] = tempIMarking[j] - inputMap.get(i)[j] + outputMap.get(i)[j];
				tempIMarking[j] = tempIMarking[j] - inputMap.get(i)[j] + outputMap.get(i)[j];
				tempVal += (val+",");
			}
			reachable.put(i, mark);
			reach.add(tempVal);
			tempVal="";
		}
	}
	
	public void calculations2(){
		int[] tempIMarking = getMarking(initialMarking);
		reachable.put(0, tempIMarking);
		boolean add = true;
		String tempVal = "";
		int val = 0;
		//initialMarking.length
		System.out.println("REACHABLE size "+reachable.size());
		for(int x = 0; x<reachable.size(); x++){
				int[] temp = reachable.get(x);
				for(int i =1; i<=transitions; i++){
					int[] mark = createUnique();
					for(int j = 0; j<places; j++){
						val = temp[j] - inputMap.get(i)[j] + outputMap.get(i)[j];
						mark[j] = temp[j] - inputMap.get(i)[j] + outputMap.get(i)[j];
						tempVal += (val+",");
						if(val < 0)
							add = false; 
					}
					if(!reach.contains(tempVal) && add == true){
						reach.add(tempVal);
					}
					add = true;
					tempVal="";
			}
		}
	}
	
	public int[] createUnique(){
		return new int[places];
	}
	
	public void printOutIMarking(int[] m){
		System.out.println("\nReachable Marking:");
		for(int i = 0; i<m.length; i++){
			System.out.print(m[i]+",");
		}
		System.out.println("\nEND Reachable Marking");
	}
	
	public int[] getMarking(int[] m){
		int[] temp = new int[m.length];
		for(int i =0; i<m.length; i++){
			temp[i] = m[i];
		}
		
		return temp;
	}
	
	public void prinOutInput(){
		Iterator iterator = inputMap.keySet().iterator();

		while (iterator.hasNext()) {
		   int key = Integer.parseInt(iterator.next().toString());
		   int[] value = inputMap.get(key);
		   System.out.println("TRANSITION "+key);
		   System.out.println("---------------------------");
		   for(int i = 0; i<value.length; i++)
		   {
			   System.out.print(value[i]+",");
		   }
		   System.out.println("\n---------------------------");
		}
	}
	
	public void prinOutOutput(){
		Iterator iterator = outputMap.keySet().iterator();

		while (iterator.hasNext()) {
		   int key = Integer.parseInt(iterator.next().toString());
		   int[] value = outputMap.get(key);
		   System.out.println("TRANSITION "+key);
		   System.out.println("---------------------------");
		   for(int i = 0; i<value.length; i++)
		   {
			   System.out.print(value[i]+",");
		   }
		   System.out.println("\n---------------------------");
		}
	}
	
	public void printOutReachable(){
			
		for(int i = 0; i<reach.size(); i++){
			System.out.println("Reachable marking: "+(i+1));
			System.out.println(reach.get(i));
		}
		
	}
	
	public void iterateReachable(){
		Iterator iterator = reachable.keySet().iterator();

		while (iterator.hasNext()) {
		   int key = Integer.parseInt(iterator.next().toString());
		   int[] value = reachable.get(key);
		   System.out.println("TRANSITION "+key);
		   System.out.println("---------------------------");
		   for(int i = 0; i<value.length; i++)
		   {
			   System.out.print(value[i]+",");
		   }
		   System.out.println("\n---------------------------");
		}
	}
	
	public void printOutInitialMarking(){
		System.out.println("Initial Marking");
		System.out.println("---------------------------");
		for(int i = 0; i<initialMarking.length; i++){
			System.out.print(initialMarking[i]+",");
		}
		 System.out.println("\n---------------------------");
	}
}
