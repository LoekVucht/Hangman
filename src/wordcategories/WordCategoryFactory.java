package wordcategories;

import java.util.ArrayList;
import java.util.List;

public class WordCategoryFactory {
    private static WordCategoryFactory instance;
    private List<WordCategory> wordCategories = new ArrayList<>();

    public WordCategoryFactory() {
        wordCategories.add(new MinecraftWordCategory());
    }

    public static WordCategoryFactory getInstance() {
        if (instance == null) {
            instance = new WordCategoryFactory();
        }
        return instance;
    }

    public List<WordCategory> getWordCategories() {
        return wordCategories;
    }

    public WordCategory getWordCategory(String name) {
        switch (name) {
            case "Minecraft":
                return new MinecraftWordCategory();
        }
        return null;
    }
}
