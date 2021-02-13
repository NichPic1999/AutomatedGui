package it.unimol.Aeroporti.Ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintCheck {
    private JPanel PrintCheckPanel;
    private JButton esciButton;
    public ChangeInterface changeInterface;

    public PrintCheck(ChangeInterface changeInterface){
        this.changeInterface = changeInterface;
        esciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPrintCheckPanel() {
        return PrintCheckPanel;
    }
}
