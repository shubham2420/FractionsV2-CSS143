
public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction() { //default values
		this.numerator = 1;
		this.denominator = 1;
	}
	public Fraction(int x, int y) {
		if(x < 0 && y < 0) { // check if numerator and denominator are negative
			this.numerator = Math.abs(x);
			this.denominator = Math.abs(y);
		}
		this.numerator = x;
		if(! (y==0)) {
			this.denominator = y;
		}else {
			System.out.println("Not Valid");
		}
		this.reduce(this.numerator, this.denominator);
		
	}
	public void reduce(int num, int denom) {
		 int gcd = 1;
	        for(int i = 1; i <= num && i <= denom; i++) // finds the greatest common factor 
	        {
	            if(num%i==0 && denom%i==0)
	                gcd = i;
	        }
	        if (gcd != 1) {
	            num /= gcd;
	            denom /= gcd;
	        }
	        this.numerator = num;
	        this.denominator = denom;
	}
	public boolean equals(Object other) { //equals method for two fractions 
		if(this.numerator == ((Fraction) other).getNumerator() && 
				this.denominator == ((Fraction) other).getDenominator()) {
			return true;
		}
		return false;
	}
	public int getNumerator() { //returns numerator 
		return this.numerator;
	}
	public int getDenominator() { //returns denominator 
		return this.denominator;
	}
	public void setNumerator(int x) { // sets numerator 
		this.numerator = x;
	}
	public void setDenominator(int y) { // sets denominator 
		this.denominator = y;
	}
	public String toString() { // to string method for fraction object 
		return this.numerator + "/" + this.denominator;
	}
	
}
