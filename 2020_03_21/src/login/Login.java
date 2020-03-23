package login;

import java.util.Scanner;

public class Login {
    private static String name = "haha";
    private static String passWord = "12345";

    public static void login(String userNmae, String passWord) throws PasswordErrorException, NameErrorException{
        if (!Login.name.equals(userNmae)) {
            throw new NameErrorException("用户名错误");
        }
        if (!Login.passWord.equals(passWord)) {
            throw new PasswordErrorException("密码错误");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {
        try {
            login("haha", "123");
        } catch (PasswordErrorException | NameErrorException e) {
            e.printStackTrace();
        }
    }
}
