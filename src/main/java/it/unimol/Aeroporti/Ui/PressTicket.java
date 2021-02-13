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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;


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
    public ChangeInterface changeInterface;

    public PressTicket(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;

        FileOutputTicket fileOutputTicket = new FileOutputTicket();
        UsersList list_of_users = UsersList.getInstance();
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

    public void Press_tickets(String Ticket_id) {
        try {
            FileWriter ticket_write = new FileWriter("Stampa" + Ticket_id + ".txt");

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
        PressPanel = new JPanel();
        PressPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 5, new Insets(0, 0, 0, 0), -1, -1));
        PressPanel.setBackground(new Color(-12522006));
        PressPanel.setEnabled(true);
        Font PressPanelFont = this.$$$getFont$$$("Agency FB", -1, 24, PressPanel.getFont());
        if (PressPanelFont != null) PressPanel.setFont(PressPanelFont);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Brush Script MT", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-913635));
        label1.setText("Ali Agnone");
        PressPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Agency FB", -1, 22, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-913635));
        label2.setText("Cognome");
        PressPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Agency FB", -1, 24, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-913635));
        label3.setText("Numero passaporto");
        PressPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(29, 28), null, 0, false));
        buttontextarea1 = new JButton();
        buttontextarea1.setForeground(new Color(-913635));
        buttontextarea1.setText("  STAMPA  -->");
        PressPanel.add(buttontextarea1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttontextarea2 = new JButton();
        buttontextarea2.setForeground(new Color(-913635));
        buttontextarea2.setText("  STAMPA  -->");
        PressPanel.add(buttontextarea2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea1 = new JTextArea();
        textArea1.setBackground(new Color(-2303886));
        Font textArea1Font = this.$$$getFont$$$("Modern No. 20", -1, 18, textArea1.getFont());
        if (textArea1Font != null) textArea1.setFont(textArea1Font);
        textArea1.setForeground(new Color(-16777216));
        PressPanel.add(textArea1, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textArea2 = new JTextArea();
        textArea2.setBackground(new Color(-2303886));
        Font textArea2Font = this.$$$getFont$$$("Modern No. 20", -1, 18, textArea2.getFont());
        if (textArea2Font != null) textArea2.setFont(textArea2Font);
        textArea2.setForeground(new Color(-16777216));
        PressPanel.add(textArea2, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textFieldSurname = new JTextField();
        PressPanel.add(textFieldSurname, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldPassport = new JTextField();
        PressPanel.add(textFieldPassport, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 28), null, 0, false));
        buttontextarea3 = new JButton();
        buttontextarea3.setForeground(new Color(-913635));
        buttontextarea3.setText("  STAMPA  -->");
        PressPanel.add(buttontextarea3, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea3 = new JTextArea();
        textArea3.setBackground(new Color(-2303886));
        Font textArea3Font = this.$$$getFont$$$("Modern No. 20", -1, 18, textArea3.getFont());
        if (textArea3Font != null) textArea3.setFont(textArea3Font);
        textArea3.setForeground(new Color(-16777216));
        PressPanel.add(textArea3, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        buttontextarea4 = new JButton();
        buttontextarea4.setForeground(new Color(-913635));
        buttontextarea4.setText("  STAMPA  -->");
        PressPanel.add(buttontextarea4, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea4 = new JTextArea();
        textArea4.setBackground(new Color(-2303886));
        Font textArea4Font = this.$$$getFont$$$("Modern No. 20", -1, 18, textArea4.getFont());
        if (textArea4Font != null) textArea4.setFont(textArea4Font);
        textArea4.setForeground(new Color(-16777216));
        PressPanel.add(textArea4, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        Uploadmyflights = new JButton();
        Uploadmyflights.setBackground(new Color(-12666100));
        Uploadmyflights.setForeground(new Color(-593927));
        Uploadmyflights.setText("Carica i miei voli");
        PressPanel.add(Uploadmyflights, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(122, 35), null, 0, false));
        exitButton = new JButton();
        exitButton.setBackground(new Color(-913635));
        exitButton.setForeground(new Color(-4474182));
        exitButton.setHideActionText(true);
        exitButton.setText("Exit");
        PressPanel.add(exitButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return PressPanel;
    }
}




