package hangmanapplication.hangmandamageindicator;

public class FifthDamageLevel implements HangmanDamageIndicator {
    @Override
    public void showHangmanDamage() {
        System.out.println("┌─────┐\n" +
                           "┃     ┋\n" +
                           "┃     ┋\n" +
                           "┃     😮\n" +
                           "┃    /|\\\n" +
                           "┃    /\n");
    }
}
