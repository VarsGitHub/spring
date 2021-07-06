package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl test = new UserServiceImpl();
        test.createUsersTable();
        test.saveUser("Alex", "AlexSurname", (byte) 1);
        System.out.println("User с именем – Alex добавлен в базу данных");
        test.saveUser("Steve", "Master", (byte) 2);
        System.out.println("User с именем – Steve добавлен в базу данных");
        test.saveUser("Floppa", "Big", (byte) 3);
        System.out.println("User с именем – Floppa добавлен в базу данных");
        test.saveUser("Bird", "Animal", (byte) 4);
        System.out.println("User с именем – Bird добавлен в базу данных");
        List <User> testList = test.getAllUsers();
        testList.forEach(System.out::println);
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}
