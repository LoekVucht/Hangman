package hangmanapplication.hangmandamageindicator;

public class FourthDamageLevel implements HangmanDamageIndicator {
    @Override
    public void showHangmanDamage() {
        System.out.println("┌─────┐\n" +
                          "┃     ┋\n" +
                          "┃     ┋\n" +
                          "┃     😮\n" +
                          "┃    /|\\\n" +
                          "┃\n");
    }
}
