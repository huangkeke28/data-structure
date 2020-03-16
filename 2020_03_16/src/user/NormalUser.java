package user;

import action.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        actions = new IAction[] {
                new ExitAction(),
                new BorrowAction(),
                new ReturnAction(),
                new FindAction(),
        };
    }

    @Override
    public int menu() {
        System.out.println(" 欢迎 " + this.name + " 使用图书管理系统 ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("1. 借书");
        System.out.println("2. 还书");
        System.out.println("3. 查找图书");
        System.out.println("0. 退出");
        System.out.println("=========================");
        System.out.println("请输入你想执行的操作");
        int choice = scanner.nextInt();
        return choice;
    }
}
