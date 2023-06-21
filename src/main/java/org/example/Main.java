package org.example;

import db.MyConnection;
import views.Welcome;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Welcome c = new Welcome();
        c.welcomeScreen();
        //testing
    }
}