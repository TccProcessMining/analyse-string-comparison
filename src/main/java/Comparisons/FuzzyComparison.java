package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.FuzzyScore;

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
    protected int normalizeValue(double value) {
        return 0;
    }

    @Override
    protected int  normalizeValue(int value){
        return value;
    }

    private int normalizeValue(int value, int length){
        return ((value/length)*5)/2;
    }

    @Override
    protected void calculate(TestBase testBase) {
        StringBuffer str1 = new StringBuffer(testBase.getStr1());
        StringBuffer str2 = new StringBuffer(testBase.getStr2());
        int result = this.getResult(str1, str2);
        int length = (str1.length()+ str2.length())/2;
        this.addResult(new Result(testBase.getId(), this.normalizeValue(result,length)));
    }
}
