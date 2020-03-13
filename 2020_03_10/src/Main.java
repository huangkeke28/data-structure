import book.BookList;
import user.NormalUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //先把数据准备好
        BookList bookList = new BookList();
        //创建用户并登录
        NormalUser user = login();
        //进入主循环
        while (true) {
            int choice = user.menu();
            user.doAction(choice, bookList);
        }
    }

    public static NormalUser login() {
        //提示用户进行登录
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录系统！！！！");
        System.out.println("请输入你的名字");
        String name = scanner.next();
        return new NormalUser(name);
    }
}
