package Reader;

import Model.TestBase;
import Util.ReaderCSV;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ReaderTestBase extends ReaderCSV {
    public ReaderTestBase(Reader reader) {
        super(reader);
    }

    public List<TestBase> read() throws IOException {
        CsvToBean<TestBase> csvTestBase = new CsvToBeanBuilder(this.csv_reader)
                                                .withType(TestBase.class)
                                                .withIgnoreEmptyLine(true)
                                                .withIgnoreLeadingWhiteSpace(true)
                                                .build();
        return csvTestBase.parse();
    }
}
