public class FinancialProjection {

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05;
        int years = 10;

        double projectedValue = calculateFutureValue(initialInvestment, annualGrowthRate, years);
        System.out.println("Projected Future Value: " + projectedValue);
    }
}
