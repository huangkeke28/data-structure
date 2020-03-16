package user;

import action.IAction;
import book.BookList;

abstract public class User {
    //用户这个类能干什么 选择 菜单 做操作
    protected String name;
    protected IAction[] actions;

    public User(String name) {
        this.name = name;
    }
    abstract public int menu();

    public void doAction(int choice, BookList bookList) {
        actions[choice].work(bookList);
    }

}
