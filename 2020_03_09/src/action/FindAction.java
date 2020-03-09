package action;

import book.BookList;

public class FindAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("执行查找图书操作");
    }
}
