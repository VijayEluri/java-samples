// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.xfire.service.impl;

import java.util.HashMap;
import java.util.Map;

import sample.xfire.dto.Book;
import sample.xfire.service.BookService;

public class BookServiceImpl implements BookService {

    private Book onlyBook;

    public BookServiceImpl() {
        onlyBook = new Book();
        onlyBook.setAuthor("Dan Diephouse");
        onlyBook.setTitle("Using XFire");
        onlyBook.setIsbn("0123456789");
    }

    public Book[] getBooks() {
        return new Book[] {onlyBook };
    }

    public Book findBook(String isbn) {
        if (isbn.equals(onlyBook.getIsbn()))
            return onlyBook;

        return null;
    }

    public Map getBooksMap() {
        Map result = new HashMap();
        result.put(onlyBook.getIsbn(), onlyBook);
        return result;
    }
}
