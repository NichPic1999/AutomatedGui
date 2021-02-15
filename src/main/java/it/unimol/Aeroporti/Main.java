package it.unimol.Aeroporti;

import it.unimol.Aeroporti.Ui.ChangeInterface;

import javax.swing.*;


public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1980, 800);
        ChangeInterface interface_choise= new ChangeInterface(window);
        interface_choise.choise();

        window.setVisible(true);
    }


}
