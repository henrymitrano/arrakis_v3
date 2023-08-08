package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.db.grad.javaapi.model.Book;

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
}