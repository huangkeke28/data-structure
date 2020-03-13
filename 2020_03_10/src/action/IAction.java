package action;

import book.BookList;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface IAction {
    void work(BookList bookList);
}
