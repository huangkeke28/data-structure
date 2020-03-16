package action;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书操作");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想查找的图书");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (name.equals(book.getName())){
                System.out.println(book);
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("查找失败");
        }
    }
}
