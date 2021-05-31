package Util;

import com.opencsv.CSVReader;
import java.io.Reader;

public class ReaderCSV {
    protected final Reader reader;
    protected final CSVReader csv_reader;

    public ReaderCSV(Reader reader) {
        this.reader = reader;
        this.csv_reader = new CSVReader(reader);
    }
}
