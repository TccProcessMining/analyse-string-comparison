package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.FuzzyScore;

import java.util.List;

public class FuzzyComparison extends BaseComparison{
    private final FuzzyScore fuzzyScore;
    public FuzzyComparison(List<Result> results, FuzzyScore fuzzyScore) {
        super(results);
        this.fuzzyScore = fuzzyScore;
    }

    private int getResult(StringBuffer str1, StringBuffer str2){
        return  fuzzyScore.fuzzyScore(str1,str2);
    }

    @Override
    protected int normalizeValue(Long value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {

    }
}
