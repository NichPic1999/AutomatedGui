package it.unimol.Aeroporti.Ui;


import it.unimol.Aeroporti.App.FileTicket.FileOutputTicket;
import it.unimol.Aeroporti.App.FlightManagment.FlightsManager;
import it.unimol.Aeroporti.App.TicketManagment.TicketList;
import it.unimol.Aeroporti.App.UsersManagment.UsersList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowTicket {
    private JTextField textFieldSurname;
    private JTextField textFieldPassportnumber;
    private JPanel PanelTicketDisplay;
    private JButton Exitbutton;
    private JTextArea textArea1;
    private JTextArea textArea3;
    private JTextArea textArea2;
    private JTextArea textArea4;
    private JButton Uploadmyflights;
    private JButton ButtonTextArea1;
    private JButton ButtonTextArea2;
    private JButton ButtonTextArea3;
    private JButton ButtonTextArea4;
    private JTextArea textArea5;
    public ChangeInterface changeInterface;

    private FileOutputTicket fileOutputTicket = new FileOutputTicket();
    private UsersList list_of_users = UsersList.getInstance();// singleton
    private FlightsManager flightsList = new FlightsManager();
    public TicketList ticketList = new TicketList();

    public ShowTicket(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;

        ticketList.associate_list_Ticket(fileOutputTicket.fileoutputticket(list_of_users.list_of_users, flightsList.list_of_flights, ticketList.list_of_ticket));

        Exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ButtonTextArea1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea1.getText();
                String[] parts = flight_to_split.split(";");
                String ticket_code = parts[0];
                PrintTicket(ticket_code, getTextArea5());
            }
        });
        ButtonTextArea2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea2.getText();
                String[] parts = flight_to_split.split(";");
                String ticket_code = parts[0];
                PrintTicket(ticket_code, getTextArea5());
            }
        });
        ButtonTextArea3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea2.getText();
                String[] parts = flight_to_split.split(";");
                String ticket_code = parts[0];
                PrintTicket(ticket_code, getTextArea5());
            }
        });
        ButtonTextArea4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea2.getText();
                String[] parts = flight_to_split.split(";");
                String ticket_code = parts[0];
                PrintTicket(ticket_code, getTextArea5());
            }
        });
        Uploadmyflights.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;

                for (int i = 0; i < ticketList.list_of_ticket.size(); i++) {
                    if (ticketList.list_of_ticket.get(i).getUser().getSurname().equals(getTextFieldSurname().getText()) &&
                            ticketList.list_of_ticket.get(i).getUser().getPassport_number().equals(getTextFieldPassportnumber().getText())) {
                        count++;
                        insertinTextArea(ticketList.list_of_ticket.get(i).getTicket_identification() + ";\n" +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture() + " ; \n " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getArrival() + " ; \n " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getCheck_in_date() + " ; \n " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_date() + "; \n € " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getTicket_price() + ",00\n", count);
                        System.out.println(ticketList.list_of_ticket.get(i).getUser().getSurname());
                    }
                }
                if (count == 0) {
                    try {// controllo di un null
                        JOptionPane.showMessageDialog(null, "Non hai voli prenotati");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }

        });
    }

    public void insertinTextArea(String informationFlight, int choise) {
        if (choise == 1) {
            textArea1.append(informationFlight);
        } else if (choise == 2) {
            textArea2.append(informationFlight);
        } else if (choise == 3) {
            textArea3.append(informationFlight);
        } else if (choise == 4) {
            textArea4.append(informationFlight);
        }
    }

    public JPanel getPanelTicketDisplay() {
        return PanelTicketDisplay;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldPassportnumber() {
        return textFieldPassportnumber;
    }

    public JTextArea getTextArea5() {
        return textArea5;
    }

    public void PrintTicket(String ticket_code, JTextArea x) {
        for (int i = 0; i <  ticketList.list_of_ticket.size(); i++) {
            if (ticketList.list_of_ticket.get(i).getTicket_identification().equalsIgnoreCase(ticket_code)) {
                x.setText( "Identificativo del biglietto " + ticketList.list_of_ticket.get(i).getTicket_identification()+"\n"+
                        "Nome dell'acquisitore: " + ticketList.list_of_ticket.get(i).getUser().getName() + "\n" +
                        "Cognome dell'acquisitore: " + ticketList.list_of_ticket.get(i).getUser().getSurname() + "\n" +
                        "Data di nascita: " + ticketList.list_of_ticket.get(i).getUser().getDate_of_birth()+ "\n" +
                        "Passaporto: " + ticketList.list_of_ticket.get(i).getUser().getPassport_number() + "\n" +
                        "Carta di credito:" + ticketList.list_of_ticket.get(i).getUser().getCredit_card_number() + "\n" +
                        "Codice volo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getFlight_id() + "\n" +
                        "Partenza:" + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture()  + "\n" +
                        "Arrivo:  " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival()  + "\n" +
                        "Data partenza: " + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_date()  + "\n" +
                        "Data di arrivo:" + ticketList.list_of_ticket.get(i).getFlight_booked().getCheck_in_date() + "\n" +
                        "Orario partenza: " + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_time() + "\n" +
                        "Orario di arrivo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival_time()+"\n" +
                        "Prezzo del biglietto: " + ticketList.list_of_ticket.get(i).getFlight_booked().getTicket_price() + "\n");

            }
        }
    }
}

