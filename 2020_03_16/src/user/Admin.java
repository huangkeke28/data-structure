package user;

import action.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        actions = new IAction[]{
            new ExitAction(),
            new AddAction(),
            new DeleteAction(),
            new DisplayAction()
        };
    }

    @Override
    public int menu() {
        System.out.println(" 欢迎 " + this.name + " 使用图书管理系统 ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("1. 新增图书");
        System.out.println("2. 删除图书");
        System.out.println("3. 展示图书");
        System.out.println("0. 退出");
        System.out.println("=========================");
        System.out.println("请输入你想执行的操作");
        int choice = scanner.nextInt();
        return choice;
    }
}
