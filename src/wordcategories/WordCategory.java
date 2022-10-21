package wordcategories;

import java.util.List;
import java.util.Random;

public abstract class WordCategory {
    protected String name;
    private List<String> words;

    public WordCategory(String name, List<String> words) {
        this.name = name;
        this.words = words;
    }

    public String getRandomWord() {
        return words.get(new Random().nextInt(words.size()));
    }

    public String getName() {
        return name;
    }
}
