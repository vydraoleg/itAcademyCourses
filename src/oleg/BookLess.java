package oleg;

public class BookLess {
    public static void main(String[] args) {
        Book book= new Book();
        Book.Page page = book.new Page();

//        String auth = ((Book)page).getAuthor();  !!!!!!!!!!!!!!!!!
        book.setAuthor("Nabokov");
        String auth =   page.getAuthor();

        page.setText("Something.");
        String text =   page.getText();

    }
}
