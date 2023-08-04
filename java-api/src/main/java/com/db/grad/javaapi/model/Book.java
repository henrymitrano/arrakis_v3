package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
@Entity
@Table(name = "books")
public class Book {

    @Id
    private long bookNo;
    private ArrayList<Bond> bonds;private ArrayList<User> usersWithAccess;

    //public Book(int bookId, ArrayList<Bond> bonds, ArrayList<User> usersWithAccess) {
     //   this.bookNo = bookId;
       // this.bonds = new ArrayList<Bond>();
       // this.usersWithAccess = new ArrayList<User>();
   // }

    @Id
    @Column(name = "book_id", nullable = false)
    public long getBookNo() {
        return bookNo;
    }

    public void setBookNo(long bookNo) {
        this.bookNo = bookNo;
    }

    @Column(name = "bond", nullable = false)
    public ArrayList<Bond> getBonds() {
        return bonds;
    }

    public void setBonds(ArrayList<Bond> bonds) {
        this.bonds = bonds;
    }

    @Column(name = "usersWithAccess", nullable = false)
    public ArrayList<User> getUsersWithAccess() {
        return usersWithAccess;
    }

    public void setUsersWithAccess(ArrayList<User> usersWithAccess) {
        this.usersWithAccess = usersWithAccess;
    }
}