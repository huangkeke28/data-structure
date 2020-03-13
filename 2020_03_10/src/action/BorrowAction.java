package action;

import book.BookList;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("借书操作");
    }
}
