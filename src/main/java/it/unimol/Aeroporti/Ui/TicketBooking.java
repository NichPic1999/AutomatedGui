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
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

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
    // per i biglietti
    private FileOutputTicket fileOutputTicket = new FileOutputTicket();
    private FileInputTicket fileInputTicket = new FileInputTicket();
    //per gli utenti
    private FileInputUsers fileInputUsers = new FileInputUsers();


    private static UsersList list_of_users = UsersList.getInstance();
    private FlightsManager flightsList = new FlightsManager();
    private TicketList ticketList = new TicketList();
    RandomNumber random = new RandomNumber();

    public TicketBooking(ChangeInterface changeInterface) {
        Ticket ticket = new Ticket();


        ticketList.associate_list_Ticket(fileOutputTicket.fileoutputticket(list_of_users.list_of_users, flightsList.list_of_flights, ticketList.list_of_ticket));
        //tramite ticket list ricarico anche gli utenti

        ATAAAACheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(0)));
        AAAICPOCheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(1)));
        MBXATACheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(2)));
        MDRFCOCheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(3)));
        AGNISNCheckBox.addActionListener(e -> ticket.setFlight_booked(flightsList.list_of_flights.get(4)));
        confirmButton.addActionListener(e -> {

            User user = insertUserData();
            try {
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

    private void PassportCheck(User user) throws Exception {
        list_of_users.add_users_list(list_of_users.passport_check(user));
    }

    private void EqualsFlight(User user, Flight flight) throws Exception {
        ticketList.equals_flight(flight.getFlight_id(), user.getPassport_number());
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        PanelTicket = new JPanel();
        PanelTicket.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 6, new Insets(0, 0, 0, 0), -1, -1));
        PanelTicket.setBackground(new Color(-12522006));
        textFieldName = new JTextField();
        PanelTicket.add(textFieldName, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$("Agency FB", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-913635));
        label1.setText("Nome");
        PanelTicket.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldDateOfBirth = new JTextField();
        PanelTicket.add(textFieldDateOfBirth, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Agency FB", -1, 18, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-913635));
        label2.setText("Data di nascita");
        PanelTicket.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldPassportNumber = new JTextField();
        PanelTicket.add(textFieldPassportNumber, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        CreditCardNumber = new JTextField();
        PanelTicket.add(CreditCardNumber, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 3, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Agency FB", -1, 18, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-913635));
        label3.setText("Numero passaporto");
        PanelTicket.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Agency FB", -1, 16, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-913635));
        label4.setText("insersci il volo desiderato");
        PanelTicket.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ATAAAACheckBox = new JCheckBox();
        ATAAAACheckBox.setText("ATA AAA ");
        PanelTicket.add(ATAAAACheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AGNISNCheckBox = new JCheckBox();
        AGNISNCheckBox.setText("AGN ISN");
        PanelTicket.add(AGNISNCheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AAAICPOCheckBox = new JCheckBox();
        AAAICPOCheckBox.setText("AAA ICPO");
        PanelTicket.add(AAAICPOCheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        MBXATACheckBox = new JCheckBox();
        MBXATACheckBox.setText("MBX ATA");
        PanelTicket.add(MBXATACheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        MDRFCOCheckBox = new JCheckBox();
        MDRFCOCheckBox.setText("MDR FCO");
        PanelTicket.add(MDRFCOCheckBox, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Agency FB", -1, 24, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-913635));
        label5.setText("Cognome");
        PanelTicket.add(label5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldSurname = new JTextField();
        PanelTicket.add(textFieldSurname, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        confirmButton = new JButton();
        confirmButton.setBackground(new Color(-12666100));
        confirmButton.setText("Confirm");
        PanelTicket.add(confirmButton, new com.intellij.uiDesigner.core.GridConstraints(7, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Agency FB", -1, 18, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-913635));
        label6.setText("Numero carta di credito");
        PanelTicket.add(label6, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return PanelTicket;
    }
}
