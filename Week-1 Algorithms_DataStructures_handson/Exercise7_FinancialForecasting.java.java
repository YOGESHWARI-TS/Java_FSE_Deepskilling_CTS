public class FinancialForecasting {
    public static double FutureValue(double presentValue, double growthRate, int periods) {
          if (periods == 0) {
            return presentValue;
        } else {
            double finalValue = FutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
            return finalValue;
        }
    }
     public static void main(String[] args) {
        double presentValue = 1000.0; // Sample Initial investment
        double growthRate = 0.05; // Sample growth rate
        int periods = 10; // Sample Number of periods 
        double futureValue = FutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
public static double FutureValueIterative(double presentValue, double growthRate, int periods) {
    double futureValue = presentValue;
    for (int i = 0; i < periods; i++) {
        futureValue *= (1 + growthRate);
    }
    return futureValue;
}
}