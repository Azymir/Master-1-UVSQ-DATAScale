package fr.uvsq.tod.compte;

public class ParseException extends Exception {
	public ParseException() {
		System.out.println("Impossible de realiser la transaction votre montant est superieur a votre solde de compte\n");
	}
}
