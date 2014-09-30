/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.domain;


/**
 *
 * @author funato
 * @createted 2005/08/08
 */
public class Report {
    private String id;
    private String name;
    private String description;
    private byte[] data;
    private char[] charData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //XXX Standard accessors and mutators
    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    public char[] getCharData() {
        return charData;
    }
    public void setCharData(char[] charData) {
        this.charData = charData;
    }
}
