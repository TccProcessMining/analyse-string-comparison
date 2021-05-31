package Comparisons;

import Model.Result;
import Model.TestBase;

import java.util.List;

public abstract class BaseComparison {
    protected List<Result> results;

    public BaseComparison(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> result) {
        this.results = result;
    }

    protected void addResult(Result result){
        results.add(result);
    }

    protected abstract int normalizeValue(Long value);

    protected abstract void calculate(TestBase testBase);


}