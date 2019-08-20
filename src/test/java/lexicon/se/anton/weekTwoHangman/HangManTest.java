package lexicon.se.anton.weekTwoHangman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HangManTest {

	private HangMan testHangMan;
	
	@Before
	public void setup() {
		testHangMan = new HangMan("test");
	}

	@Test
	public void test_GuessedLetterMade_PASS() {
		String guess = "t";
		String expected = "Good job! : " + guess + " was in the word!";
		char[] expecteds = {'t', '_', '_', 't'};
		int expectedGuesses = 1;
		
		String actual = testHangMan.guessMade(guess);
		char[] actuals = testHangMan.getWordsArray();
		int actualGuesses = testHangMan.getNumbOfGuesses();
		
		assertEquals(expected, actual);
		assertArrayEquals(expecteds, actuals);
		assertEquals(expectedGuesses, actualGuesses);
	}
	
	@Test
	public void test_GuessedLetterMade_FAIL() {
		String guess = "a";
		String expected = "Try again : " + guess + " is not in the word";
		char[] expecteds = {'_', '_', '_', '_'};
		int expectedGuesses = 1;
		
		String actual = testHangMan.guessMade(guess);
		char[] actuals = testHangMan.getWordsArray();
		int actualGuesses = testHangMan.getNumbOfGuesses();
		
		assertEquals(expected, actual);
		assertArrayEquals(expecteds, actuals);
		assertEquals(expectedGuesses, actualGuesses);
	}

	@Test
	public void test_GuessedWordMade_PASS() {
		String guess = "test";
		String expected = "Good job! The word is : " + guess;
		char[] expecteds = {'t', 'e', 's', 't'};
		int expectedGuesses = 1;
		
		String actual = testHangMan.guessMade(guess);
		char[] actuals = testHangMan.getWordsArray();
		int actualGuesses = testHangMan.getNumbOfGuesses();
		
		assertEquals(expected, actual);
		assertArrayEquals(expecteds, actuals);
		assertEquals(expectedGuesses, actualGuesses);

	}
	
	@Test
	public void test_GuessedWordMade_FAIL() {
		String guess = "appel";
		String expected = guess + " is not the secret word";
		char[] expecteds = {'_', '_', '_', '_'};
		int expectedGuesses = 1;
		
		String actual = testHangMan.guessMade(guess);
		char[] actuals = testHangMan.getWordsArray();
		int actualGuesses = testHangMan.getNumbOfGuesses();
		
		assertEquals(expected, actual);
		assertArrayEquals(expecteds, actuals);
		assertEquals(expectedGuesses, actualGuesses);

	}

	@Test
	public void test_CheckIfLetterIsInWord_PASS() {
		char guess = 't';
		boolean expected = true;
		
		boolean actual = testHangMan.checkIfLetterIsInWord(guess);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_CheckIfLetterIsInWord_FAIL() {
		char guess = 'a';
		boolean expected = false;
		
		boolean actual = testHangMan.checkIfLetterIsInWord(guess);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test_CheckIfGuessEqualsWord_PASS() {
		String guess = "test";
		boolean expected = true;
		
		boolean actual = testHangMan.checkIfGuessEqualsWord(guess);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_CheckIfGuessEqualsWord_FAIL() {
		String guess = "appel";
		boolean expected = false;
		
		boolean actual = testHangMan.checkIfGuessEqualsWord(guess);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test_CheckIfLetterAlreadyHaveBeenEnterd_PASS() {
		testHangMan.guessMade("t");
		testHangMan.guessMade("t");
		assertEquals(testHangMan.getNumbOfGuesses(), 1);
	}

	@Test
	public void test_IsWinner_PASS() {
		
		testHangMan.guessMade("t");
		testHangMan.guessMade("e");
		testHangMan.guessMade("s");
		
		assertTrue(testHangMan.isWinner());
	}
	
	@Test
	public void test_IsWinner_FAIL_over10() {
		
		testHangMan.guessMade("a");
		testHangMan.guessMade("b");
		testHangMan.guessMade("c");
		testHangMan.guessMade("d");
		testHangMan.guessMade("e");
		testHangMan.guessMade("f");
		testHangMan.guessMade("g");
		testHangMan.guessMade("h");
		testHangMan.guessMade("i");
		testHangMan.guessMade("j");
		testHangMan.guessMade("k");
		
		assertFalse(testHangMan.isWinner());
	}
	
	@Test
	public void test_IsWinner_FAIL_wrongLetters() {
		
		testHangMan.guessMade("b");
		testHangMan.guessMade("o");
		testHangMan.guessMade("r");
		testHangMan.guessMade("n");
		
		assertFalse(testHangMan.isWinner());
	}
}
