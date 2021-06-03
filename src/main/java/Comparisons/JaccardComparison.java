package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.JaccardSimilarity;

import java.util.List;

public class JaccardComparison extends BaseComparison{
    private final JaccardSimilarity jaccardSimilarity;
    public JaccardComparison() {
        super();
        this.jaccardSimilarity = new JaccardSimilarity();
    }

    private double getResult(StringBuffer str1, StringBuffer str2){
        return  jaccardSimilarity.apply(str1,str2);
    }
    

    @Override
    protected int normalizeValue(double value) {
        return this.percertToScale.convert(value);
    }
    
    @Override
    protected int normalizeValue(int value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {
        StringBuffer str1 = new StringBuffer(testBase.getStr1());
        StringBuffer str2 = new StringBuffer(testBase.getStr2());
        double result = this.getResult(str1, str2);
        this.addResult(new Result(testBase.getId(), this.normalizeValue(result)));
    }
}
