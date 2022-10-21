package hangmanapplication;

import wordcategories.MinecraftWordCategory;
import wordcategories.WordCategory;
import wordcategories.WordCategoryFactory;

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
            String input = scanner.nextLine();
            if (wordCategoryExists(input)) {
                HangmanGame game = new HangmanGame(new Hangman(), wordCategoriesMap.get(input));
                game.generateRandomWord();
                System.out.println(game.getWord());
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
            wordCategoriesMap.put(categoryIndex, wordCategoryFactory.getWordCategory("Minecraft"));
            categoryIndex++;
        }
    }

    private static boolean wordCategoryExists(String key) {
        try {
            if (wordCategoriesMap.containsKey(Integer.parseInt(key))) {
                return true;
            }
        } catch (NumberFormatException nfe) {
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
