// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.xfire.dto;

public class Book {
    private String title;

    private String isbn;

    private String author;

    /**
     * @return Returns the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return Returns the isbn.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn The isbn to set.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
