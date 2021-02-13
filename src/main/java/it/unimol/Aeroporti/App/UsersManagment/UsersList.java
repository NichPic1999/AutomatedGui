package it.unimol.Aeroporti.App.UsersManagment;


import java.util.ArrayList;


public class UsersList {
    private static UsersList istance=null; // singleton

    private UsersList(){}// singleton

    public static UsersList getInstance(){// singleton
        if(istance==null)
            istance=new UsersList();
        return istance;
    }

   public  ArrayList<User> list_of_users = new ArrayList<>();

    public User passport_check(User user) throws Exception {

            for (User user2 : list_of_users) {
                if (user2.getPassport_number().equals(user.getPassport_number())) {
                    if (!user2.getName().equals(user.getName())) {
                        throw new Exception();
                    }
                }
            }
        return user;
    }
    public void add_users_list(User user) {
        list_of_users.add(user);
    }

    public ArrayList<User> return_list() {
        return list_of_users;
    }
}
