package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.FuzzyScore;

import java.util.List;
import java.util.Locale;

public class FuzzyComparison extends BaseComparison{
    private final FuzzyScore fuzzyScore;
    public FuzzyComparison() {
        super();
        this.fuzzyScore = new FuzzyScore(Locale.forLanguageTag("pt-BR"));
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
