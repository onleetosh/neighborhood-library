package com.pluralsight;

public class Book {

    //declare variables that will track data
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //constructor ('Book') designed to initialize objects when defining an element (ex. a book)
    public Book(int id, String isbn, String title) {
        //define variables
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        //initialize default
        this.isCheckedOut = false;  // book is not checkout out
        this.checkedOutTo = " "; //book is checked out to nobody
 }

    @Override
    //method designed to build and output a String
    public String toString() {
        return "Book{" +  "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkoutOutTo='" + checkedOutTo + '\'' +
                '}';
    }

    //getter methods
    public int getID() { return id; }
    public String getISBN() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() {return isCheckedOut;}
    public String getCheckedOutTo() { return checkedOutTo; }

    //setter methods
    public void setID(int id) { this.id = id; }
    public void setISBN(String isbn){ this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void setCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }
    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }

    //method designed as void(no return value) to handle check-out of book
    public void checkOut(String name) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkedOutTo = name;
            System.out.println(title + " has been checked out to " + name);
        } else {
            System.out.println("This book is already checked out by " + checkedOutTo);
        }
    }

    //method designed as void(no return value) to handle check-in process
    public void checkIn() {
        if (isCheckedOut) {
            this.isCheckedOut = false;
            this.checkedOutTo = " ";
            System.out.println(title + " has been checked in.");
        } else {
            System.out.println("The book is already available.");
        }
    }

    }






