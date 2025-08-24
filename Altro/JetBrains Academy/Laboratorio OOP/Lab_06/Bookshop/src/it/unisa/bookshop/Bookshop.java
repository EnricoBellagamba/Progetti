package it.unisa.bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bookshop {

    final private List<Book> bookshop;

    public Bookshop() {
        bookshop = new ArrayList<>();
    }

    public List<Book> findByAuthor(String author) {
        /* TODO */
    }

    public List<Book> findByTitleContent(String titleContent) {
        /* TODO */
    }

    public List<Book> findMaxAvailable() {
        /* TODO */
    }

    public List<Book> findBelowAvailability(int threshold) {
        /* TODO */
    }

    public List<Book> getBookshop() {
        return bookshop;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        /* TODO */
    }
}
