package fr.uvsq.tod.compte;

public class PhraseException extends Exception {
	public PhraseException() {
		System.out.println("Impossible de realiser la transaction votre montant est inferieur a 0\n");
	}
}
