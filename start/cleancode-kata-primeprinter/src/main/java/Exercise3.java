import java.util.Map;
import java.util.function.Function;

public class Exercise3 {

    /**
     * @param amount Price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return Final price after discounts
     */
    public double calculate(double amount, int type, int years) {
        double loyaltyDiscount = calculateLoyaltyDiscount(years);

        // Map des réductions en fonction du type de client
        Map<Integer, Function<Double, Double>> discountStrategies = Map.of(
                1, base -> base,                                   // NotRegistered
                2, base -> applyDiscount(base, 0.1, loyaltyDiscount),  // SimpleCustomer
                3, base -> applyDiscount(base, 0.3, loyaltyDiscount),  // ValuableCustomer
                4, base -> applyDiscount(base, 0.5, loyaltyDiscount)   // MostValuableCustomer
        );

        // Sélectionner et appliquer la stratégie appropriée
        return discountStrategies.getOrDefault(type, base -> base).apply(amount);
    }

    private double calculateLoyaltyDiscount(int years) {
        return (years > 5) ? 0.05 : (double) years / 100;  // 5% max pour fidélité
    }

    private double applyDiscount(double base, double customerDiscount, double loyaltyDiscount) {
        double discountedAmount = base - (customerDiscount * base);
        return discountedAmount - (loyaltyDiscount * discountedAmount);
    }
}
