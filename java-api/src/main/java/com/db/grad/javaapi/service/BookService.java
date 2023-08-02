package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    public List<Book> getAllBooks();

    public Book addBook(Book theBook);

    public long getNoOfBooks();

    public boolean removeBook(int bookId);

    public Book getBookById(int bookId);

}