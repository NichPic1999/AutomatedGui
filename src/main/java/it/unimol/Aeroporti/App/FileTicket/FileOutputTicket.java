package it.unimol.Aeroporti.App.FileTicket;

import it.unimol.Aeroporti.App.FlightManagment.Flight;
import it.unimol.Aeroporti.App.TicketManagment.Ticket;
import it.unimol.Aeroporti.App.UsersManagment.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class FileOutputTicket {

    public FileOutputTicket() {
    }

    public ArrayList<Ticket> fileoutputticket(ArrayList<User> list_of_user, ArrayList<Flight> list_of_flights, ArrayList<Ticket> list_of_ticket) {

        String path="User tickets.txt";
        File fileTicket = new File(path);

        if (!fileTicket.exists() ) {
             try {
                 fileTicket.createNewFile();
             } catch (IOException e) {
                e.printStackTrace();
             }
        }
        try {

            try {
                File Readfile = new File(path);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(Readfile));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    Ticket ticket = new Ticket();
                    User user = new User();
                    String[] parts = line.split(" ");

                    String ticket_code = parts[0];
                    ticket.setTicket_identification(ticket_code);

                    user.setName(parts[1]);
                    user.setSurname(parts[2]);
                     user.setDate_of_birth(parts[3]);
                    user.setPassport_number(parts[4]);
                    user.setCredit_card_number(parts[5]);




                    list_of_user.add(user);
                    ticket.setUser(user);

                    String flight_id = parts[6];
                    for (int i = 0; i < list_of_flights.size(); i++) {
                        if (list_of_flights.get(i).getFlight_id().equalsIgnoreCase(flight_id)) {
                            ticket.setFlight_booked(list_of_flights.get(i));
                        }
                    }
                    list_of_ticket.add(ticket);
                }
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_of_ticket;
    }


}
