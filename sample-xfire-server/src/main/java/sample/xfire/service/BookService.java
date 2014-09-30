// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.xfire.service;

import java.util.Map;

import sample.xfire.dto.Book;

public interface BookService {
    public Book[] getBooks();

    public Book findBook(String isbn);

    public Map getBooksMap();
}
