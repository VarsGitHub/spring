package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl test = new UserServiceImpl();
        test.createUsersTable();
        test.saveUser("Alex", "Test", (byte) 1);
        System.out.println("User с именем – Alex добавлен в базу данных");
        test.saveUser("Steve", "Master", (byte) 2);
        System.out.println("User с именем – Steve добавлен в базу данных");
        test.saveUser("Big", "Floppa", (byte) 3);
        System.out.println("User с именем – Big добавлен в базу данных");
        test.saveUser("Doll", "Doll", (byte) 4);
        System.out.println("User с именем – Alex добавлен в базу данных");
        List<User> userList = test.getAllUsers();
        userList.forEach(System.out::println);
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}
