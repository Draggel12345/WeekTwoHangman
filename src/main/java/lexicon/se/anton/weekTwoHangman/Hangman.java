package lexicon.se.anton.weekTwoHangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	private String[] theWords = {"nirvana", "linkinpark", "gorillaz", "muse"};
	private String oneWord;
	private char[] rightGuess;
	private StringBuilder wrongGuess;
	private int numbOfGuesses;
	
	public Hangman(String oneWord) {
		this.oneWord = oneWord;
	    oneWord = theWords[new Random().nextInt(theWords.length - 1)];
	    rightGuess = new char[theWords.length];
	    wrongGuess = new StringBuilder();
	    numbOfGuesses = 1;
	}
	
	public char[] getRightGuess() {
		for(int i = 0; i < this.rightGuess.length; i++) {
			rightGuess[i] = '_';
		}
		return this.rightGuess;
	}
	public String getWrongGuess() {
		return this.wrongGuess.toString();
	}
	public int getNumbOfGuesses() {
		return this.numbOfGuesses;
	}
	
	private Hangman game;
	private static Scanner sr = new Scanner(System.in);

	public static void main(String[] args) {
				
		System.out.println("Welcome player to Hangman!" + "\n");
		System.out.println("The rules are as follow :" + "\n");
		System.out.println("You the player have 10 guesses, using letters"
				+ " or a whole word," + "\n"
				+ "to figure out the secret hidden word." + "\n"
				+ "If you figure out the secret word on 10 guesses or less" + "\n"
				+ "you win the game!" + "\n" + "Good luck and have fun!");
		
		//Hangman newStart = new Hangman();
		boolean wannaQuit = false;
		while(!wannaQuit) {
			System.out.println("Do you wish to continue? (y/n)");
			switch(sr.nextLine()) {
			case "n":
				wannaQuit = true;
				System.out.println("Thanks for stopping by!" + "\n"
				+ "Have a nice day!");
				break;
				default:
					
			}
		}
}
	
	public void play() {
		game = new Hangman(oneWord);
		System.out.println("Welcome to Hangman!");
		
		while(!game.winner()) {
			System.out.println("Guess " + game.getNumbOfGuesses() + " of 10");
			printArray();
			System.out.println(game.getWrongGuess());
			
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
		numbOfGuesses++;
		
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
		boolean guessesLessThan10 = getNumbOfGuesses() <= 10;
		boolean wordIsComplete = String.copyValueOf(rightGuess).equals(oneWord);
		
		if(guessesLessThan10 == wordIsComplete) {
			return true;
		}
		
		return false;
	}
}