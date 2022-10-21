package hangmanapplication;

import hangmanapplication.Hangman;
import wordcategories.WordCategory;

import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    private List<Character> correctlyGuessedLetters = new ArrayList<>();
    private List<Character> wronglyGuessedLetters = new ArrayList<>();
    private WordCategory wordCategory;
    private String word;
    private Hangman hangman;

    public HangmanGame(Hangman hangman, WordCategory wordCategory) {
        this.hangman = hangman;
        this.wordCategory = wordCategory;
    }

    public void setWordCategory(WordCategory wordCategory) {
        this.wordCategory = wordCategory;
    }

    public void showHangman() {
    }

    public void generateRandomWord() {
        word = wordCategory.getRandomWord();
    }

    public boolean letterHasAlreadyBeenGuessed(char letter) {
        return correctlyGuessedLetters.contains(letter);
    }

    public void checkLetter(char letter) {
        if (word.indexOf(letter) == -1) {
            wronglyGuessedLetters.add(letter);
        } else {
            correctlyGuessedLetters.add(letter);
        }
    }

    public String getWord() {
        return word;
    }
}
