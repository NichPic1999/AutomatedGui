package it.unimol.Aeroporti.Ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffirmationInterface {
    private JPanel panel1;
    private JButton buttonExit;
    public ChangeInterface changeInterface;

    public AffirmationInterface(ChangeInterface changeInterface){
        this.changeInterface = changeInterface;
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
