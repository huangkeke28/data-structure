package action;

import book.BookList;

public class AddAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行新增图书操作");
    }
}
