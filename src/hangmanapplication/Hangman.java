package hangmanapplication;

import hangmanapplication.hangmandamageindicator.HangmanDamageIndicator;
import hangmanapplication.hangmandamageindicator.HangmanDamageIndicatorFactory;
import hangmanapplication.hangmandamageindicator.NoDamage;

public class Hangman {
    private HangmanDamageIndicator hangmanDamageIndicator;

    public Hangman() {
        hangmanDamageIndicator = new NoDamage();
    }
    public void showHangman(int damageLevelIndex) {
        hangmanDamageIndicator = HangmanDamageIndicatorFactory.getInstance().getHangmanDamageIndicator(damageLevelIndex);
        hangmanDamageIndicator.showHangmanDamage();
    }
}
