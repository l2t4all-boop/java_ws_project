package com.l2t.lcj.lang;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, price);
    }

    public static void main(String[] args) {

        Book book1 = new Book("SBIN0001", "Learning Java", "Krish", 450);
        Book book2 = new Book("SBIN0001", "Learning Java", "Krish", 450);
        Book book3 = book1;
        int num1 = 10;
        int num2 = 10;

        int[] arr1 = {1, 3};
        int[] arr2 = {1, 3};

        System.out.println(book1 == book2);
        System.out.println(book1 == book3);
        System.out.println(num1 == num2);
        System.out.println(arr1 == arr2);
        System.out.println(book1.equals(book2));
        System.out.println(Arrays.equals(arr1, arr2));

    }
}
