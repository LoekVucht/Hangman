package hangmanapplication;

import hangmanapplication.wordcategories.WordCategory;

import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    private List<Character> correctlyGuessedLetters = new ArrayList<>();
    private List<Character> wronglyGuessedLetters = new ArrayList<>();
    private WordCategory wordCategory;
    private String word;
    private Hangman hangman;
    private static int MAX_ALLOWED_AMOUNT_OF_MISTAKES = 7;

    public HangmanGame(Hangman hangman, WordCategory wordCategory) {
        this.hangman = hangman;
        this.wordCategory = wordCategory;
    }

    public void showHangman() {
        hangman.showHangman(wronglyGuessedLetters.size());
    }

    public void generateRandomWord() {
        word = wordCategory.getRandomWord();
    }

    public boolean letterHasAlreadyBeenGuessed(char letter) {
        return correctlyGuessedLetters.contains(letter) || wronglyGuessedLetters.contains(letter);
    }

    public void checkLetter(char letter) {
        if (word.indexOf(letter) == -1) {
            wronglyGuessedLetters.add(letter);
        } else {
            correctlyGuessedLetters.add(letter);
        }
    }

    public boolean allLettersHaveBeenGuessed() {
        for (char wordLetter : word.toCharArray()) {
            if (wordLetter != ' ') {
                if (!correctlyGuessedLetters.contains(wordLetter)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean maxAmountOfMistakesHaveBeenMade() {
        return wronglyGuessedLetters.size() == MAX_ALLOWED_AMOUNT_OF_MISTAKES;
    }

    public String getWord() {
        return word;
    }

    public List<Character> getCorrectlyGuessedLetters() {
        return correctlyGuessedLetters;
    }

    public List<Character> getWronglyGuessedLetters() {
        return wronglyGuessedLetters;
    }
}
