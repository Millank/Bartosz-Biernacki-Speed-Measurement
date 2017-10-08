package com.kodilla;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by Bartosz Biernacki.
 */
public class SpeedMeasurement {

    public static void main(String[] args) {

        List<Book> myBook = new LinkedList<>();

        myBook.add(new Book("Inferno", " Dan Brown "));
        myBook.add(new Book("Mały książe", " Antoine de Saint-Exupéry "));
        myBook.add(new Book("Kuchnia Polska", " Andrzej Frukacz"));
        myBook.add(new Book("Człowiek wśród ludzi", " Bogdan Wojciszke"));
        myBook.add(new Book("Wywieranie wpływu na ludzi", " Robert B. Caldini"));
        myBook.add(new Book("Kamienie na szaniec", " Aleksander Kamiński " ));
        myBook.add(new Book("Wszyscy mamy tajemnice", " Harlan Coben "));
        myBook.add(new Book("Ono", "Dorota Terakowska "));
        myBook.add(new Book("Psychoza", " Robert Bloch "));
        myBook.add(new Book("Ptasiek", " William Wharton "));
        myBook.add(new Book("O obrotach ciał niebieskich", " Mikołaj Kopernik "));

        long begin = System.nanoTime();
        Book last = new Book("O obrotach ciał niebieskich", " Mikołaj Kopernik ");
        myBook.remove(last);
        long end = System.nanoTime();
        System.out.println("Usunięcie elementu na końcu kolekcji zajęło: " + (end - begin) + "ns");

        begin = System.nanoTime();
        Book first = new Book("Inferno", " Dan Brown ");
        myBook.remove(first);
        end = System.nanoTime();
        System.out.println("Usunięcie elementu na początku kolekcji zajęło: " + (end - begin) + "ns");

        Map<Integer, Integer> bookCollection = new HashMap<>();
        Random randomGenerator = new Random();
        int myColletion = 2234567;
        for (int i = 0; i < myColletion; i++) {
            bookCollection.put(i, randomGenerator.nextInt(77));
        }
        begin = System.nanoTime();
        bookCollection.get(13);
        end = System.nanoTime();
        System.out.println("Czas operacji wyszukiwania po kluczu wynosi: " + (end - begin) + "ns");

        begin = System.nanoTime();
        bookCollection.put(myColletion, 13);
        end = System.nanoTime();
        System.out.println("Dodawanie obiektu zajęło: " + (end - begin) + "ns");

        begin = System.nanoTime();
        bookCollection.remove(myColletion, 13);
        end = System.nanoTime();
        System.out.println("Usuwanie obiektu zajęło: " + (end - begin) + "ns");

    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.author);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final Book book = (Book) obj;
        return this.title.equals(book.getTitle()) &&
                this.author.equals(book.getAuthor());
    }
}


