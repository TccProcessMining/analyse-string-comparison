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

    private Double getResult(StringBuffer str1, StringBuffer str2){
        return  jaccardSimilarity.apply(str1,str2);
    }

    @Override
    protected int normalizeValue(Long value) {
        return 0;
    }

    @Override
    protected void calculate(TestBase testBase) {

    }
}
