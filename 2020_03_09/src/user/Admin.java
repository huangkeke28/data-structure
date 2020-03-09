package user;

import action.*;

public class Admin {
    private String name;
    private IAction[] actions = new IAction[] {
            new ExitAction(),
            new FindAction(),
            new BorrowAction(),
            new ReturnAction()
    };
}
