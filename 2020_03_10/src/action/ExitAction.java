package action;

import book.BookList;

public class ExitAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("推出操作");
        System.exit(0);
    }
}
