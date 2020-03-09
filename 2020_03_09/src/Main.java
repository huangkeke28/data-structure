import book.BookList;
import user.NormalUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.先把数据准备好
        BookList bookList = new BookList();
        //创建用户并进行登录
        NormalUser user = login();
        //进入主循环
        while (true) {
            int choice = user.menu();
            user.doAction(choice, bookList);
        }
    }

    public static NormalUser login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录系统");
        System.out.println("请输入你的名字");
        String name = scanner.next();
      //  System.out.println("请输入你的身份：1表示管理员 2表示普通用户");
        //int who = scanner.nextInt();
        return new NormalUser(name);
    }
}
