package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrink;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JPanel mainPanel;
    private JPanel cbPanel;

//    private int pPizza = 100;
//    private int pBurger = 80;
//    private int pFries = 65;
//    private int pSoftDrink = 55;
//    private int pTea = 50;
//    private int pSundae = 40;

    public FoodOrderingSystem() {
        setContentPane(mainPanel);
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Food Ordering System");
        setLocationRelativeTo(null);
        rbNone.setSelected(true);
        setVisible(true);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String formattedTotal = String.format("%.2f", calculateOrder());
                JOptionPane.showMessageDialog(FoodOrderingSystem.this, "The total price is Php " + formattedTotal + " amount." );
                for(Component comp : cbPanel.getComponents()) {
                    if(comp instanceof JCheckBox) {
                        ((JCheckBox) comp).setSelected(false);
                    }
                }
                rbNone.setSelected(true);
            }
        });
    }


    private double calculateOrder() {
        double total = 0;

        if(cPizza.isSelected()) {
            total += 100;
        }
        if(cBurger.isSelected()) {
            total += 80;
        }
        if(cFries.isSelected()) {
            total += 65;
        }

        if(cSoftDrink.isSelected()) {
            total += 55;
        }
        if(cTea.isSelected()) {
            total += 50;
        }
        if(cSundae.isSelected()) {
            total += 40;
        }

        if(rb5.isSelected()) {
            total -= total * .05;
        }
        if(rb10.isSelected()) {
            total -= total * .10;
        }
        if(rb15.isSelected()) {
            total -= total * .15;
        }

        return total;
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
