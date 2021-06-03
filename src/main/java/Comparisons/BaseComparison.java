package Comparisons;

import Model.Result;
import Model.TestBase;
import Util.PercertToScale;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComparison {
    protected List<Result> results;
    protected PercertToScale percertToScale;

    public BaseComparison(List<Result> results) {
        this.results = results;
        this.percertToScale = new PercertToScale();
    }

    public BaseComparison(){
        this.results = new ArrayList<>();
        this.percertToScale = new PercertToScale();
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void printResult(){
        System.out.println(getClass().getName());
        for(Result i : this.results){
            System.out.println(String.format("ID: %o , Value: %o",i.getId(),i.getValue()));
        }
    }

    protected void addResult(Result result){
        results.add(result);
    }

    protected abstract int normalizeValue(int value);

    protected abstract int normalizeValue(double value);

    protected abstract void calculate(TestBase testBase);

    public void calculate(List<TestBase> testBaseList){
        for(TestBase i : testBaseList){
            calculate(i);
        }
    }

}