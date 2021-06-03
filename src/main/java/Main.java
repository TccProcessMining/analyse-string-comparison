import Comparisons.*;
import Model.Result;
import Model.TestBase;
import Reader.ReaderTestBase;
import Util.LineChartEx;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final String TEST_BASE = "src/main/resources/db/TestBase.csv";
    public static void main(String[] args) throws IOException {
        ReaderTestBase readerCSV = new ReaderTestBase(Files.newBufferedReader(Paths.get(TEST_BASE)));
        List<TestBase> testBaseList = readerCSV.read();
        LineChartEx chart = new LineChartEx();

        chart.addSerie("base", testBaseListToResultList(testBaseList));

        //cosine
        CosineComparison cosineComparison = new CosineComparison();
        cosineComparison.calculate(testBaseList);
        //cosineComparison.printResult();
        chart.addSerie("cosine", cosineComparison.getResults());

        //fuzzy
        FuzzyComparison fuzzyComparison = new FuzzyComparison();
        fuzzyComparison.calculate(testBaseList);
        //fuzzyComparison.printResult();
        chart.addSerie("fuzzy", fuzzyComparison.getResults());

        //intersection
        //IntersectionComparison intersectionComparison = new IntersectionComparison();
        //intersectionComparison.calculate(testBaseList);

        //jaccard
        JaccardComparison jaccardComparison = new JaccardComparison();
        jaccardComparison.calculate(testBaseList);
        //jaccardComparison.printResult();
        chart.addSerie("jaccard", jaccardComparison.getResults());

        //jaroWinkler
        JaroWinklerComparison jaroWinklerComparison = new JaroWinklerComparison();
        jaroWinklerComparison.calculate(testBaseList);
        //jaroWinklerComparison.printResult();
        chart.addSerie("jaroWinkler", jaroWinklerComparison.getResults());

        chart.setVisible(true);

    }

    private static List<Result> testBaseListToResultList(List<TestBase> testBaseList){
        List<Result> resultList = new ArrayList<>();
        for(TestBase i : testBaseList){
            Result result = new Result(i.getId(),i.getValue());
            resultList.add(result);
        }
        return resultList;
    }

}
