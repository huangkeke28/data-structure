package action;

import book.Book;
import book.BookList;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class AddAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        System.out.println("请输入书籍分类：");
        String type = scanner.next();
        Book book = new Book(name, author, price, type,
                false);
        bookList.setBooks(bookList.getSize(),book);
        bookList.setSize(bookList.getSize() + 1);
        System.out.println("新增图书成功！");
    }
}
