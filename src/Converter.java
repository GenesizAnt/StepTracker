import java.text.DecimalFormat;

public class Converter {


    private final double stepLength = 0.75;
    private final double stepBernCalories = 0.5;

    public void printDistance (int step) {
        System.out.println(new DecimalFormat("Пройденное расстояние в киллометрах составило - " + "#0.00").format((step * stepLength) / 1000));

    }

    public void printBernKilocalories (int step) {
        System.out.println(new DecimalFormat("Сожженное кол-во килокалорий составило - " + "#0.00").format((step * stepBernCalories) / 10));

    }

    public double getStepLength() {
        return stepLength;
    }

    public double getStepBernCalories() {
        return stepBernCalories;
    }
}
