package oodp;

import java.awt.EventQueue;

import database.databaseMGMT;
import gui.login;

public class Main {
    public static void main(String[] args) {
        databaseMGMT db = new databaseMGMT();
        db.setUrl("jdbc:mysql://localhost:3307/cms");
        db.setUsername("root");
        db.setPassword("");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
