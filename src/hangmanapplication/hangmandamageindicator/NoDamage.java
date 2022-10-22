package hangmanapplication.hangmandamageindicator;

public class NoDamage implements HangmanDamageIndicator {
    @Override
    public void showHangmanDamage() {
        // Uses special characters
        /*System.out.println("┌─────┐\n" +
                           "┃     ┋\n" +
                           "┃     ┋\n" +
                           "┃\n" +
                           "┃\n" +
                           "┃\n");*/
        // Doesn't use any special characters
        System.out.println("┌─────┐\n" +
                           "|     |\n" +
                           "|     |\n" +
                           "|\n" +
                           "|\n" +
                           "|\n");
    }
}
