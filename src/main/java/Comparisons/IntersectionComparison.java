package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.IntersectionResult;
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
        IntersectionResult tete = intersectionSimilarity.apply(str1,str2);
        return  tete.getIntersection();
    }

    @Override
    protected int normalizeValue(int value) {
        return value;
    }

    @Override
    protected int normalizeValue(double value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {
        StringBuffer str1 = new StringBuffer(testBase.getStr1());
        StringBuffer str2 = new StringBuffer(testBase.getStr2());
        int result = this.getResult(str1, str2);
        this.addResult(new Result(testBase.getId(), this.normalizeValue(result)));
    }
}
