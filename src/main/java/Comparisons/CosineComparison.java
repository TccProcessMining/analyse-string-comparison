package Comparisons;

import Model.Result;
import Model.TestBase;
import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.HashMap;
import java.util.Map;

public class CosineComparison extends BaseComparison{
    private final CosineSimilarity cosineSimilarity ;
    public CosineComparison() {
        super();
        this.cosineSimilarity = new CosineSimilarity();
    }



    private Double getResult(StringBuffer str1, StringBuffer str2){
        Map<CharSequence, Integer> leftVector = new HashMap<>();
        Map<CharSequence, Integer> rightVector = new HashMap<>();
        leftVector.put(str1,str1.length());
        rightVector.put(str2, str2.length());
        return cosineSimilarity.cosineSimilarity(leftVector,rightVector);
    }

    private int normalizeValue(Double value){ //return 1..5
        return 1;
    }

    @Override
    public void calculate(TestBase testBase){
        StringBuffer str1 = new StringBuffer(testBase.getStr1());
        StringBuffer str2 = new StringBuffer(testBase.getStr2());
        Double result = this.getResult(str1, str2);
        this.addResult(new Result(testBase.getId(), this.normalizeValue(result)));
    }

    @Override
    protected int normalizeValue(Long value) {
        return 0;
    }


}
