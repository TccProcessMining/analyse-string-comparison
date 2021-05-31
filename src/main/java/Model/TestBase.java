package Model;

import com.opencsv.bean.CsvBindByName;

public class TestBase {
    @CsvBindByName(column = "id")
    private Long id;
    @CsvBindByName(column = "str1")
    private String str1;
    @CsvBindByName(column = "str2")
    private String str2;
    @CsvBindByName(column = "value")
    private int value;

    public TestBase(){

    }

    public TestBase(Long id, String str1, String str2, int value) {
        this.id = id;
        this.str1 = str1;
        this.str2 = str2;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
