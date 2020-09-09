package oleg;

public class BookLess {
    public static void main(String[] args) {
        Book book= new Book();
//        Book.Page page = new Book.Page();
        Book.Page page = book.new Page();
//        String auth = ((Book)page).getAuthor();  !!!!!!!!!!!!!!!!!
    }
}
