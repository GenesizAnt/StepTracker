import java.text.DecimalFormat;
import java.util.HashMap;

public class StepTracker {

    private int goalStep;
    private HashMap<String, MonthData> monthData = new HashMap<>();
    private String[] nameMonth = {"1", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthData.put(nameMonth[i], new MonthData());
        }
        this.goalStep = 10000;
    }

    public HashMap<String, MonthData> getMonthData() {
        return monthData;
    }

    public void setGoalStep(int goalStep) {
        if (goalStep <= 0) {
            System.out.println("Шеф, так мы точно не похудеем... Ставлю цель по умолчанию");
            goalStep = 10000;
        }
        this.goalStep = goalStep;
    }

    public void printAllStatMonth () {

    }

}

class MonthData {

    private int[] monthDay = new int[29];

    public void setStepDay(int day, int stepDay) {
        if (day <= 0 || day > 30) {
            throw new IllegalArgumentException("В месяце столько не бывает дней!");
        }
        if (stepDay < 0) {
            System.out.println("Шагал назад в будушие?");
            stepDay = 0;
        }
        monthDay[day - 1] = stepDay;
    }

    public void printStepMonth() {
        for (int i = 0; i < monthDay.length; i++) {
            System.out.println((i + 1) + " день: " + monthDay[i]);
        }
    }

    public int sumStepMonth() {
        int sumStepMonth = 0;
        for (int i = 0; i < monthDay.length; i++) {
            sumStepMonth += monthDay[i];
        }
        return sumStepMonth;
    }

    public int maxStepDay() {
        int sumStepMax = 0;
        for (int i = 0; i < monthDay.length; i++) {
            if (sumStepMax < monthDay[i]) {
                sumStepMax = monthDay[i];
            }
        }
        return sumStepMax;
    }

    public String averageStepDay() {
        double averageStepDay = 0;
        for (int i = 0; i < monthDay.length; i++) {
            averageStepDay += monthDay[i];
        }
        if (averageStepDay == 0) {
            return "0";
        } else {
            return new DecimalFormat("#0.00").format(averageStepDay / 30);
        }
    }

    public int bestDaySerial() {
        int bestDaySerial = 0;
        int bestTemp = 0;
        for (int i = 0; i < monthDay.length; i++) {
            if (monthDay[i] >= 10000) {
                bestTemp++;
                if (i == monthDay.length - 1 || monthDay[i + 1] < 10000) {
                    bestDaySerial = bestTemp;
                    bestTemp = 0;
                }
            }
        }
        return bestDaySerial;
    }
}
