package action;

import book.BookList;

public class AddAction implements IAction{
   @Override
    public void work(BookList bookList) {
       System.out.println("添加书籍操作");
   }
}
