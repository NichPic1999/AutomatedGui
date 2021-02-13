package it.unimol.Aeroporti.Ui;

import it.unimol.Aeroporti.App.FileTicket.FileOutputTicket;
import it.unimol.Aeroporti.App.FlightManagment.FlightsManager;
import it.unimol.Aeroporti.App.TicketManagment.TicketList;
import it.unimol.Aeroporti.App.UsersManagment.UsersList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class PressTicket {
    private JTextField textFieldSurname;
    private JTextField textFieldPassport;
    private JButton exitButton;
    private JButton Uploadmyflights;
    private JPanel PressPanel;
    private JButton buttontextarea1;
    private JButton buttontextarea2;
    private JButton buttontextarea3;
    private JTextArea textArea1;
    private JTextArea textArea3;
    private JTextArea textArea2;
    private JTextArea textArea4;
    private JButton buttontextarea4;
    private ChangeInterface changeInterface;

    public PressTicket(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;

        FileOutputTicket fileOutputTicket = new FileOutputTicket();
        UsersList list_of_users =  UsersList.getInstance();
        FlightsManager flightsList = new FlightsManager();

        ticketList.associate_list_Ticket(fileOutputTicket.fileoutputticket(list_of_users.list_of_users, flightsList.list_of_flights, ticketList.list_of_ticket));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Uploadmyflights.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;

                String passport_number = getTextFieldPassport().getText();
                String surname = getTextFieldSurname().getText();

                for (int i = 0; i < ticketList.list_of_ticket.size(); i++) {
                    if (ticketList.list_of_ticket.get(i).getUser().getSurname().equalsIgnoreCase(surname) &&
                            ticketList.list_of_ticket.get(i).getUser().getPassport_number().equalsIgnoreCase(passport_number)) {
                        count++;
                        setInfobox(ticketList.list_of_ticket.get(i).getTicket_identification() + ";\n" +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture() + " ;\n " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getArrival() + " ;\n" +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getCheck_in_date() + " ;\n" +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_date() + " ; \n€ " +
                                ticketList.list_of_ticket.get(i).getFlight_booked().getTicket_price() + ",00", count);
                    }
                }
                if (count == 0) {
                    try {
                        throw new Exception("Nessun volo trovato");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });

        buttontextarea1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea1.getText();
                String[] parts = flight_to_split.split(";");
                String Ticket_id = parts[0];
                try {
                    Press_tickets(Ticket_id);
                    changeInterface.status = 6;
                    changeInterface.choise();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        buttontextarea2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea2.getText();
                String[] parts = flight_to_split.split(";");
                String Ticket_id = parts[0];
                try {
                    Press_tickets(Ticket_id);
                    changeInterface.status = 6;
                    changeInterface.choise();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        buttontextarea3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea3.getText();
                String[] parts = flight_to_split.split(";");
                String Ticket_id = parts[0];
                try {
                    Press_tickets(Ticket_id);
                    changeInterface.status = 6;
                    changeInterface.choise();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        buttontextarea4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_to_split = textArea4.getText();
                String[] parts = flight_to_split.split(";");
                String Ticket_id = parts[0];
                try {
                    Press_tickets(Ticket_id);
                    changeInterface.status = 6;
                    changeInterface.choise();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
    }

    public void setInfobox(String infoflight, int choise) {
        if (choise == 1) {
            textArea1.append(infoflight);
        } else if (choise == 2) {
            textArea2.append(infoflight);
        } else if (choise == 3) {
            textArea3.append(infoflight);
        } else if (choise == 4)
            textArea4.append(infoflight);

    }

    public void Press_tickets(String Ticket_id){
        try {
            FileWriter ticket_write = new FileWriter("Stampa"+Ticket_id + ".txt");

            for (int i = 0; i < ticketList.list_of_ticket.size(); i++) {
                if (ticketList.list_of_ticket.get(i).getTicket_identification().equals(Ticket_id)) {
                    ticket_write.write("Identificativo del biglietto" + ticketList.list_of_ticket.get(i).getTicket_identification() + "\r\n" +
                            "Nome dell'acquisitore:" + ticketList.list_of_ticket.get(i).getUser().getName() + "\r\n" +
                            "Cognome dell'acquisitore:" + ticketList.list_of_ticket.get(i).getUser().getSurname() + "\r\n" +
                            "Data di nascita:" + ticketList.list_of_ticket.get(i).getUser().getDate_of_birth() + "\r\n" +
                            "Passaporto :" + ticketList.list_of_ticket.get(i).getUser().getPassport_number() + "\r\n" +
                            "Carta di credito :" + ticketList.list_of_ticket.get(i).getUser().getCredit_card_number() + "\r\n" +
                            "Codice volo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getFlight_id() + "\r\n" +
                            "Partenza: " + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture() + "\r\n" +
                            "Arrivo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival() + "\r\n" +
                            "Data di arrivo:" + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_date() + "\r\n" +
                            "Data partenza:" + ticketList.list_of_ticket.get(i).getFlight_booked().getCheck_in_date() + "\r\n" +
                            "Orario partenza:" + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_time() + "\r\n" +
                            "Orario di arrivo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival_time() + "\r\n" +
                            "Prezzo del biglietto: " + ticketList.list_of_ticket.get(i).getFlight_booked().getTicket_price() + "\r\n");
                }
            }
            ticket_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getPressPanel() {
        return PressPanel;
    }

    public TicketList ticketList = new TicketList();

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldPassport() {
        return textFieldPassport;
    }

}




