package it.unimol.Aeroporti.Ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    private JPanel MenuPanel;
    private JButton stampaBiglietto;
    private JButton bigliettiAcquistati;
    private JButton prenotaBiglietto;
    private ChangeInterface changeInterface;



    public Menu(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;
        prenotaBiglietto.addActionListener(this);
        stampaBiglietto.addActionListener(this);
        bigliettiAcquistati.addActionListener(this);
    }

    public JPanel getMenuPanel() {
        return MenuPanel;
    }

    public JButton getStampaBiglietto() {
        return stampaBiglietto;
    }

    public JButton getBigliettiAcquistati() {
        return bigliettiAcquistati;
    }

    public JButton getPrenotaBiglietto() {
        return prenotaBiglietto;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(getPrenotaBiglietto().getText())) {
            changeInterface.status=1;
            changeInterface.choise();
        }  if(e.getActionCommand().equals(getBigliettiAcquistati().getText())) {
            changeInterface.status=2;
            changeInterface.choise();
        }  if(e.getActionCommand().equals(getStampaBiglietto().getText())) {
            changeInterface.status=3;
            changeInterface.choise();
        }




    }
   }

