package action;

import book.BookList;

public class ReturnAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行还书操作");
    }
}
