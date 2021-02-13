package it.unimol.Aeroporti.App.FileUsers;

import it.unimol.Aeroporti.App.UsersManagment.User;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileInputUsers {

    public FileInputUsers() {}

    public void FileUsers(ArrayList<User> list_of_users){
        String filepath = "Users List.txt";
        try {
            FileWriter file_user = new FileWriter(filepath);
            for (User user: list_of_users) {
                file_user.write(user.getName()+"-"
                        + user.getSurname() +"-"
                        + user.getDate_of_birth() +"-"
                        +user.getPassport_number() +"-"
                        + user.getCredit_card_number()+"-\r\n");
            }
            file_user.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
