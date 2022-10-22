package hangmanapplication.wordcategories;

import java.util.ArrayList;
import java.util.List;

public class WordCategoryFactory {
    private static WordCategoryFactory instance;
    private List<WordCategory> wordCategories = new ArrayList<>();

    public WordCategoryFactory() {
        wordCategories.add(new MinecraftWordCategory());
        wordCategories.add(new TerminallyOnlineWordCategory());
        wordCategories.add(new PoliticiansWordCategory());
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
}
