import Model.TestBase;
import Reader.ReaderTestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    private static final String TEST_BASE = "src/main/resources/db/TestBase.csv";
    public static void main(String[] args) throws IOException {
        ReaderTestBase readerCSV = new ReaderTestBase(Files.newBufferedReader(Paths.get(TEST_BASE)));
        List<TestBase> testBaseList = readerCSV.read();
        for(TestBase i : testBaseList)
            System.out.println(i.getValue());
    }
}
