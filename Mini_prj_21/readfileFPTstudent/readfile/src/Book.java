public class Book {
    private String isbn;
    private String book_tittle;
    private String book_author;
    private int year_of_publication;
    private String publisher;

    public Book(String isbn, String book_tittle, String book_author, int year_of_publication, String publisher) {
        this.isbn = isbn;
        this.book_tittle = book_tittle;
        this.book_author = book_author;
        this.year_of_publication = year_of_publication;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_tittle() {
        return book_tittle;
    }

    public void setBook_tittle(String book_tittle) {
        this.book_tittle = book_tittle;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", book_tittle='" + book_tittle + '\'' +
                ", book_author='" + book_author + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
