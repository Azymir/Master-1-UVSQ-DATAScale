package fr.uvsq.tod.wordanalyser;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordAnalyzerTest {
	@Test
	public void test1() {
		WordAnalyzer wa=new WordAnalyzer("aardvark"); // expect: a
		char result=wa.firstRepeatedCharacter();
		assertEquals(result,'a');
	}

   @Test
   public void test2() {
	   WordAnalyzer wa=new WordAnalyzer("roommate"); // expect: o (not m)
	   char result=wa.firstRepeatedCharacter();
	   assertEquals(result,'o');
	}
  
  @Test
  public void test3() {
	   WordAnalyzer wa=new WordAnalyzer("mate"); // expect: 0 (no duplicate letters)
	   char result=wa.firstRepeatedCharacter();
	   assertEquals(result,0);
  }

  @Test
  public void test4() {
	   WordAnalyzer wa=new WordAnalyzer("test"); // expect: 0 (the t isn't repeating)
	   char result=wa.firstRepeatedCharacter();
	   assertEquals(result,0);
  }
  
  @Test
	public void test5() {
	   WordAnalyzer wa=new WordAnalyzer("missisippi"); // expect: i (not m or s)
	   char result=wa.firstMultipleCharacter();
	   assertEquals(result,'i');
	}
	
	@Test
	public void test6() {
	   WordAnalyzer wa=new WordAnalyzer("mate"); // expect: 0 (no duplicate letters)
	   char result=wa.firstMultipleCharacter();
	   assertEquals(result,0);
	}
	
	@Test
	public void test7() {
	   WordAnalyzer wa=new WordAnalyzer("test"); // expect: t
	   char result=wa.firstMultipleCharacter();
	   assertEquals(result,'t');
	}
	
	@Test
	public void test8() {
	   WordAnalyzer wa=new WordAnalyzer("mississippiii"); // expect: 4 (ss, ss, pp, iii)
	   int result=wa.countRepeatedCharacters();
	   assertEquals(result,4);
	}
	
	@Test
	public void test9() {
	   WordAnalyzer wa=new WordAnalyzer("test"); // expect: 0 (no repeated letters)
	   int result=wa.countRepeatedCharacters();
	   assertEquals(result,0);
	}
	
	@Test
	public void test10() {
	   WordAnalyzer wa=new WordAnalyzer("aabbcdaaaabb"); // expect: 4 (aa, bb, aaaa, bb)
	   int result=wa.countRepeatedCharacters();
	   assertEquals(result,4);
	}
}
