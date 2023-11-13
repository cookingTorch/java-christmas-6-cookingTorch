package christmas.util;

import java.util.List;

public class Calculator {
    public Integer calculateTotalBenefit(List<Integer> benefitAmounts) {
        Integer totalBenefit = 0;

        for (Integer amount : benefitAmounts) {
            totalBenefit += amount;
        }
        return totalBenefit;
    }
}
