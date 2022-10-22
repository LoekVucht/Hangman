package hangmanapplication.hangmandamageindicator;

public class ThirdDamageLevel implements HangmanDamageIndicator {
    @Override
    public void showHangmanDamage() {
        /*System.out.println("┌─────┐\n" +
                           "┃     ┋\n" +
                           "┃     ┋\n" +
                           "┃     😮\n" +
                           "┃    /|\n" +
                           "┃\n");*/
        System.out.println("┌─────┐\n" +
                           "|     |\n" +
                           "|     |\n" +
                           "|     O\n" +
                           "|    /|\n" +
                           "|\n");
    }
}
