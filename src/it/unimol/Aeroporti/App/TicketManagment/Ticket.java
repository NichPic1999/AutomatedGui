package it.unimol.Aeroporti.App.TicketManagment;

import it.unimol.Aeroporti.App.FlightManagment.Flight;
import it.unimol.Aeroporti.App.UsersManagment.User;


public class Ticket{

    User user;
    Flight flight_booked;
    String ticket_identification;

    public Ticket() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight_booked() {
        return flight_booked;
    }

    public void setFlight_booked(Flight flight_booked) {
        this.flight_booked = flight_booked;
    }

    public String getTicket_identification() {
        return ticket_identification;
    }

    public void setTicket_identification(String ticket_identification) {
        this.ticket_identification = ticket_identification;
    }


}
