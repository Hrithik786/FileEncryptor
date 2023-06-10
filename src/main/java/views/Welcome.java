package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

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
            case 3->  System.exit(0);
        }
    }

    private void signUp() {

    }
    private void login() {

    }
}
