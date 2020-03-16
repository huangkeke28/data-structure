package action;

import book.Book;
import book.BookList;

public class DisplayAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("展示图书操作");
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
