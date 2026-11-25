public class EulerMethodSolver {

    public static double f(double x, double y) {
        return 2.0 * x * y;
    }

    public static double exactSolution(double x) {
        return Math.exp((x * x) - 1.0);
    }

    public static void runEulerSimulation(double x0, double y0, double xEnd, double h) {
        int steps = (int) Math.round((xEnd - x0) / h);
        double x = x0;
        double y = y0;

        System.out.printf("EULER'S METHOD SIMULATION (h = %.2f, Steps = %d)%n", h, steps);
        System.out.printf("%-8s | %-12s | %-12s | %-12s | %-14s | %-18s%n",
                "x_n", "y_n (4-dec)", "Actual (4-d)", "Abs. Error", "% Rel. Error", "Raw y_n (double)");

        for (int n = 0; n <= steps; n++) {
            double actual = exactSolution(x);
            double absError = Math.abs(actual - y);
            double relErrorPercent = (absError / Math.abs(actual)) * 100.0;

            System.out.printf("%-8.2f | %-12.4f | %-12.4f | %-12.4f | %-14.2f | %.10f%n",
                    x, y, actual, absError, relErrorPercent, y);

            y = y + h * f(x, y);
            x = x0 + (n + 1) * h;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final double X0 = 1.0;
        final double Y0 = 1.0;
        final double X_TARGET = 1.5;

        runEulerSimulation(X0, Y0, X_TARGET, 0.1);

        runEulerSimulation(X0, Y0, X_TARGET, 0.05);
    }
}