package action;

import book.BookList;

public class DisplayAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("展示书籍列表操作");
    }
}
