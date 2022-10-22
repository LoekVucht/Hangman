package hangmanapplication;

import hangmanapplication.wordcategories.WordCategory;
import hangmanapplication.wordcategories.WordCategoryFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HangmanConsole {
    private static Map<Integer, WordCategory> wordCategoriesMap = new HashMap<>();

    public static void main(String[] args) {
        printOpeningMessage();
        putExistingWordCategoriesIntoMap();
        printWordCategories();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String wordCategoryInput = scanner.nextLine();
            if (wordCategoryExists(wordCategoryInput)) {
                HangmanGame game = new HangmanGame(new Hangman(), wordCategoriesMap.get(Integer.parseInt(wordCategoryInput)));
                game.generateRandomWord();
                System.out.println(game.getWord());
                while (true) {
                    System.out.println("Enter a letter.");
                    char letterInput;
                    try { letterInput = scanner.nextLine().charAt(0); }
                    catch (StringIndexOutOfBoundsException e) { continue; }
                    if (!Character.isLetter(letterInput)) continue;
                    if (game.letterHasAlreadyBeenGuessed(letterInput)) {
                        System.out.println("You've already guessed this letter.");
                        continue;
                    }
                    game.checkLetter(letterInput);
                    System.out.println("Amount of correctly guessed letters: " + game.getAmountOfCorrectlyGuessedLetters());
                    System.out.println("Amount of wrongly guessed letters: " + game.getAmountOfWronglyGuessedLetters());
                    game.showHangman();
                }
            } else {
                System.out.println("Enter a valid category number.");
            }
        }
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
