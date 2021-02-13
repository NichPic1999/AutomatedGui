package it.unimol.Aeroporti.Ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceException { //interfaccia eccezione riguardante il caso del passaporto e nel caso venga acuistato lo stesso biglietto 2 volte
    private JPanel panelInterfaceException;
    private JButton exitButton;
    public ChangeInterface changeInterface;

    public InterfaceException(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPanelInterfaceException() {
        return panelInterfaceException;
    }

    public void setPanelInterfaceException(JPanel panelInterfaceException) {
        this.panelInterfaceException = panelInterfaceException;
    }
}
