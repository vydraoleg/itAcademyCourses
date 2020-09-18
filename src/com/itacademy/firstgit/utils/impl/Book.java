package com.itacademy.firstgit.utils.impl;

public class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * methods для возврата имени автора по книге
     * @return author
     * @param Null
     * @see #setAuthor(String)
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method set the name to the object
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public class Page{
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        private String text;

        public String getAuthor() {
            return Book.this.author;
        }
    }
}
