package lexicon.se.anton.weekTwoHangman;

public class HangMan {

	private String[] words = { "hate", "love", "hangman" };
	private String randomWord = words[(int) (Math.random() * words.length)];
	private char[] wordsArray;
	private StringBuilder guesses;
	private int numbOfGuesses;
	private int maxNumbOfGuesses = 10;

	public HangMan() {

		this.wordsArray = new char[randomWord.length()];
		this.guesses = new StringBuilder();
		this.numbOfGuesses = 0;

		for (int i = 0; i < wordsArray.length; i++) {
			wordsArray[i] = '_';
		}
	}

	public HangMan(String test) {

		this.randomWord = test;
		this.wordsArray = new char[randomWord.length()];
		this.guesses = new StringBuilder();
		this.numbOfGuesses = 0;

		for (int i = 0; i < wordsArray.length; i++) {
			wordsArray[i] = '_';
		}
	}

	public String guessMade(String guess) {

		guess = guess.trim();

		if (guess.length() == 1) {
			return guessedLetterMade(guess.charAt(0));
		} else {
			if (guess.length() > 1) {
				return guessedWordMade(guess);
			}
		}

		return "Try again!";
	}

	public String guessedLetterMade(char letter) {

		if (checkIfLetterAlreadyHaveBeenEnterd(letter)) {
			return "You have already guessed : " + letter;
			
		} 
		else if (checkIfLetterIsInWord(letter)) {
			numbOfGuesses++;
			return "Good job! : " + letter + " was in the word!";
			
		} 
		else if (!checkIfLetterIsInWord(letter)) {
			guesses.append(letter);
			numbOfGuesses++;
			return "Try again : " + letter + " is not in the word";
		}

		return "Error";
	}

	public String guessedWordMade(String word) {

		if (checkIfGuessEqualsWord(word)) {
			numbOfGuesses++;
			return "Good job! The word is : " + word;
		}

		if (!checkIfGuessEqualsWord(word)) {
			numbOfGuesses++;
			guesses.append(word);
			return word + " is not the secret word";
		}

		return "Error";
	}

	public boolean checkIfLetterIsInWord(char letter) {

		boolean isInWord = false;

		for (int i = 0; i < randomWord.length(); i++) {
			if (randomWord.charAt(i) == letter) {
				wordsArray[i] = letter;
				isInWord = true;
			}
		}

		return isInWord;
	}

	public boolean checkIfGuessEqualsWord(String word) {

		boolean wordEqualsWord = false;

		if (randomWord.equals(word)) {
			wordsArray = randomWord.toCharArray();
			wordEqualsWord = true;
		}

		return wordEqualsWord;
	}

	public boolean checkIfLetterAlreadyHaveBeenEnterd(char letter) {

		boolean alreadyEnterd = false;

		for (int i = 0; i < wordsArray.length; i++) {
			if (wordsArray[i] == letter) {
				alreadyEnterd = true;
			}
		}
		
		for (int i = 0; i < guesses.length(); i++) {
			if (guesses.charAt(i) == letter) {
				alreadyEnterd = true;
			}
		}
		
		return alreadyEnterd;
	}

	public boolean isWinner() {

		boolean wordIsComplete = String.valueOf(wordsArray).equals(randomWord);

		return wordIsComplete;

	}

	public String getRandomWord() {
		return this.randomWord;
	}
	
	public char[] getWordsArray() {
		return wordsArray;
	}

	public String getGuesses() {
		return guesses.toString();
	}

	public int getNumbOfGuesses() {
		return numbOfGuesses;
	}

	public int getMaxNumbOfGuesses() {
		return maxNumbOfGuesses;
	}

}
