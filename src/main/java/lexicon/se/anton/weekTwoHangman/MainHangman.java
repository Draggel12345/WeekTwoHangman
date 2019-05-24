package lexicon.se.anton.weekTwoHangman;

import java.util.Random;
import java.util.Scanner;

public class MainHangman {
	
	private String[] theWords = { "nirvana", "linkinpark", "gorillaz", "muse" };
	private String oneWord;
	private char[] rightGuess;
	private StringBuilder wrongGuess;
	private int numOfGuesses;
	
	public MainHangman(String oneWord) {
		this.oneWord = oneWord;
		
		for (int i = 0; i < rightGuess.length; i++) {
			 rightGuess[i] = '_';
		}
	}
	
	public String getOneWord() {
		oneWord = theWords[new Random().nextInt(theWords.length - 1)];
		return this.oneWord;
	}
	
	public char[] getRightGuess() {
		rightGuess = new char[this.theWords.length];
		return this.rightGuess;
	}
	
	public int getnumOfGuesses() {
		numOfGuesses = 1;
		return this.numOfGuesses;
	}
	
	public String getWrongGuesses() {
		wrongGuess = new StringBuilder();
		return this.wrongGuess.toString();
	}
	
	public String guess(String guess) {
		guess = guess.trim();

		if (guess.length() == 1) {
			return guessLetter(guess.charAt(0));
		}
		
		return null;
	}
	
	public String guessLetter(char letter) {
		if(guessAlreadyMade(letter)) {
	        return "Try again! " + letter + " already exist!";
		}
		numOfGuesses++;
		
		if(wordContainsLetter(letter)) {
		    return "Good job! " + letter + " is in the word!";
		}
		wrongGuess.append(letter);
		    return "To bad! " + letter + " was not in the word!";
	}
	
	public boolean guessAlreadyMade(char letter) {
		for(int i = 0; i < rightGuess.length; i++) {
			if(rightGuess[i] == letter) {
				return true;
			}
		}
		for(int i = 0; i < wrongGuess.length(); i++) {
			if(wrongGuess.charAt(i) == letter) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean wordContainsLetter(char letter) {
		for(int i = 0; i < oneWord.length(); i++) {
			if(oneWord.charAt(i) == letter) {
				return true;
			}
		}
		
		return false;	
	}
	
	public boolean winner() {
		boolean guessesLessThan10 = getnumOfGuesses() <= 10;
		boolean wordIsComplete = String.copyValueOf(rightGuess).equals(oneWord);
		
		if(guessesLessThan10 == wordIsComplete) {
			return true;
		}
		
		return false;
	}
}

private MainHangman game;
private static Scanner sr = new Scanner(System.in);

public static void main(String[] args) {
	
	MainHangman hangman = new MainHangman(oneWord);
	boolean wannaQuit = false;
	while(!wannaQuit) {
		System.out.println("Do you want to play? (y/n)");
		switch(sr.nextLine()) {
		case "n":
			wannaQuit = true;
			System.out.println("Good bye!");
			break;
			default:
				play();
		}
	}

}

public void play() {
	game = new MainHangman(oneWord);
	System.out.println("Welcome to Hangman!");
	
	while(!game.winner()) {
		System.out.println("Guess " + game.getnumOfGuesses() + " of 10");
		printArray();
		System.out.println(game.getWrongGuesses());
		
		System.out.println("Enter a guess for a letter or the word");
		String guess = sr.nextLine();
		String message = game.guess(guess);
		System.out.println(message);
	}
}

public void printArray() {
	
	for(char letter : game.getRightGuess()) {
		System.out.print(letter + " ");
	}
	System.out.println();
}
