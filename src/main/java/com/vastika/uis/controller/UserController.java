package com.vastika.uis.controller;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class UserController {

    public static void main(String[] args) {
        String decision = "N";
        UserService userService = new UserServiceImpl();
        do {
            String operation = JOptionPane.showInputDialog("Enter operation (save/update/delete/get/list): ");
            switch (operation) {

                case "save":
                    User user = getUser("save");
                    int saved = userService.saveUser(user);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is saved in db.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in db.");
                    }
                    break;
                case "update":
                    User updatedUser = getUser("update");
                    int updated = userService.saveUser(updatedUser);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is updated in db.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in db.");
                    }
                    break;
                case "delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    int deleted = userService.deleteUser(id);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is deleted in db.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in db.");
                    }
                    break;
                case "get":
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    user = userService.getUserById(id);
                    printUserInfo(user);
                    break;
                case "list":
                    List<User> users = userService.getAllUser();
                    for (User u : users) {
                        printUserInfo(u);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong Selection!!!");
            }
            decision = JOptionPane.showInputDialog("Do you want to continue? (y/n): ");

        } while (decision.equalsIgnoreCase("y"));
        JOptionPane.showMessageDialog(null, "Bye Bye!!! See you next time.");
    }

    public static User getUser(String type) {
        User user = new User();
        if (type.equals("update")) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username: ");
        String password = JOptionPane.showInputDialog("Enter password: ");
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no.: "));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
        LocalDate dob = LocalDate.parse(JOptionPane.showInputDialog("Enter DOB: "));
        boolean active = Boolean.parseBoolean(JOptionPane.showInputDialog("Is user active? "));
        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(salary);
        user.setMobileNo(mobileNo);
        user.setDob(dob);
        user.setActive(active);
        return user;
    }

    public static void printUserInfo(User user) {
        System.out.println("*******************************");
        System.out.println("User Id is: " + user.getId());
        System.out.println("User name is: " + user.getUsername());
        System.out.println("Password is: " + user.getPassword());
        System.out.println("Mobile No. is: " + user.getMobileNo());
        System.out.println("Salary is: " + user.getSalary());
        System.out.println("DOB is: " + user.getDob());
        System.out.println("Is user active? " + user.isActive());
        System.out.println("*******************************");
    }
}

//C = Create => save
//R = Read => list
//U = Update => update
//D = Delete => delete

//M = Model
//V = View
//C = Controller
