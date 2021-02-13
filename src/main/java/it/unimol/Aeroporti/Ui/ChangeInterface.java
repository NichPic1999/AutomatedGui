package it.unimol.Aeroporti.Ui;

import javax.swing.*;


public class ChangeInterface {   // classe che mi gestisce la chiusura e apertura delle interfacce

    public JFrame window;
    public int status = 0;
    public Menu menu;
    public TicketBooking ticketBooked;
    public AffirmationInterface affirmationInterface;
    public InterfaceException interfaceException;
    public ShowTicket ticketDisplay;
    public PressTicket pressTicket;
    public PrintCheck printCheck;

    public ChangeInterface(JFrame frame) {
        this.window = frame;
        this.choise();
    }

    public void choise() {
        if (status == 0) {
            this.menu = new Menu(this);
            this.window.add(menu.getMenuPanel());
        } else if (status == 1) {
            this.window.remove(menu.getMenuPanel());
            this.ticketBooked = new TicketBooking(this);
            this.window.add(ticketBooked.getPanelTicket());
            this.window.revalidate();
        } else if (status == 2) {
            this.window.remove(menu.getMenuPanel());
            this.ticketDisplay = new ShowTicket(this);
            this.window.add(ticketDisplay.getPanelTicketDisplay());
            this.window.revalidate();
        }else if (status == 3) {
            this.window.remove(menu.getMenuPanel());
            this.pressTicket = new PressTicket(this);
            this.window.add(pressTicket.getPressPanel());
            this.window.revalidate();
        }else if(status==4){
            this.window.remove(ticketBooked.getPanelTicket());
            this.affirmationInterface = new AffirmationInterface(this);
            this.window.add(affirmationInterface.getPanel1());
            this.window.revalidate();
        }else if(status==5) {
            this.window.remove(ticketBooked.getPanelTicket());
            this.interfaceException = new InterfaceException(this);
            this.window.add(interfaceException.getPanelInterfaceException());
            this.window.revalidate();
        }else if(status==6) {
            this.window.remove(pressTicket.getPressPanel());
            this.printCheck= new PrintCheck(this);
            this.window.add(printCheck.getPrintCheckPanel());
            this.window.revalidate();
        }
    }
   }



