package it.unimol.Aeroporti.App.FlightManagment;

import java.util.ArrayList;


public class FlightsManager {
  public  ArrayList<Flight> list_of_flights = new ArrayList<Flight>();

    public FlightsManager() {
        full_list();
    }



    public void full_list() {
        Flight first_flight = new Flight();
        first_flight.setFlight_id("UM5790");
        first_flight.setDeparture("ATA");
        first_flight.setArrival("AAA");
        first_flight.setDeparture_date("23/10/1999");
        first_flight.setCheck_in_date("24/10/1999");
        first_flight.setDeparture_time("20:00");
        first_flight.setArrival_time("12:20");
        first_flight.setTicket_price(200);
        list_of_flights.add(first_flight);


        Flight second_flight =  new Flight();
        second_flight.setFlight_id("UM2468");
        second_flight.setDeparture("AAA");
        second_flight.setArrival("ICPO");
        second_flight.setDeparture_date("12/01/2004");
        second_flight.setCheck_in_date("12/01/2004");
        second_flight.setDeparture_time("10:00");
        second_flight.setArrival_time("02:20");
        second_flight.setTicket_price(234);
        list_of_flights.add(second_flight);


        Flight third_flight =  new Flight();
        third_flight.setFlight_id("UM0090");
        third_flight.setDeparture("MBX");
        third_flight.setArrival("ATA");
        third_flight.setDeparture_date("09/12/2018");
        third_flight.setCheck_in_date("09/12/2018");
        third_flight.setDeparture_time("06:00");
        third_flight.setArrival_time("17:20");
        third_flight.setTicket_price(567);
        list_of_flights.add(third_flight);


    Flight fourth_flight =  new Flight();
        fourth_flight.setFlight_id("UM1290");
        fourth_flight.setDeparture("MDR");
        fourth_flight.setArrival("FCO");
        fourth_flight.setDeparture_date("03/03/2019");
        fourth_flight.setCheck_in_date("03/03/2019");
        fourth_flight.setDeparture_time("03:00");
        fourth_flight.setArrival_time("06:20");
        fourth_flight.setTicket_price(123);
        list_of_flights.add(fourth_flight);


    Flight fifth_flight =  new Flight();
        fifth_flight.setFlight_id("UM5555");
        fifth_flight.setDeparture("AGN");
        fifth_flight.setArrival("ISN");
        fifth_flight.setDeparture_date("20/03/2021");
        fifth_flight.setCheck_in_date("22/03/2021");
        fifth_flight.setDeparture_time("14:00");
        fifth_flight.setArrival_time("19:20");
        fifth_flight.setTicket_price(20);
        list_of_flights.add(fifth_flight);


}
}
