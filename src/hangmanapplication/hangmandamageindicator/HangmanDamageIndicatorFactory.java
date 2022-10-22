package hangmanapplication.hangmandamageindicator;

public class HangmanDamageIndicatorFactory {
    private static HangmanDamageIndicatorFactory instance;

    public static HangmanDamageIndicatorFactory getInstance() {
        if (instance == null) {
            instance = new HangmanDamageIndicatorFactory();
        }
        return instance;
    }

    public HangmanDamageIndicator getHangmanDamageIndicator(int damageLevelIndex) {
        switch (damageLevelIndex) {
            case 0 -> { return new NoDamage(); }
            case 1 -> { return new FirstDamageLevel(); }
            case 2 -> { return new SecondDamageLevel(); }
            case 3 -> { return new ThirdDamageLevel(); }
            case 4 -> { return new FourthDamageLevel(); }
            case 5 -> { return new FifthDamageLevel(); }
            case 6 -> { return new SixthDamageLevel(); }
            case 7 -> { return new SeventhDamageLevel(); }
        }
        return null;
    }
}
