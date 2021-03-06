package com.codurance.solid;

import java.util.List;

import static com.codurance.solid.BookType.TRAVEL;

public class TravelBooks extends Books {
    private final List<Book> books;

    TravelBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Book book : books) {
            if (isTravel(book)) {
                price += book.price();
            }
        }
        return price;
    }

    @Override
    public double discount() {
        if (this.count() > 3) {
            return 0.6; // 40% discount when buying more than 3 travel books
        }
        return 0;
    }

    private double count() {
        double totalBooks = 0;
        for (Book book : books) {
            if (isTravel(book)){
                totalBooks++;
            }
        }
        return totalBooks;
    }

    private boolean isTravel(Book book) {
        return TRAVEL.equals(book.type());
    }
}
