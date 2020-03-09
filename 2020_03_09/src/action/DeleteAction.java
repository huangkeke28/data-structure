package action;

import book.BookList;

public class DeleteAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("执行删除图书操作");
    }

}
