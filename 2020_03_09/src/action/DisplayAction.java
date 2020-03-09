package action;

import book.BookList;

public class DisplayAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行展示图书操作");
    }

}
