package hangmanapplication;

import hangmanapplication.wordcategories.WordCategory;
import hangmanapplication.wordcategories.WordCategoryFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HangmanConsole {
    private static Map<Integer, WordCategory> wordCategoriesMap = new HashMap<>();

    public static void main(String[] args) {
        playHangman();
    }

    private static void playHangman() {
        printOpeningMessage();
        putExistingWordCategoriesIntoMap();
        printWordCategories();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String wordCategoryInput = scanner.nextLine();
            if (wordCategoryExists(wordCategoryInput)) {
                playGame(scanner, wordCategoryInput);
                while (true) {
                    System.out.println("Would you like to play again? (Y/N)");
                    String answer = scanner.nextLine();;
                    if (answer.equalsIgnoreCase("y")) {
                        playHangman();
                        break;
                    }
                    if (answer.equalsIgnoreCase("n")) {
                        scanner.close();
                        System.out.println("Thanks for playing!");
                        try {
                            TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    else {
                        System.out.println("Enter \"y\" or \"n\".");
                    }
                }
                break;
            } else {
                System.out.println("Enter a valid category number.");
            }
        }
    }

    private static void playGame(Scanner scanner, String wordCategoryInput) {
        HangmanGame game = new HangmanGame(new Hangman(), wordCategoriesMap.get(Integer.parseInt(wordCategoryInput)));
        game.generateRandomWord();
        printLetters(game);
        guessLetters(scanner, game);
        if (game.allLettersHaveBeenGuessed()) System.out.println("You guessed the word \"" + game.getWord() + "\", and the hangman gets to live!");
        else System.out.println("You failed to guess the word \"" + game.getWord() + "\", and the hangman has died. RIP bozo!");
    }

    private static void guessLetters(Scanner scanner, HangmanGame game) {
        while (!(game.allLettersHaveBeenGuessed() || game.maxAmountOfMistakesHaveBeenMade())) {
            System.out.println("Enter a letter.");
            String letterInput = scanner.nextLine();
            if (letterInput.length() != 1) continue;
            char guessedLetter;
            try {
                guessedLetter = letterInput.charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
            if (!Character.isLetter(guessedLetter)) {
                continue;
            }
            if (game.letterHasAlreadyBeenGuessed(guessedLetter)) {
                System.out.println("You've already guessed this letter.");
                continue;
            }
            game.checkLetter(guessedLetter);
            game.showHangman();
            if (game.allLettersHaveBeenGuessed() || game.maxAmountOfMistakesHaveBeenMade()) break;
            printLetters(game);
            if (game.getCorrectlyGuessedLetters().size() > 0) printCorrectlyGuessedCharacters(game);
            if (game.getWronglyGuessedLetters().size() > 0) printWronglyGuessedCharacters(game);
        }
    }

    private static void printLetters(HangmanGame game) {
        char[] wordLetters = game.getWord().toCharArray();
        for (char letter : wordLetters) {
            if (letter == ' ') {
                System.out.print(" ");
            }
            else if (game.getCorrectlyGuessedLetters().contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static void printWronglyGuessedCharacters(HangmanGame game) {
        System.out.print("Wrongly guessed: ");
        for (Character character : game.getWronglyGuessedLetters()) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    private static void printCorrectlyGuessedCharacters(HangmanGame game) {
        System.out.print("Correctly guessed: ");
        for (Character character : game.getCorrectlyGuessedLetters()) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    private static void printOpeningMessage() {
        System.out.println("Welcome to Hangman!");
        printVisualLine();
        System.out.println("Enter a category number:");
    }
    
    private static void printVisualLine() {
        System.out.println("------------------------");
    }

    private static void putExistingWordCategoriesIntoMap() {
        int categoryIndex = 1;
        WordCategoryFactory wordCategoryFactory = WordCategoryFactory.getInstance();
        for (WordCategory wordCategory : wordCategoryFactory.getWordCategories()) {
            wordCategoriesMap.put(categoryIndex, wordCategory);
            categoryIndex++;
        }
    }

    private static boolean wordCategoryExists(String key) {
        try {
            if (wordCategoriesMap.containsKey(Integer.parseInt(key))) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    private static void printWordCategories() {
        for (Integer key : wordCategoriesMap.keySet()) {
            System.out.println(key + " - " + wordCategoriesMap.get(key).getName());
        }
    }
}
