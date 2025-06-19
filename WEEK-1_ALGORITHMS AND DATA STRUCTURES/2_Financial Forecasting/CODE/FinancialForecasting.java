public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        double growthFactor = 1 + growthRate;
        return currentValue * Math.pow(growthFactor, years);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.07;
        int projectionYears = 10;

        double recursiveResult = calculateFutureValue(initialInvestment, annualGrowthRate, projectionYears);
        double optimizedResult = calculateFutureValueOptimized(initialInvestment, annualGrowthRate, projectionYears);

        System.out.println("=== Financial Forecasting Results ===");
        System.out.printf("Initial Investment: $%,.2f\n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.2f%%\n", annualGrowthRate * 100);
        System.out.println("Projection Years: " + projectionYears);
        System.out.printf("\nRecursive Method Result: $%,.2f\n", recursiveResult);
        System.out.printf("Optimized Method Result: $%,.2f\n", optimizedResult);

        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Recursive Method Complexity: O(n) linear time");
        System.out.println("Optimized Method Complexity: O(1) constant time");

        System.out.println("\n=== Recursion Concept ===");
        System.out.println("Recursion simplifies problems by:");
        System.out.println("- Breaking complex problems into smaller identical subproblems");
        System.out.println("- Using a base case to terminate the recursion");
        System.out.println("- Building solutions from the bottom up");
        System.out.println("Example growth calculation steps:");
        System.out.printf("Year 0: $%,.2f\n", initialInvestment);
        for (int i = 1; i <= projectionYears; i++) {
            System.out.printf("Year %d: $%,.2f\n", i, initialInvestment * Math.pow(1 + annualGrowthRate, i));
        }

        System.out.println("\n=== Optimization Strategies ===");
        System.out.println("1. Memoization: Store intermediate results to avoid redundant calculations");
        System.out.println("2. Iterative Conversion: Replace recursion with loops to prevent stack overflow");
        System.out.println("3. Mathematical Optimization: Use direct formulas (exponentiation) where possible");
        System.out.println("4. Tail Recursion: Structure recursion to allow compiler optimizations");

        System.out.println("\n=== Implementation Recommendations ===");
        System.out.println("- For small datasets (<1000 periods): Basic recursion is acceptable");
        System.out.println("- For large datasets: Always use mathematical optimization");
        System.out.println("- Add input validation: Ensure growth rates are between -1 and 1");
        System.out.println("- Include error handling for negative years");
    }
}
