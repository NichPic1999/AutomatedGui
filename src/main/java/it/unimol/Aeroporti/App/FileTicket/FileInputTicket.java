package it.unimol.Aeroporti.App.FileTicket;


import it.unimol.Aeroporti.App.TicketManagment.Ticket;


import java.io.*;
import java.util.ArrayList;

public class FileInputTicket {                             // prof. ho provato a fare la serializzazione dei Ticket
                                                           // ma nel momento della scrittura uscivano dei caratteri strani
    public FileInputTicket() {}                            // e per paura di mancanza di tempo e per verificare il corretto funzionamento successivo,
                                                           //ho dovuto utilizzare la forma più comune di file
    public void OutputFileTicket(ArrayList<Ticket> list_of_ticket) {
        try {
            FileWriter file = new FileWriter("User tickets.txt");
            for (Ticket ticket : list_of_ticket) {
                file.write(ticket.getTicket_identification() + " " +
                        ticket.getUser().getName() + " " +
                    ticket.getUser().getSurname() + " " +
                    ticket.getUser().getDate_of_birth() + " " +
                    ticket.getUser().getPassport_number() + " " +
                    ticket.getUser().getCredit_card_number() + " " +
                    ticket.getFlight_booked().getFlight_id() + " \r\n");
        }
            file.close();
        } catch (IOException e) {
           e.getMessage();
        }
    }
}


