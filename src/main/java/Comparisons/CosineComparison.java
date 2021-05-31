package Comparisons;

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

    @Override
    public void calculate(TestBase testBase){

    }

    @Override
    protected int normalizeValue(Long value){
        return Math.toIntExact(value);
    }
}
