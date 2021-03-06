package it.unimol.Aeroporti.Ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Menu implements ActionListener {

    private JPanel MenuPanel;
    private JButton stampaBiglietto;
    private JButton bigliettiAcquistati;
    private JButton prenotaBiglietto;
    public ChangeInterface changeInterface;


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
        if (e.getActionCommand().equals(getPrenotaBiglietto().getText())) {
            changeInterface.status = 1;
            changeInterface.choise();
        }
        if (e.getActionCommand().equals(getBigliettiAcquistati().getText())) {
            changeInterface.status = 2;
            changeInterface.choise();
        }
        if (e.getActionCommand().equals(getStampaBiglietto().getText())) {
            changeInterface.status = 3;
            changeInterface.choise();
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
        MenuPanel = new JPanel();
        MenuPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 1, new Insets(0, 0, 0, 0), -1, -1));
        MenuPanel.setBackground(new Color(-12522006));
        MenuPanel.setForeground(new Color(-4521962));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-593927));
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$("Brush Script MT", -1, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-913635));
        label1.setText("AliAgnone");
        MenuPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stampaBiglietto = new JButton();
        stampaBiglietto.setBackground(new Color(-2579));
        stampaBiglietto.setForeground(new Color(-913635));
        stampaBiglietto.setText("Stampa biglietto");
        MenuPanel.add(stampaBiglietto, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bigliettiAcquistati = new JButton();
        bigliettiAcquistati.setBackground(new Color(-2579));
        bigliettiAcquistati.setForeground(new Color(-913635));
        bigliettiAcquistati.setText(" biglietti acquistati");
        MenuPanel.add(bigliettiAcquistati, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prenotaBiglietto = new JButton();
        prenotaBiglietto.setBackground(new Color(-2579));
        prenotaBiglietto.setForeground(new Color(-913635));
        prenotaBiglietto.setText("Prenota biglietto");
        MenuPanel.add(prenotaBiglietto, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setEnabled(true);
        Font label2Font = this.$$$getFont$$$("Brush Script MT", -1, 26, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-913635));
        label2.setText("Prenota qui il tuo biglietto!");
        MenuPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Brush Script MT", -1, 26, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-913635));
        label3.setText("Visualizza biglietti acquistati");
        MenuPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Brush Script MT", -1, 28, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-913635));
        label4.setText("Stampa qui il tuo biglietto");
        MenuPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Bradley Hand ITC", -1, 28, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-913635));
        label5.setText("VIA COL VENTO ... CON NOI PUOI!");
        MenuPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return MenuPanel;
    }
}

