package action;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DeleteAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书操作");
        System.out.println("请输入你要删除的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        Book book = bookList.getBooks(i);
        for (; i < bookList.getSize(); i++) {
            if (book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("删除失败");
            return;
        }
        int size = bookList.getSize();
        bookList.setBooks(i, bookList.getBooks(size - 1));
        bookList.setSize(size - 1);
    }
}
