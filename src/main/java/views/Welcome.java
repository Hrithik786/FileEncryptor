package views;

import DAO.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to File Hider");
        System.out.println("1. Login\n2. SignUp\n3. Exit");
        int choice = 0;
        try{
            choice = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        switch (choice){
            case 1-> login();
            case 2-> signUp();
            case 3-> System.exit(0);
        }
    }

    private void signUp(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("enter Email: ");
        String email = sc.nextLine();

        String genOTP = GenerateOTP.getOTP();
        SendOTPService.sendOTP(email,genOTP);

        System.out.println("Enter the OTP");
        String otp =sc.nextLine();

        if (otp.equals(genOTP)){
            User user = new User(name,email);
            try {
                UserDAO.saveUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else System.out.println("Wrong OTP");
    }
    private void login() {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        try{
            if (UserDAO.isExists(email)){
                String genOTP = GenerateOTP.getOTP();
                SendOTPService.sendOTP(email,genOTP);

                System.out.println("Enter the OTP");
                String otp = sc.nextLine();

                if (otp.equals(genOTP)){
                    System.out.println("Welcome22");
                }else {
                    System.out.println("Wrong OTP");
                }
            }else System.out.println("User Not Found!!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
