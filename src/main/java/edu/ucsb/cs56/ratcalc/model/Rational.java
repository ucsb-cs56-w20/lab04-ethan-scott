package edu.ucsb.cs56.ratcalc.model;

/** A class to represent a rational number
  with a numerator and denominator
  @author P. Conrad for CS56 F16
*/

public class Rational {

	private int num;
	private int denom;

	/**
	  greatest common divisor of a and b
	  @param a first number
	  @param b second number
	  @return gcd of a and b
	  */
	public static int gcd(int a, int b) {
		if (a==0)
			return b;
		else if (b==0)
			return a;
		else
			return gcd(b%a, a);
	}

	public Rational() {
		this.num = 1;
		this.denom = 1;
	}
	
	public Rational(int num, int denom) {
		if (denom== 0) {
			throw new IllegalArgumentException("denominator may not be zero");
		}
		this.num = num;
		this.denom = denom;
		
		if (num != 0) {
			int gcd = Rational.gcd(num,denom);
			this.num /= gcd;
			this.denom /= gcd;
		}
		
		if(this.denom < 0) {
			this.num = -1*this.num;
			this.denom = -1*this.denom;
		}
	
	}

	public String toString() {
		if (denom == 1 || num == 0)
			return "" + num;
		return num + "/" + denom;
	}

	public int getNumerator() { return this.num; }
	public int getDenominator() { return this.denom; }
	
	/**
	 this Rational number times r Rational number
	 @param r Rational number
	 @return Rational equal to this times r
	*/
	public Rational times(Rational r) {
		return new Rational(this.num * r.num,
				this.denom * r.denom);
	}
	
	/**
	 Rational a times Rational b
	 @param a Rational number
	 @param b Rational number
	 @return Rational equal to a times b
	 */
	public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num,
				a.denom * b.denom);
	}

	/**
	  least common multiple of a and b
	  @param a first number
	  @param b second number
	  @return lcm of a and b
	  */

	public static int lcm(int a, int b)
	{
		int numerator = Math.abs(a*b);
		int denominator = Rational.gcd(Math.abs(a),Math.abs(b));
		return numerator/denominator;
	}

	/**
	  this Rational number plus r Rational number
	  @param r Rational number
	  @return Rational number
	  */
	public Rational plus (Rational r)
	{
		int numerator = 0;
		int denominator = 1;
		int lcm1 = Rational.lcm(this.denom, r.denom);
		int a = lcm1/this.denom;
		int b = lcm1/r.denom;
		numerator = a*(this.num) + b*(r.num);
		denominator = lcm1;
		Rational r1;
		r1 = new Rational(numerator, denominator);
		return r1;
	}

	/**
	  Rational number a plus Rational number b
	  @param a Rational number
	  @param b Rational number
	  @return Rational number
	  */
	public static Rational sum(Rational a, Rational b)
	{
		int numerator = 0;
		int denominator = 1;
		int lcm1 = Rational.lcm(a.denom, b.denom);
		int a1 = lcm1/a.denom;
		int b1 = lcm1/b.denom;
		numerator = a1*(a.num) + b1*(b.num);
		denominator = lcm1;
		Rational r1;
		r1 = new Rational(numerator, denominator);
		return r1;
	}

	/**
	  this Rational number minus r Rational number
	  @param r Rational number
	  @return Rational number
	  */
	public Rational minus (Rational r)
	{
		int numerator = 0;
		int denominator = 1;
		int lcm1 = Rational.lcm(this.denom, r.denom);
		int a = lcm1/this.denom;
		int b = lcm1/r.denom;
		numerator = a*(this.num) - b*(r.num);
		denominator = lcm1;
		Rational r1;
		r1 = new Rational(numerator, denominator);
		return r1;
	}

	/**
	  Rational number a minus Rational number b
	  @param a Rational number
	  @param b Rational number
	  @return Rational number
	  */
	public static Rational difference(Rational a, Rational b)
	{
		int numerator = 0;
		int denominator = 1;
		int lcm1 = Rational.lcm(a.denom, b.denom);
		int a1 = lcm1/a.denom;
		int b1 = lcm1/b.denom;
		numerator = a1*(a.num) - b1*(b.num);
		denominator = lcm1;
		Rational r1;
		r1 = new Rational(numerator, denominator);
		return r1;
	}

	/**
	  reciprocal of this Rational number
	  @return Rational number
	  */
	public Rational reciprocalOf()
	{
		if(this.num == 0)
		{
			throw new ArithmeticException("denominator is zero");
		}
		Rational a = new Rational(this.denom,this.num);
		return a;
	}

	/**
	  this Rational number divided by r Rational number
	  @param r Rational number
	  @return Rational number
	  */
	public Rational dividedBy(Rational r)
	{
		int numerator = this.num * r.denom;
		int denominator = this.denom * r.num;
		Rational a = new Rational(numerator, denominator);
		return a;
	}	

	/**
	  Rational number a divided by Rational number b
	  @param a Rational number
	  @param b Rational number
	  @return Rational number
	  */
	public static Rational quotient(Rational a, Rational b){
		int numer1 = a.num * b.denom;
		int denom1 = a.denom * b.num;
		Rational c = new Rational(numer1, denom1);
		return c;
	}
	/**
	  For testing getters. 
	  @param args unused
	  */

	public static void main (String [] args) {
		Rational r = new Rational(5,7);
		System.out.println("r.getNumerator()=" + r.getNumerator());
		System.out.println("r.getDenominator()=" + r.getDenominator());
	}
}
