package fr.uvsq.tod.compte;

/**
 * La classe <code>Compte</code> représente un compte bancaire.
 *
 * @author hal
 * @version 2020
 */
public class Compte {
	private int initialBalance;
  public Compte(int initialBalance) {
	  this.initialBalance = initialBalance;
  }

  public int getBalance() {
	  if(this.initialBalance < 0) {return 0;}
	  return this.initialBalance;
  }

public void crediter(int montant) throws PhraseException {
	if (montant < 0) throw new PhraseException();
	this.initialBalance += montant;
//	System.out.println("Crediter = "+montant);
}

public void debiter(int montant,Compte c1) throws ParseException, PhraseException {
	if (c1.initialBalance < 0) throw new ParseException();
	if (this.initialBalance - montant < 0) throw new PhraseException();
	this.initialBalance -= montant;
//	System.out.println("Debiter = "+montant);		
}

public void virement(int montant,Compte c1,Compte c2) throws PhraseException, ParseException {
	if (c1.initialBalance < 0) throw new ParseException();
	if (this.initialBalance - montant < 0) throw new PhraseException();
	c1.debiter(montant, c1);
	c2.crediter(montant);
	
	
}
}

