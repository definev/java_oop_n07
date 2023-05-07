package vn.viettuts.qlsv;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;


import vn.viettuts.qlsv.controller.LoginController;
import vn.viettuts.qlsv.view.LoginView;

public class App {
    public static void main(String[] args) {
        File file = new File("student.xml");

        // Check if file exists
        if (!file.exists()) {
            try {
                // Create an empty file
                file.createNewFile();
                System.out.println("File created successfully.");
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        } else {
            System.out.println("File already exists.");
        }
        EventQueue.invokeLater(() -> {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            // hiển thị màn hình login
            controller.showLoginView();
        });
    }
}