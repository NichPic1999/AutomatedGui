package it.unimol.Aeroporti.Ui;


import it.unimol.Aeroporti.App.FileTicket.FileOutputTicket;
import it.unimol.Aeroporti.App.FlightManagment.FlightsManager;
import it.unimol.Aeroporti.App.TicketManagment.TicketList;
import it.unimol.Aeroporti.App.UsersManagment.UsersList;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

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
        for (int i = 0; i < ticketList.list_of_ticket.size(); i++) {
            if (ticketList.list_of_ticket.get(i).getTicket_identification().equalsIgnoreCase(ticket_code)) {
                x.setText("Identificativo del biglietto " + ticketList.list_of_ticket.get(i).getTicket_identification() + "\n" +
                        "Nome dell'acquisitore: " + ticketList.list_of_ticket.get(i).getUser().getName() + "\n" +
                        "Cognome dell'acquisitore: " + ticketList.list_of_ticket.get(i).getUser().getSurname() + "\n" +
                        "Data di nascita: " + ticketList.list_of_ticket.get(i).getUser().getDate_of_birth() + "\n" +
                        "Passaporto: " + ticketList.list_of_ticket.get(i).getUser().getPassport_number() + "\n" +
                        "Carta di credito:" + ticketList.list_of_ticket.get(i).getUser().getCredit_card_number() + "\n" +
                        "Codice volo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getFlight_id() + "\n" +
                        "Partenza:" + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture() + "\n" +
                        "Arrivo:  " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival() + "\n" +
                        "Data partenza: " + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_date() + "\n" +
                        "Data di arrivo:" + ticketList.list_of_ticket.get(i).getFlight_booked().getCheck_in_date() + "\n" +
                        "Orario partenza: " + ticketList.list_of_ticket.get(i).getFlight_booked().getDeparture_time() + "\n" +
                        "Orario di arrivo: " + ticketList.list_of_ticket.get(i).getFlight_booked().getArrival_time() + "\n" +
                        "Prezzo del biglietto: " + ticketList.list_of_ticket.get(i).getFlight_booked().getTicket_price() + "\n");

            }
        }
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
        PanelTicketDisplay = new JPanel();
        PanelTicketDisplay.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 7, new Insets(0, 0, 0, 0), -1, -1));
        PanelTicketDisplay.setBackground(new Color(-12522006));
        Font PanelTicketDisplayFont = this.$$$getFont$$$("Brush Script MT", -1, 26, PanelTicketDisplay.getFont());
        if (PanelTicketDisplayFont != null) PanelTicketDisplay.setFont(PanelTicketDisplayFont);
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$("Agency FB", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-913635));
        label1.setText("Numero passaporto");
        PanelTicketDisplay.add(label1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-12522006));
        label2.setEnabled(true);
        Font label2Font = this.$$$getFont$$$("Brush Script MT", -1, 24, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-913635));
        label2.setText("Ali Agnone");
        PanelTicketDisplay.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Agency FB", -1, 24, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-913635));
        label3.setText("Cognome");
        PanelTicketDisplay.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setEnabled(true);
        Font label4Font = this.$$$getFont$$$("Agency FB", -1, 28, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-913635));
        label4.setText("Trova qui i tuoi biglietti:");
        PanelTicketDisplay.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea1 = new JTextArea();
        textArea1.setBackground(new Color(-2303886));
        textArea1.setForeground(new Color(-16777216));
        PanelTicketDisplay.add(textArea1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        ButtonTextArea1 = new JButton();
        ButtonTextArea1.setBackground(new Color(-2303886));
        ButtonTextArea1.setForeground(new Color(-16777216));
        ButtonTextArea1.setText("--->");
        PanelTicketDisplay.add(ButtonTextArea1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonTextArea3 = new JButton();
        ButtonTextArea3.setBackground(new Color(-2303886));
        ButtonTextArea3.setForeground(new Color(-16777216));
        ButtonTextArea3.setText("--->");
        PanelTicketDisplay.add(ButtonTextArea3, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea3 = new JTextArea();
        textArea3.setBackground(new Color(-2303886));
        textArea3.setForeground(new Color(-16777216));
        PanelTicketDisplay.add(textArea3, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textArea4 = new JTextArea();
        textArea4.setBackground(new Color(-2303886));
        textArea4.setForeground(new Color(-16777216));
        PanelTicketDisplay.add(textArea4, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textArea2 = new JTextArea();
        textArea2.setBackground(new Color(-2303886));
        textArea2.setForeground(new Color(-16777216));
        PanelTicketDisplay.add(textArea2, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        ButtonTextArea2 = new JButton();
        ButtonTextArea2.setBackground(new Color(-2303886));
        ButtonTextArea2.setForeground(new Color(-16777216));
        ButtonTextArea2.setText("--->");
        PanelTicketDisplay.add(ButtonTextArea2, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonTextArea4 = new JButton();
        ButtonTextArea4.setBackground(new Color(-2303886));
        ButtonTextArea4.setForeground(new Color(-16777216));
        ButtonTextArea4.setText("--->");
        PanelTicketDisplay.add(ButtonTextArea4, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldSurname = new JTextField();
        PanelTicketDisplay.add(textFieldSurname, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldPassportnumber = new JTextField();
        PanelTicketDisplay.add(textFieldPassportnumber, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textArea5 = new JTextArea();
        textArea5.setBackground(new Color(-12666100));
        textArea5.setForeground(new Color(-16777216));
        textArea5.setText("");
        PanelTicketDisplay.add(textArea5, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 4, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        Exitbutton = new JButton();
        Exitbutton.setBackground(new Color(-913635));
        Exitbutton.setText("Esci");
        PanelTicketDisplay.add(Exitbutton, new com.intellij.uiDesigner.core.GridConstraints(8, 5, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Uploadmyflights = new JButton();
        Uploadmyflights.setBackground(new Color(-12666100));
        Uploadmyflights.setText("Carica i miei voli");
        PanelTicketDisplay.add(Uploadmyflights, new com.intellij.uiDesigner.core.GridConstraints(8, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return PanelTicketDisplay;
    }
}

