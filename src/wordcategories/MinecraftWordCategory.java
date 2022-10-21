package wordcategories;

import hangmanapplication.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinecraftWordCategory extends WordCategory {
    private List<String> words = new ArrayList<>();

    public MinecraftWordCategory() {
        super("Minecraft", Arrays.asList("creeper", "zombie", "skeleton", "wither"));
    }
}
