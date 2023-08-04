package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookHandler implements BookService {

    private BooksRepository itsBooksRepo;

    @Autowired
    public BookHandler( BooksRepository bookRepo )
    {
        itsBooksRepo = bookRepo;
    }

    @Override
    public List<Book> getAllBooks(){
        return itsBooksRepo.findAll();
    }

    @Override
    public Book addBook(Book theBook){
        return itsBooksRepo.save(theBook);
    }


    public long getNoOfBooks(){
        return itsBooksRepo.count();
    }

    public boolean removeBook(long uniqueId){
        boolean result = false;

        Optional<Book> theBook = itsBooksRepo.findById(uniqueId);
        if(theBook.isPresent())
        {
            itsBooksRepo.delete(theBook.get());
            result = true;
        }

        return  result;
    }

//    @Override
//    public Book getBookByBookNo(Book book){
//        Book bookToFind = new Book();
//        bookToFind.setBookNo(book.getBookNo());
//        List<Book> books = itsBooksRepo.findByBookNo(bookToFind);
//        Book result = null;
//
//        if( books.size() == 1)
//            result = books.get(0);
//
//        return result;
//    }
//    @Override
//    public Book getBookById(long uniqueId){
//        return itsBooksRepo.findById(uniqueId).get();
//    }
}