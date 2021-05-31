package Comparisons;

import Model.TestBase;
import org.apache.commons.text.similarity.IntersectionSimilarity;

public class IntersectionComparison extends BaseComparison{
    private final IntersectionSimilarity intersectionSimilarity;

    public IntersectionComparison() {
        super();
        this.intersectionSimilarity = new IntersectionSimilarity(charSequence -> {
            return charSequence;
        });
    }

    private int getResult(StringBuffer str1, StringBuffer str2){
        return  intersectionSimilarity.apply(str1,str2).getIntersection();
    }

    @Override
    protected int normalizeValue(Long value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {

    }
}
