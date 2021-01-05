import java.io.*;
import java.util.*;
public class Driver {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new FileInputStream("fractions.txt")); //creates scanner object for fraction
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		ArrayList <FractionCounter> finalList = new ArrayList<FractionCounter>(); //arraylist of fractioncounters
		ArrayList <Fraction> fractionList = new ArrayList<Fraction>(); //arraylist of fractions
		while(scan.hasNextLine()) {
			String[] temp = scan.nextLine().split("/"); // splits the fractions into two parts 
	        int num = Integer.parseInt(temp[0]);
	        int denom = Integer.parseInt(temp[1]); 
			fractionList.add(new Fraction(num, denom));  
		}
		for(int i = 0; i < fractionList.size()-1; i++) { // cycles through the fractions to find occurences 
			FractionCounter tempFrac = new FractionCounter(fractionList.get(i)); // turns fractions into a temp fraction counter
			for(int x  = i+1; x < fractionList.size(); x++ ) { 
				if(!fractionList.get(i).equals(fractionList.get(x))) { //if both fractions are not the same
					if (!inListAlready(finalList,tempFrac.getFraction())) //if the fraction is not in finalList
						finalList.add(tempFrac); // adds fraction to fractionList
					}else {
						tempFrac.compareAndIncrement(fractionList.get(x)); // compares and increments if same fraction
					}
			}//~ for int x
		}//~ for int i
		finalList.forEach((n) -> System.out.println(n));
	}//~ main
	public static boolean inListAlready(ArrayList <FractionCounter> finalList, Fraction myFrac) {
	boolean foundinList=false;	
	Iterator it=finalList.iterator();
	while (it.hasNext()) { // Iterate through finalList to find if duplicate fraction exists 
		 if (((FractionCounter)it.next()).getFraction().equals(myFrac)) {
		 foundinList=true;
		 break;
		 }
	}//~ while
	return foundinList;
	}
}
