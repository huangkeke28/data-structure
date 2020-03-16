package action;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("借书操作");
        System.out.println("请输入你要借的书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("借书成功！");
                    break;
                }
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("借书失败！");
        }

    }
}
