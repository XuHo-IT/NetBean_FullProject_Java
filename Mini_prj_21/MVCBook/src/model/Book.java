package model;

public class Book implements Comparable<Book> {
    private String bookID;
    private String bookTitle;
    private String author;
    private int yearPublic;

    public Book(String bookID, String bookTitle, String author, int yearPublic) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.yearPublic = yearPublic;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublic() {
        return yearPublic;
    }

    public void setYearPublic(int yearPublic) {
        this.yearPublic = yearPublic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", yearPublic=" + yearPublic +
                '}';
    }
    public int compareTo(Book newbook){
        return Integer.toString(this.yearPublic).compareTo(Integer.toString(newbook.yearPublic));
    }
}
