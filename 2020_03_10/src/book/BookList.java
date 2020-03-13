package book;

public class BookList {
    private Book[] books = new Book[100];
    private int size;

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 100, "古典名著",
                false);
        books[1] = new Book("红楼梦", "曹雪芹", 200, "古典名著",
                false);
        books[2] = new Book("金瓶梅", "兰陵笑笑生", 180, "古典名著",
                false);
        size = 3;
    }

    public Book getBooks(int pos) {
        return books[pos];
    }

    public void setBooks(int pos,Book book) {
        books[pos] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
