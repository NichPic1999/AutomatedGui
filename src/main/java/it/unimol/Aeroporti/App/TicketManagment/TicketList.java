package it.unimol.Aeroporti.App.TicketManagment;

import java.util.ArrayList;

public class TicketList {

   public  ArrayList<Ticket> list_of_ticket = new ArrayList<>();

    public void equals_flight(String flight_id, String passport_number) throws Exception {
        for (Ticket ticket : list_of_ticket) {
            if (ticket.getFlight_booked().getFlight_id().equalsIgnoreCase(flight_id)) {
                if (ticket.getUser().getPassport_number().equalsIgnoreCase(passport_number)){
                        throw new Exception();
                    }

                }
            }
        }

   public void add_ticket(Ticket ticket){
        list_of_ticket.add(ticket);
   }

    public void associate_list_Ticket(ArrayList<Ticket> list) {
        list_of_ticket=list;
    }

}