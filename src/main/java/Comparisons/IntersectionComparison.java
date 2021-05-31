package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.IntersectionSimilarity;

import java.util.List;

public class IntersectionComparison extends BaseComparison{
    private final IntersectionSimilarity intersectionSimilarity;

    public IntersectionComparison(List<Result> results, IntersectionSimilarity intersectionSimilarity) {
        super(results);
        this.intersectionSimilarity = intersectionSimilarity;
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
