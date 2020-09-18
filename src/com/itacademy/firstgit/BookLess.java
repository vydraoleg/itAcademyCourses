package com.itacademy.firstgit;

import com.itacademy.firstgit.utils.impl.Book;

public class BookLess {
    public static void main(String[] args) {
        Book book= new Book();
        Book.Page page = book.new Page();
        String aut1 = book.getAuthor();

//        String auth = ((Book)page).getAuthor();  !!!!!!!!!!!!!!!!!
        book.setAuthor("Nabokov");
        String auth =   page.getAuthor();
        System.out.println(auth);

        page.setText("Something.");
        String text =   page.getText();
        System.out.println(text);

    }
}
