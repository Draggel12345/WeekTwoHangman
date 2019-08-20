package lexicon.se.anton.weekTwoHangman;

import java.util.Scanner;

public class App {

	private HangMan game;
	private static Scanner sr = new Scanner(System.in);

	public static void main(String[] args) {

		App app = new App();

		boolean quit = false;

		while (!quit) {
			System.out.println("Do you want to play? y <--> n");

			switch (sr.nextLine().toLowerCase()) {
			case "n":
				quit = true;
				System.out.println("Good bye!");
				break;
			default:
				app.play();
			}
		}
	}

	void play() {

		game = new HangMan();
		System.out.println("Hangman!");
		
		while (!game.isWinner() && game.getNumbOfGuesses() != game.getMaxNumbOfGuesses()) {
			System.out.println("Guesses made: " + game.getNumbOfGuesses() + " of 10.");
			rightLettersGuessed();
			System.out.println(game.getGuesses());

			System.out.println("Guess the right letter or word!");
			String guess = sr.nextLine();
			String message = game.guessMade(guess);
			System.out.println(message);
		}
		if (game.isWinner()) {
			rightLettersGuessed();
			System.out.println("Good job! You won! The word is: " + game.getRandomWord());
		} else {
			if (game.getNumbOfGuesses() == game.getMaxNumbOfGuesses()) {
			rightLettersGuessed();
			System.out.println("To bad, you lose. The word was: " + game.getRandomWord());
			}
		}
	}

	void rightLettersGuessed() {

		for (char letter : game.getWordsArray()) {
			System.out.print(letter + " ");
		}
		System.out.println();
	}
	
	
}
