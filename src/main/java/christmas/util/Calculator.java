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

    public Integer calculateAfterDiscount(Integer totalAmount, List<Integer> benefitAmounts) {
        Integer afterDiscount = totalAmount;

        for (int i = 0; i < benefitAmounts.size() - 1; i++) {
            afterDiscount -= benefitAmounts.get(i);
        }
        if (afterDiscount < 0) {
            return 0;
        }
        return afterDiscount;
    }
}
