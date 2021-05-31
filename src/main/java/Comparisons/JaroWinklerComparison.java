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
    protected int normalizeValue(Long value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {

    }
}
