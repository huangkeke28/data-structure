package action;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("还书操作");
        System.out.println("请输入你要归还的书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (name.equals(book.getName())) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("还书成功");
                    break;
                }
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("还书失败！");
        }
    }
}
