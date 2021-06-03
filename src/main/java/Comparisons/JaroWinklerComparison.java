package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;

import java.util.List;

public class JaroWinklerComparison extends BaseComparison{

    private final JaroWinklerSimilarity jaroWinklerSimilarity;

    public JaroWinklerComparison() {
        super();
        this.jaroWinklerSimilarity = new JaroWinklerSimilarity();
    }



    private Double getResult(StringBuffer str1, StringBuffer str2){
        return  jaroWinklerSimilarity.apply(str1,str2);
    }

    @Override
    protected int normalizeValue(int value) {
        return 0;
    }

    @Override
    protected int normalizeValue(double value) {
        return this.percertToScale.convertM(value);
    }

    @Override
    protected void calculate(TestBase testBase) {
        StringBuffer str1 = new StringBuffer(testBase.getStr1());
        StringBuffer str2 = new StringBuffer(testBase.getStr2());
        double result = this.getResult(str1, str2);
        this.addResult(new Result(testBase.getId(), this.normalizeValue(result)));
    }
}
