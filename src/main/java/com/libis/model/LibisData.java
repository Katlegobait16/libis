package com.libis.model;

import java.util.ArrayList;
import java.util.List;

public class LibisData {

    private static List<Member> members = new ArrayList<Member>();
    private static List<Book> books = new ArrayList<Book>();

    static {
        members.add(new Member(1, "Katlego", "Baitirile", "katlego@bac.ac.bw", "password1"));
        members.add(new Member(2, "Olerato", "Leburu", "olerato@bac.ac.bw", "password2"));
        members.add(new Member(3, "Boitumelo", "Kgosi", "boitumelo@bac.ac.bw", "password3"));
        members.add(new Member(4, "Thabo", "Modise", "thabo@bac.ac.bw", "password4"));
        members.add(new Member(5, "Lorato", "Sebina", "lorato@bac.ac.bw", "password5"));

        books.add(new Book(1, "Effective Java", "Joshua Bloch", "Programming",
                "A guide to best practices in the Java platform.", true));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", "Programming",
                "A handbook of agile software craftsmanship.", true));
        books.add(new Book(3, "The Pragmatic Programmer", "David Thomas", "Programming",
                "Classic advice on becoming a better developer.", false));
        books.add(new Book(4, "Design Patterns", "Erich Gamma", "Programming",
                "Elements of reusable object-oriented software.", true));
        books.add(new Book(5, "Introduction to Algorithms", "Thomas Cormen", "Computer Science",
                "A comprehensive text on algorithms and data structures.", true));
        books.add(new Book(6, "The Pillars of the Earth", "Ken Follett", "Historical Fiction",
                "The building of a cathedral in 12th-century England.", false));
        books.add(new Book(7, "Sapiens", "Yuval Noah Harari", "History",
                "A brief history of humankind.", true));
        books.add(new Book(8, "Atomic Habits", "James Clear", "Self-Help",
                "An easy way to build good habits and break bad ones.", true));
        books.add(new Book(9, "1984", "George Orwell", "Dystopian Fiction",
                "A dystopian vision of a totalitarian future state.", false));
        books.add(new Book(10, "The Hobbit", "J.R.R. Tolkien", "Fantasy",
                "A hobbit's unexpected journey with dwarves and a wizard.", true));
    }

    public static List<Member> getMembers() {
        return members;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void addMember(Member member) {
        members.add(member);
    }

    public static Book findBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                return books.get(i);
            }
        }
        return null;
    }

    public static void deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                break;
            }
        }
    }
}