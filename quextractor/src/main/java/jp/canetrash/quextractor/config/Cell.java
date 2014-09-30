package jp.canetrash.quextractor.config;

public class Cell {
    private String name;
    private String col;
    private String row;

    public Cell() {

    }

    public Cell(String name, String col, String row) {
        this.name = name;
        this.col = col;
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

}