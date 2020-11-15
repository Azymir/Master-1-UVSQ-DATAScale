package fr.uvsq.tod.fraction;

import static java.math.BigInteger.ONE;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

/**
 * La classe <code>Fraction</code> représente un nombre rationnel.
 *
 * @author hal
 * @version 2020
 */
public class Fraction implements Comparable<Fraction> {
	
	private final BigInteger denominator;
	private final BigInteger numerator;
	public static final Fraction ZERO = new Fraction(BigInteger.valueOf(0), BigInteger.valueOf(1));
    public static final Fraction UN_DEMI = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2));
    public static final Fraction UN = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(1));
  /**
   * Initialise un nombre rationnel avec un numérateur et un dénominateur.
   * @param numerator le numérateur
   * @param denominator le dénominateur
   */
  public Fraction(BigInteger numerator, BigInteger denominator) {
//	  this.numerator = numerator.divide(numerator.gcd(denominator));
//	  this.denominator = denominator.divide(numerator.gcd(denominator));
	  
	  this.numerator = numerator;
	  this.denominator = denominator;
  }

  /**
   * Initialise un nombre rationnel avec un numérateur et le dénominateur fixé à 1.
   * @param numerator le numérateur
   */
  public Fraction(BigInteger numerator) {
	  this.numerator = numerator;
	  this.denominator = BigInteger.valueOf(1);
  }

  /**
   * Initialise un nombre rationnel avec 0 comme numérateur et 1 comme dénominateur.
   */
  public Fraction() {
	  this.numerator = BigInteger.valueOf(0);
	  this.denominator = BigInteger.valueOf(1);
  }

  /**
   * Retourne le numérateur de la fraction.
   * @return le numérateur
   */
  public BigInteger getNumerator() {
    return this.numerator;
  }

  /**
   * Retourne le dénominateur de la fraction.
   * @return le dénominateur
   */
  public BigInteger getDenominator() {
	  return this.denominator;
  }

  /**
   * Retourne la valeur de la fraction en nombre à virgule flottante.
   * @return la valeur de la fraction
   */
  public double doubleValue() {
	  return this.numerator.doubleValue()/this.denominator.doubleValue();
  }

  /**
   * Retourne une fraction somme de la fraction courante et du paramètre.
   * @param aFraction la fraction à ajouter
   * @return la fraction somme
   */
  public Fraction add(Fraction aFraction) { 
	  return new Fraction (this.numerator.add(aFraction.numerator.multiply(this.denominator.divide(aFraction.denominator))).divide(this.numerator.add(aFraction.numerator.multiply(this.denominator.divide(aFraction.denominator))).gcd(this.denominator)), this.denominator.divide(this.denominator.gcd(this.numerator.add(aFraction.numerator.multiply(this.denominator.divide(aFraction.denominator))))));
//	  return new Fraction (this.numerator.add(aFraction.numerator.multiply(this.denominator.divide(aFraction.denominator))), this.denominator);
  }

  /**
   * Retourn respectivement un nombre négatif, nul ou positif si l'objet courant est plus petit, égal ou plus grand que l'argument.
   * @param aFraction la fraction à comparer
   * @return un nombre négatif, nul ou positif
   */
  @Override
	public int compareTo(Fraction aFraction) {
		if(this.doubleValue()>aFraction.doubleValue()) return 1;
		else if (this.doubleValue()<aFraction.doubleValue()) return -1;
		else return 0;
	}
  
  @Override
  public String toString() {
      String str = null;
      if (getDenominator() == BigInteger.valueOf(1)) str = this.numerator.toString();
      else if (getNumerator() == BigInteger.valueOf(0)) str = "0";
      else str = this.numerator.toString() + "/" + this.denominator.toString();
      return str;
  }
  
  @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if(this.doubleValue()==other.doubleValue()) return true;
		else return false;
	}
  
  @Override
  public int hashCode() {
	  return (int)this.doubleValue();
  }
}
