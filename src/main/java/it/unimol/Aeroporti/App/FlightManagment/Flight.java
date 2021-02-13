package it.unimol.Aeroporti.App.FlightManagment;

public class Flight {

    String flight_id;
    String departure;
    String arrival;
    String check_in_date;
    String departure_date;
    String arrival_time;
    String departure_time;
    int ticket_price;

    public  Flight() {}


    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }



    public void setDeparture(String departure) {
        this.departure = departure;
    }


    public void setArrival(String arrival) {
        this.arrival = arrival;
    }


    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }


    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }


    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }


    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }
}
