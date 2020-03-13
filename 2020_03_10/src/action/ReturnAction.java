package action;

import book.Book;
import book.BookList;


import java.util.Scanner;

public class ReturnAction implements IAction {
    public void work(BookList bookList) {
        System.out.println("归还图书操作");
        System.out.println("请输入你要归还的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                if (book.isBorrow()) {
                    book.setBorrow(false);
                    System.out.println("还书成功！");
                }
            }
        }
        System.out.println("还书失败");
    }
}
