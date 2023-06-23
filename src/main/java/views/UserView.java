package views;
import DAO.*;

import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private String email;
    public UserView(String email){
        this.email = email;
    }
    public void home() {
        do {
            System.out.println("Welcome "+ this.email);
            System.out.println("1. Show Hidden Files");
            System.out.println("2. Hide a New Files");
            System.out.println("3. Unhide a File");
            System.out.println("0 to Exit");
            Scanner sc = new Scanner(System.in);
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch){
                case 1-> {
                    try {
                        List<Data> files = DataDAO.getAllFiles(this.email);
                        System.out.println("ID - File Name");
                        for (Data file: files){
                            System.out.println(file.getId()+" - "+file.getFilename());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                case 2->{
                    System.out.println("Enter The File Path");
                    String path = sc.nextLine();
                    File f = new File(path);

                    Data file = new Data(0,f.getName(),path,this.email);
                    try {
                        DataDAO.hideFile(file);
                    } catch (SQLException | IOException e) {
                    e.printStackTrace();
                    }
                }
                case 3->{
                    List<Data> files = null;
                    try {
                        files = DataDAO.getAllFiles(this.email);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ID - File Name");
                    for (Data file: files){
                        System.out.println(file.getId()+" - "+file.getFilename());
                    }
                    System.out.println("Enter the id of file to Unhide");
                    int id = Integer.parseInt(sc.nextLine());

                    boolean isValidID = false;
                    for (Data file : files) {
                        if (file.getId() == id){
                            isValidID = true;
                        break;
                        }
                    }
                    if (isValidID){
                        try {
                            DataDAO.unHide(id);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Wrong ID");
                    }
                }
                case 0-> System.exit(0);
            }
        }while (true);
    }
}
