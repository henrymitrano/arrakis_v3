package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.db.grad.javaapi.model.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class BookHandlerTest {

    @Mock
    private BooksRepository itsBookRepo;

    @InjectMocks
    private BookHandler cut;

    @Test
    public void add_a_book_return_number_of_books_in_repo_is_one() {

        //arrange
        cut = new BookHandler(itsBookRepo);
        Book theBook = new Book();
        Mockito.when(itsBookRepo.save(theBook)).thenReturn(theBook);
        Mockito.when(itsBookRepo.count()).thenReturn(1L);
        theBook.setBookNo(123);

        cut.addBook(theBook);
        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfBooks();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_few_books_check_for_them_in_system() {
        //arrange
        cut = new BookHandler(itsBookRepo);
        Book book1 = new Book();
        Mockito.when(itsBookRepo.save(book1)).thenReturn(book1);
        book1.setBookNo(12);

        cut.addBook(book1);

        Book book2 = new Book();
        Mockito.when(itsBookRepo.save(book2)).thenReturn(book2);
        book2.setBookNo(13);

        cut.addBook(book2);

        Book book3 = new Book();
        Mockito.when(itsBookRepo.save(book3)).thenReturn(book3);
        book3.setBookNo(14);
        cut.addBook(book3);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Mockito.when(itsBookRepo.findAll()).thenReturn(books);



        //act
        List<Book> result = cut.getAllBooks();

        //assert
        assertEquals(books.size(), result.size());
    }




}