import book.Book;
import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doAction(choice, bookList);

        }
    }
        public static User login () {
            System.out.println(" 欢迎登录系统 ");
            System.out.println("请输入你的姓名");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            System.out.println("请表明你的身份");
            System.out.println(" 1. 用户   2. 管理员 ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                return new NormalUser(name);
            } else {
                return new Admin(name);
            }
        }

}
