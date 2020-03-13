package action;

import book.BookList;

public class DleAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍操作");
    }
}
