import java.util.*;
public class FractionCounter extends Fraction {
	private Fraction  myFraction;
	private int counter;
	
	public FractionCounter(Fraction theFraction) {
		this.myFraction = theFraction;
		this.counter = 1;
	}
	public boolean compareAndIncrement(Fraction newFraction) {
		if(this.myFraction.equals(newFraction)) {  //if equal then adds 1 to the counter 
			counter ++;	
			return true;
		}
		return false;
	}
	public String toString() { //to string method for FractionCounter 
		return myFraction + " has a count of " + counter; 
	}
	public Fraction getFraction() {
		return this.myFraction;
	}
	public boolean equals(Fraction other) { // equals method for FractionCounter and comparing Fraction 
		if(this.myFraction.getNumerator() == other.getNumerator() && this.myFraction.getDenominator() 
				== other.getDenominator()) {
			return true;
		}
		return false;
	}
}
