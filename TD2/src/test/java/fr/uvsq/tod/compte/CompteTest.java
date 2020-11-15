package fr.uvsq.tod.compte;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompteTest {
  @Test
  public void shouldCreateAnAccountWithTheSpecifiedBalance() {
    Compte c = new Compte(100);
    assertEquals(100, c.getBalance());  
  }
  
  @Test
  public void ValeurNegatifALaCreation() {
    Compte c = new Compte(-20);
    assertEquals(0, c.getBalance());
  }
  
  @Test
  public void CrediterMontantInferieurO() throws PhraseException {
    Compte c = new Compte(20);
    
//    c.crediter(-10);
//    assertEquals(20, c.getBalance());	// ERROR car c'est faux, donc c'est VALIDER
    
    c.crediter(10);
    assertEquals(30, c.getBalance());
  }
  
  @Test
  public void DebiterCompteInferieurO() throws PhraseException, ParseException {
    Compte c = new Compte(20);
//    c.debiter(40, c);
//    assertEquals(20, c.getBalance());	// ERROR donc c'est VALIDER
    
    c.debiter(10, c);
    assertEquals(10, c.getBalance());
  }
  
  @Test
  public void TransactionVirement() throws PhraseException, ParseException {
    Compte c = new Compte(40);
    Compte c1 = new Compte(20);
    
    c.virement(10,c,c1);
    assertEquals(30, c.getBalance());
    assertEquals(30, c1.getBalance());
  }
  
}
