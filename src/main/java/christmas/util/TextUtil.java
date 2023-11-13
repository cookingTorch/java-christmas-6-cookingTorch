package christmas.util;

import christmas.constants.Constants;
import christmas.constants.Messages;
import christmas.enums.Benefit;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class TextUtil {
    private final NumberFormat formatter;

    public TextUtil() {
        this.formatter = NumberFormat.getNumberInstance();
    }

    public List<String> buildBenefitDetails(List<Integer> benefitAmounts) {
        List<String> benefitDetails = new ArrayList<>();
        Benefit[] benefits = Benefit.values();

        for (int i = 0; i < benefitAmounts.size(); i++) {
            addBenefitDetail(benefitDetails, benefitAmounts.get(i), benefits[i]);
        }
        if (benefitDetails.isEmpty()) {
            benefitDetails.add(Messages.NOTHING);
        }
        return benefitDetails;
    }

    private void addBenefitDetail(List<String> benefitDetails, Integer amount, Benefit benefit) {
        String line;

        if (amount != 0) {
            line = buildLine(amount, benefit);
            benefitDetails.add(line);
        }
    }

    private String buildLine(Integer amount, Benefit benefit) {
        String line;

        line = benefit.getName();
        line += Messages.COLON + Messages.SPACE;
        line += formatter.format(-amount) + Messages.WON;
        return line;
    }

    public String buildEventBadge(Integer totalBenefit) {
        if (totalBenefit >= Constants.SANTA_BADGE) {
            return Messages.SANTA;
        }
        if (totalBenefit >= Constants.TREE_BADGE) {
            return Messages.TREE;
        }
        if (totalBenefit >= Constants.STAR_BADGE) {
            return Messages.STAR;
        }
        return Messages.NOTHING;
    }
}
