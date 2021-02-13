package it.unimol.Aeroporti.Ui;

import it.unimol.Aeroporti.App.FileTicket.FileInputTicket;
import it.unimol.Aeroporti.App.FileTicket.FileOutputTicket;
import it.unimol.Aeroporti.App.FileUsers.FileInputUsers;
import it.unimol.Aeroporti.App.FlightManagment.Flight;
import it.unimol.Aeroporti.App.FlightManagment.FlightsManager;
import it.unimol.Aeroporti.App.RandomNumber;
import it.unimol.Aeroporti.App.TicketManagment.Ticket;
import it.unimol.Aeroporti.App.TicketManagment.TicketList;
import it.unimol.Aeroporti.App.UsersManagment.User;
import it.unimol.Aeroporti.App.UsersManagment.UsersList;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicketBooking {

    private JPanel PanelTicket;
    private JCheckBox ATAAAACheckBox;
    private JCheckBox AGNISNCheckBox;
    private JCheckBox AAAICPOCheckBox;
    private JCheckBox MBXATACheckBox;
    private JCheckBox MDRFCOCheckBox;
    private JTextField textFieldName;
    private JTextField textFieldDateOfBirth;
    private JTextField textFieldPassportNumber;
    private JTextField CreditCardNumber;
    private JTextField textFieldSurname;
    private JButton confirmButton;
    private ChangeInterface changeInterface;
    // per i biglietti
    private FileOutputTicket fileOutputTicket = new FileOutputTicket();
    private FileInputTicket fileInputTicket = new FileInputTicket();
    //per gli utenti
    private FileInputUsers fileInputUsers = new FileInputUsers();


    private static UsersList list_of_users = UsersList.getInstance();
    private FlightsManager flightsList = new FlightsManager();
    private TicketList ticketList = new TicketList();
    RandomNumber random = new RandomNumber();

    public TicketBooking(ChangeInterface changeInterface)  {
        Ticket ticket =new Ticket();


        ticketList.associate_list_Ticket(fileOutputTicket.fileoutputticket(list_of_users.list_of_users,flightsList.list_of_flights,ticketList.list_of_ticket));
        //tramite ticket list ricarico anche gli utenti

        this.changeInterface = changeInterface;
        ATAAAACheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(0)));
        AAAICPOCheckBox.addActionListener(e ->ticket.setFlight_booked(flightsList.list_of_flights.get(1)));
        MBXATACheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(2)));
        MDRFCOCheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(3)));
        AGNISNCheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(4)));
        confirmButton.addActionListener(e -> {

            User user = insertUserData();
            try{
               PassportCheck(user); // nel metodo passport check eseguo anche l'inserimento dell'utente
               ticket.setUser(user);

               EqualsFlight(ticket.getUser(), ticket.getFlight_booked());

               ticket.setTicket_identification(random.random_number());

               ticketList.add_ticket(ticket);

               fileInputUsers.FileUsers(list_of_users.return_list());
               fileInputTicket.OutputFileTicket(ticketList.list_of_ticket);

               changeInterface.status = 4;
               changeInterface.choise();

           } catch (Exception e1) {         // utilizzo una sola eccezione e gestisco sia il caso del passaporto non corrispondente
              changeInterface.status = 5;   // sia per quanto riguarda l'acquisto dello stesso biglietto
              changeInterface.choise();
           }
        });


    }

    private void PassportCheck(User user) throws Exception{
        list_of_users.add_users_list(list_of_users.passport_check(user));
    }

    private void EqualsFlight(User user , Flight flight)throws Exception{
        ticketList.equals_flight(flight.getFlight_id(),user.getPassport_number());
    }

    private User insertUserData() {
        User user = new User();
        user.setName(getTextFieldName().getText());
        user.setSurname(getTextFieldSurname().getText());
        user.setDate_of_birth(getTextFieldDateOfBirth().getText());
        user.setPassport_number(getTextFieldPassportNumber().getText());
        user.setCredit_card_number(getCreditCardNumber().getText());
        return user;
    }

    public JPanel getPanelTicket() {
        return PanelTicket;
    }


    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldDateOfBirth() {
        return textFieldDateOfBirth;
    }

    public JTextField getTextFieldPassportNumber() {
        return textFieldPassportNumber;
    }

    public JTextField getCreditCardNumber() {
        return CreditCardNumber;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }
}
